package ui;

import core.Member;
import observer.Observer;
import core.TASkOcupado;
import core.Task;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TASkOcupadoController implements Observer {

    private TASkOcupado taskOcupado;
    private TASkOcupadoView taskOcupadoView;

    private Map<String, Task> tasks;
    private Map<String, Member> members;
    private Map<String, Observer> notifiers;

    public TASkOcupadoController(TASkOcupado taskOcupado, TASkOcupadoView taskOcupadoView) {
        this.taskOcupado = taskOcupado;
        this.taskOcupado.addObserver(this);

        this.taskOcupadoView = taskOcupadoView;

        loadData();
    }

    private void loadData() {
        tasks = new HashMap<>();
        members = new HashMap<>();
        notifiers = new HashMap<>();

        taskOcupado.getTasks().forEach(task -> tasks.put(task.toString(), task));
        taskOcupado.getMembers().forEach(member -> members.put(member.toString(), member));
        taskOcupado.getNotifiers().forEach(notifier -> notifiers.put(notifier.getClass().getSimpleName(), notifier));

        loadTasksComboBox();
        loadMembersComboBox();
        loadNotifiersComboBox();
    }

    public void assignTask(String task, String member) {
        taskOcupado.assignTask(tasks.get(task), members.get(member));
    }

    @Override
    public void update(Object event) {
        loadData(); // por si cambian miembros y tasks en el modelo
        System.out.println("[debugging] controller update: \n" + event);
    }

    private void loadTasksComboBox() {
        Set<String> tasksSet = tasks.keySet();

        List<String> tasksList = new ArrayList<>(tasksSet);
        tasksList.sort(Comparator.comparing(String::toString));
        tasksList.addFirst("Select task");

        String[] tasksArray = tasksList.toArray(new String[0]);
        taskOcupadoView.loadTasksComboBox(tasksArray);
    }

    private void loadMembersComboBox() {
        Set<String> membersSet = members.keySet();

        List<String> membersList = new ArrayList<>(membersSet);
        membersList.sort(Comparator.comparing(String::toString));
        membersList.addFirst("Select member");

        String[] membersArray = membersList.toArray(new String[0]);
        taskOcupadoView.loadMembersComboBox(membersArray);
    }

    private void loadNotifiersComboBox() {
        Set<String> notifiersSet = notifiers.keySet();

        List<String> notifiersList = new ArrayList<>(notifiersSet);
        notifiersList.sort(Comparator.comparing(String::toString));
        notifiersList.addFirst("Notify by");

        String[] notificatorsArray = notifiersList.toArray(new String[0]);
        taskOcupadoView.loadNotifiersComboBox(notificatorsArray);
    }

    public void activeNotifier(String notifier) {
        taskOcupado.activeTaskAssignerObserver(notifiers.get(notifier));
    }

    public void deactiveNotifier(String notifier) {
        taskOcupado.deactiveObserverToTaskAssigner(notifiers.get(notifier));
    }

}
