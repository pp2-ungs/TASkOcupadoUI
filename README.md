# TASkOcupadoUI

> **UI module** of the TASkOcupado task-management system — a Java Swing desktop application that lets users assign tasks to people and watch real-time assignment notifications.

© 2024 [Ebertz](https://github.com/xebertz), [López](https://github.com/Gonza-JL), [Rondelli](https://github.com/rondelli)

---

## Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Dependencies](#dependencies)
- [Building](#building)
- [Running](#running)
- [Configuration](#configuration)
- [UI Walkthrough](#ui-walkthrough)
- [Notification Integrations](#notification-integrations)
- [Theming](#theming)
- [Related Modules](#related-modules)

---

## Overview

**TASkOcupado** ("TASkOccupied") is a desktop task-management system built in Java. This repository contains the **UI layer** (`TASkOcupadoUI`), which provides a graphical interface on top of the core domain logic (`TASkOcupadoCore`).

The application allows an operator to:

1. Browse the list of available **tasks** and registered **people** loaded from the core model.
2. Select a task and a person from drop-down menus and click **Assign** to associate them.
3. Watch every successful assignment appear instantly in a timestamped **notifications table**.

---

## Architecture

The project follows a classic **Model-View-Controller (MVC)** pattern reinforced by the **Observer** design pattern:

```
TASkOcupadoCore  ←─────────────────────────────────────┐
   (Model)                                             │
      │  addObserver(view)                             │
      │  addObserver(controller)                       │
      ▼                                                │
TASkOcupadoController ──assignTask()──► TASkOcupado    │
      │                                     │          │
      │ loadComboBoxes()                    │ notifies observers
      ▼                                     ▼          │
TASkOcupadoView  ◄──────────── update(event) ──────────┘
   (JFrame)
```

| Class | Role |
|---|---|
| `TASkOcupadoApp` | Entry point; creates the core model via `TASkOcupadoFactory` and hands it to the view |
| `TASkOcupadoView` | Swing `JFrame`; renders drop-downs, the Assign button, and the notifications table; implements `Observer` |
| `TASkOcupadoController` | Mediates between the view and the model; populates combo-boxes; delegates `assignTask` calls; implements `Observer` |

Both the view and the controller are registered as **observers** of the core `TASkOcupado` model. When an assignment is made the model fires an event containing a `Map` with the keys `"Time"`, `"Task"`, and `"Name"`, which the view uses to append a new row to the notifications table.

---

## Features

- **Task assignment** — select any task and any person from sorted combo-boxes; the Assign button is enabled only when both have been selected.
- **Live notification log** — every assignment is appended to a read-only table showing timestamp, task description, and the assigned person's name.
- **Automatic refresh** — because the controller also observes the model, any external change to the task or people lists (e.g., another module adding data) is reflected in the combo-boxes automatically.
- **Multiple UI themes** — five look-and-feel options available from the Appearance menu (see [Theming](#theming)).
- **External notification plugins** — optional email and Telegram notifier JARs can be wired in (see [Notification Integrations](#notification-integrations)).
- **Configurable** — accepts a `config.properties` file path as a command-line argument.

---

## Prerequisites

| Requirement | Version |
|---|---|
| Java (JDK) | 22 or later |
| Apache Ant | 1.10+ (or use the NetBeans IDE build action) |
| TASkOcupadoCore | built JAR must be present at `../TASkOcupadoCore/dist/TASkOcupadoCore.jar` |

---

## Project Structure

```
TASkOcupadoUI/
├── src/
│   └── ui/
│       ├── TASkOcupadoApp.java        # Entry point
│       ├── TASkOcupadoController.java # MVC controller / Observer
│       ├── TASkOcupadoView.java       # Swing JFrame / Observer
│       └── TASkOcupadoView.form       # NetBeans GUI designer form
├── lib/                               # Bundled third-party JARs
├── nbproject/                         # NetBeans project metadata
├── build.xml                          # Ant build script
└── manifest.mf                        # JAR manifest
```

---

## Dependencies

All runtime JARs are included in the `lib/` directory.

| Library | Version | Purpose |
|---|---|---|
| [FlatLaf](https://www.formdev.com/flatlaf/) | 3.5.1 | Modern flat look-and-feel (Light / Dark themes) |
| [Gson](https://github.com/google/gson) | 2.11.0 | JSON serialisation / deserialisation |
| [Jakarta Mail](https://eclipse-ee4j.github.io/mail/) | 2.0.3 | Email notification support |
| Jakarta Mail API | 2.1.3 | Email API interfaces |
| Jakarta Activation API | 2.1.3 | MIME type handling |
| Angus Activation | 2.0.2 | Jakarta Activation implementation |
| [TelegramBots](https://github.com/rubenlagus/TelegramBots) | 6.7.0 | Telegram bot notification support |
| TASkOcupadoCore | — | Core domain model (tasks, people, factory, observer interfaces) |

Optional extension JARs (not bundled; resolved at runtime from a shared path):

- `EmailNotifier.jar` — sends email notifications on task assignment.
- `TelegramNotifier.jar` — sends Telegram messages on task assignment.

---

## Building

The project is a standard **NetBeans / Apache Ant** project.

**From the command line:**

```bash
# build the core module first (required dependency)
cd ../TASkOcupadoCore
ant jar

# then build the UI module
cd ../TASkOcupadoUI
ant jar
```

The resulting JAR is written to `dist/TASkOcupadoUI.jar`.

**From NetBeans IDE:** Open the project and use *Build → Clean and Build Project*.

---

## Running

```bash
java -jar dist/TASkOcupadoUI.jar [path/to/config.properties]
```

The `config.properties` path is optional. When omitted the application uses an empty string, which causes `TASkOcupadoFactory` to fall back to its default configuration.

---

## Configuration

The `config.properties` file is consumed by `TASkOcupadoCore`'s `TASkOcupadoFactory`. Refer to the core module's documentation for the full list of supported keys (data source paths, notification settings, etc.).

---

## UI Walkthrough

```
┌─────────────────────────────────────────────────────────────────┐
│  App   Appearance   About                                        │
├─────────────────────────────────────────────────────────────────┤
│  [ Select task ▼                              ] [ Assign ]       │
│  [ Select person ▼                            ]                  │
│ ┌──────────────────────────────────────────────────────────────┐ │
│ │ Time          │ Task                     │ Person            │ │
│ │───────────────┼──────────────────────────┼───────────────────│ │
│ │ 2024-01-15 …  │ Implement login          │ Jane Doe          │ │
│ │ 2024-01-15 …  │ Write unit tests         │ John Smith        │ │
│ └──────────────────────────────────────────────────────────────┘ │
└─────────────────────────────────────────────────────────────────┘
```

1. **Task combo-box** — lists all tasks retrieved from the model, sorted alphabetically.
2. **Person combo-box** — lists all people retrieved from the model, sorted alphabetically.
3. **Assign button** — becomes active only when both a task and a person are selected. Clicking it calls `TASkOcupadoController.assignTask()`, which delegates to the core model.
4. **Notifications table** — read-only; a new row is appended every time the view receives an `update` event from the model. Columns: `Time`, `Task`, `Person`.

Menu bar:

| Menu | Item | Action |
|---|---|---|
| App | Quit (`Ctrl+Q`) | Exits the application |
| Appearance | Light / Dark / Simple / Classic / Ugly | Changes the Swing look-and-feel at runtime |
| About | Copyright | Displays copyright information |

---

## Notification Integrations

When the optional extension JARs are present on the classpath (loaded by `TASkOcupadoCore` at startup), assignments also trigger:

- **Email notifications** via Jakarta Mail — sends an email to configured recipients each time a task is assigned.
- **Telegram notifications** via TelegramBots — posts a message to a configured Telegram chat/bot each time a task is assigned.

Configuration for these integrations (SMTP credentials, bot token, chat ID, etc.) is handled through `config.properties` and the core module.

---

## Theming

Five look-and-feel options are available under the **Appearance** menu. The selection takes effect immediately without restarting the application.

| Option | Look and Feel class |
|---|---|
| **Light** | `FlatMacLightLaf` (FlatLaf) |
| **Dark** | `FlatMacDarkLaf` (FlatLaf) — *default* |
| **Simple** | `NimbusLookAndFeel` |
| **Classic** | `MetalLookAndFeel` |
| **Ugly** | `WindowsLookAndFeel` |

---

## Related Modules

| Module | Description |
|---|---|
| [TASkOcupadoCore](https://github.com/pp2-ungs/TASkOcupadoCore) | Domain model: tasks, people, assignment logic, observer interfaces, factory |
| EmailNotifier | Optional plugin — email notifications on assignment |
| TelegramNotifier | Optional plugin — Telegram notifications on assignment |
