package ui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import com.formdev.flatlaf.themes.FlatMacDarkLaf; // Do not remove it
import core.Member;
import core.Observer;
import core.TASkOcupado;
import core.Task;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TASkOcupadoView extends javax.swing.JFrame implements Observer {

    private static final String LIGHT = "com.formdev.flatlaf.themes.FlatMacLightLaf";
    private static final String DARK = "com.formdev.flatlaf.themes.FlatMacDarkLaf";
    private static final String SIMPLE = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
    private static final String CLASSIC = "javax.swing.plaf.metal.MetalLookAndFeel";
    private static final String UGLY = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

    private TASkOcupadoController taskOcupadoController; // posa dice que acá va el controlador
    private TASkOcupado taskOcupado;                     // posa dice que acá va el modelo

    public TASkOcupadoView(TASkOcupado taskOcupado) {
        this.taskOcupado = taskOcupado;
        this.taskOcupado.addObserver(this);
        this.taskOcupadoController = new TASkOcupadoController(taskOcupado);

        // Swing
        initComponents();
        setAppearance(DARK);
        setUpNotificationMethodComboBox();
        setUpTasksComboBox();
        setUpMembersComboBox();
    }

    public void setLookAndFeel(String lookAndFeel) {
        lightRadioButtonMenuItem.setSelected(lookAndFeel.equals(LIGHT));
        darkRadioButtonMenuItem.setSelected(lookAndFeel.equals(DARK));
        simpleRadioButtonMenuItem.setSelected(lookAndFeel.equals(SIMPLE));
        classicRadioButtonMenuItem.setSelected(lookAndFeel.equals(CLASSIC));
        uglyRadioButtonMenuItem.setSelected(lookAndFeel.equals(UGLY));
    }

    public void setAppearance(String lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e) {
            System.out.println(e);
            setLookAndFeel(CLASSIC);
        }
        SwingUtilities.updateComponentTreeUI(this);
        pack();
        setLookAndFeel(lookAndFeel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        assignTaskButton = new javax.swing.JButton();
        notificationMethodComboBox = new javax.swing.JComboBox<>();
        memberComboBox = new javax.swing.JComboBox<>();
        notificationsScrollPane = new javax.swing.JScrollPane();
        notificationsTable = new javax.swing.JTable();
        taskComboBox = new javax.swing.JComboBox<>();
        notificationMethodScrollPane = new javax.swing.JScrollPane();
        notificationMethodTable = new javax.swing.JTable();
        addNotificationMethodButton = new javax.swing.JButton();
        removeNotificationMethodButton = new javax.swing.JButton();
        appMenuBar = new javax.swing.JMenuBar();
        appMenu = new javax.swing.JMenu();
        quitMenuItem = new javax.swing.JMenuItem();
        appearanceMenu = new javax.swing.JMenu();
        lightRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        darkRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        simpleRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        classicRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        uglyRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        aboutMenu = new javax.swing.JMenu();
        copyrightMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        assignTaskButton.setText("Assign");
        assignTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignTaskButtonActionPerformed(evt);
            }
        });

        notificationMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Notify by" }));
        notificationMethodComboBox.setToolTipText("");
        notificationMethodComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificationMethodComboBoxActionPerformed(evt);
            }
        });

        memberComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select member" }));
        memberComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberComboBoxActionPerformed(evt);
            }
        });

        notificationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Task", "Member"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        notificationsTable.setColumnSelectionAllowed(true);
        notificationsTable.getTableHeader().setReorderingAllowed(false);
        notificationsScrollPane.setViewportView(notificationsTable);
        notificationsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (notificationsTable.getColumnModel().getColumnCount() > 0) {
            notificationsTable.getColumnModel().getColumn(0).setMinWidth(4);
            notificationsTable.getColumnModel().getColumn(0).setPreferredWidth(4);
        }

        taskComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select task" }));
        taskComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskComboBoxActionPerformed(evt);
            }
        });

        notificationMethodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seleted notifcation methods"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        notificationMethodTable.setColumnSelectionAllowed(true);
        notificationMethodTable.getTableHeader().setReorderingAllowed(false);
        notificationMethodTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                notificationMethodTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                notificationMethodTableFocusLost(evt);
            }
        });
        notificationMethodScrollPane.setViewportView(notificationMethodTable);
        notificationMethodTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (notificationMethodTable.getColumnModel().getColumnCount() > 0) {
            notificationMethodTable.getColumnModel().getColumn(0).setResizable(false);
        }

        addNotificationMethodButton.setText("Add");
        addNotificationMethodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNotificationMethodButtonActionPerformed(evt);
            }
        });

        removeNotificationMethodButton.setText("Remove");
        removeNotificationMethodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeNotificationMethodButtonActionPerformed(evt);
            }
        });

        appMenu.setText("App");

        quitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        quitMenuItem.setText("Quit");
        quitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitMenuItemActionPerformed(evt);
            }
        });
        appMenu.add(quitMenuItem);

        appMenuBar.add(appMenu);

        appearanceMenu.setText("Appearance");

        lightRadioButtonMenuItem.setSelected(true);
        lightRadioButtonMenuItem.setText("Light");
        lightRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lightRadioButtonMenuItemActionPerformed(evt);
            }
        });
        appearanceMenu.add(lightRadioButtonMenuItem);

        darkRadioButtonMenuItem.setSelected(true);
        darkRadioButtonMenuItem.setText("Dark");
        darkRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkRadioButtonMenuItemActionPerformed(evt);
            }
        });
        appearanceMenu.add(darkRadioButtonMenuItem);

        simpleRadioButtonMenuItem.setSelected(true);
        simpleRadioButtonMenuItem.setText("Simple");
        simpleRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpleRadioButtonMenuItemActionPerformed(evt);
            }
        });
        appearanceMenu.add(simpleRadioButtonMenuItem);

        classicRadioButtonMenuItem.setSelected(true);
        classicRadioButtonMenuItem.setText("Classic");
        classicRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classicRadioButtonMenuItemActionPerformed(evt);
            }
        });
        appearanceMenu.add(classicRadioButtonMenuItem);

        uglyRadioButtonMenuItem.setSelected(true);
        uglyRadioButtonMenuItem.setText("Ugly");
        uglyRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uglyRadioButtonMenuItemActionPerformed(evt);
            }
        });
        appearanceMenu.add(uglyRadioButtonMenuItem);

        appMenuBar.add(appearanceMenu);

        aboutMenu.setText("About");

        copyrightMenuItem.setText("Copyright");
        aboutMenu.add(copyrightMenuItem);

        appMenuBar.add(aboutMenu);

        setJMenuBar(appMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(notificationMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(addNotificationMethodButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(notificationMethodScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(removeNotificationMethodButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(taskComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(assignTaskButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notificationsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(memberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notificationMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taskComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNotificationMethodButton)
                    .addComponent(assignTaskButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeNotificationMethodButton)
                    .addComponent(memberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(notificationMethodScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                    .addComponent(notificationsScrollPane))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitMenuItemActionPerformed

    private void lightRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lightRadioButtonMenuItemActionPerformed
        setAppearance(LIGHT);
    }//GEN-LAST:event_lightRadioButtonMenuItemActionPerformed

    private void darkRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkRadioButtonMenuItemActionPerformed
        setAppearance(DARK);
    }//GEN-LAST:event_darkRadioButtonMenuItemActionPerformed

    private void simpleRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpleRadioButtonMenuItemActionPerformed
        setAppearance(SIMPLE);
    }//GEN-LAST:event_simpleRadioButtonMenuItemActionPerformed

    private void classicRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classicRadioButtonMenuItemActionPerformed
        setAppearance(CLASSIC);
    }//GEN-LAST:event_classicRadioButtonMenuItemActionPerformed

    private void uglyRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uglyRadioButtonMenuItemActionPerformed
        setAppearance(UGLY);
    }//GEN-LAST:event_uglyRadioButtonMenuItemActionPerformed

    private void assignTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignTaskButtonActionPerformed
        taskOcupadoController.assignTask(taskComboBox.getSelectedItem().toString(), memberComboBox.getSelectedItem().toString());
    }//GEN-LAST:event_assignTaskButtonActionPerformed

    private void addNotificationMethodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNotificationMethodButtonActionPerformed
        DefaultTableModel m = (DefaultTableModel) notificationMethodTable.getModel();
        m.addRow(new Object[]{
            notificationMethodComboBox.getSelectedItem()
        });
        notificationMethodTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        assignTaskButton.setEnabled(!(taskComboBox.getSelectedIndex() == 0 || memberComboBox.getSelectedIndex() == 0 || notificationMethodTable.getRowCount() <= 0));
    }//GEN-LAST:event_addNotificationMethodButtonActionPerformed

    private void notificationMethodComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificationMethodComboBoxActionPerformed
        if (notificationMethodComboBox.getSelectedIndex() <= 0) {
            addNotificationMethodButton.setEnabled(false);
            removeNotificationMethodButton.setEnabled(false);
            assignTaskButton.setEnabled(false);
        } else {
            addNotificationMethodButton.setEnabled(true);
        }
    }//GEN-LAST:event_notificationMethodComboBoxActionPerformed

    private void removeNotificationMethodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeNotificationMethodButtonActionPerformed
        if (notificationMethodTable.getRowCount() == 0 || notificationMethodTable.getSelectedRow() == -1) {
            return;
        }
        DefaultTableModel m = (DefaultTableModel) notificationMethodTable.getModel();
        m.removeRow(notificationMethodTable.getSelectedRow());
        notificationMethodTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }//GEN-LAST:event_removeNotificationMethodButtonActionPerformed

    private void notificationMethodTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_notificationMethodTableFocusGained
        setUpRemoveButton();
    }//GEN-LAST:event_notificationMethodTableFocusGained

    private void notificationMethodTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_notificationMethodTableFocusLost
        setUpRemoveButton();
    }//GEN-LAST:event_notificationMethodTableFocusLost

    private void taskComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskComboBoxActionPerformed
        assignTaskButton.setEnabled(!(taskComboBox.getSelectedIndex() == 0 || memberComboBox.getSelectedIndex() == 0 || notificationMethodTable.getRowCount() <= 0));
    }//GEN-LAST:event_taskComboBoxActionPerformed

    private void memberComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberComboBoxActionPerformed
        assignTaskButton.setEnabled(!(taskComboBox.getSelectedIndex() == 0 || memberComboBox.getSelectedIndex() == 0 || notificationMethodTable.getRowCount() <= 0));
    }//GEN-LAST:event_memberComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TASkOcupadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TASkOcupadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TASkOcupadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TASkOcupadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TOFrame().setVisible(true);
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TASkOcupadoView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JButton addNotificationMethodButton;
    private javax.swing.JMenu appMenu;
    private javax.swing.JMenuBar appMenuBar;
    private javax.swing.JMenu appearanceMenu;
    private javax.swing.JButton assignTaskButton;
    private javax.swing.JRadioButtonMenuItem classicRadioButtonMenuItem;
    private javax.swing.JMenuItem copyrightMenuItem;
    private javax.swing.JRadioButtonMenuItem darkRadioButtonMenuItem;
    private javax.swing.JRadioButtonMenuItem lightRadioButtonMenuItem;
    private javax.swing.JComboBox<String> memberComboBox;
    private javax.swing.JComboBox<String> notificationMethodComboBox;
    private javax.swing.JScrollPane notificationMethodScrollPane;
    private javax.swing.JTable notificationMethodTable;
    private javax.swing.JScrollPane notificationsScrollPane;
    private javax.swing.JTable notificationsTable;
    private javax.swing.JMenuItem quitMenuItem;
    private javax.swing.JButton removeNotificationMethodButton;
    private javax.swing.JRadioButtonMenuItem simpleRadioButtonMenuItem;
    private javax.swing.JComboBox<String> taskComboBox;
    private javax.swing.JRadioButtonMenuItem uglyRadioButtonMenuItem;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Object event) {

        //\begin{FIXME}
        var timestamp = (String) ((Map) event).get("Time");
        var taskDescription = (String) ((Map) event).get("Task");
        var memberName = (String) ((Map) event).get("Name");
        //\end{FIXME}

        var notification = "(" + timestamp + ")  Task: [" + taskDescription + "]  →  Member: [" + memberName + "]\n";

        DefaultTableModel m = (DefaultTableModel) notificationsTable.getModel();
        m.addRow(new Object[]{
            timestamp,
            taskDescription,
            memberName
        });
        System.out.println("[debuggin] view update: \n" + event);
    }

    private void setUpNotificationMethodComboBox() {
        Set<Observer> observersSet = null;
        try {
            observersSet = taskOcupado.getNotificationMethods();
        } catch (Exception e) {
            // no hay observers
            observersSet = new HashSet<>();
        }

        var observersList = new ArrayList<>(observersSet);
        observersList.sort(Comparator.comparing(Observer::getName));

        String[] observerNames = new String[observersList.size() + 1];
        observerNames[0] = "Notify by";

        int i = 1;
        for (Observer o : observersList) {
            observerNames[i++] = o.getName();
        }

        notificationMethodComboBox.setModel(new DefaultComboBoxModel(observerNames));
        notificationMethodComboBox.setSelectedIndex(0);
    }

    private void setUpTasksComboBox() {
        Set<Task> tasksSet = null;
        try {
            tasksSet = taskOcupado.getTasks();
        } catch (Exception e) {
            // no hay tasks
            tasksSet = new HashSet<>();
        }

        List<Task> tasksList = new ArrayList<>(tasksSet);
        tasksList.sort(Comparator.comparing(Task::getDescription));

        String[] tasksDescription = new String[tasksList.size() + 1];
        tasksDescription[0] = "Select task";

        int i = 1;
        for (Task t : tasksList) {
            tasksDescription[i++] = t.getDescription();
        }

        taskComboBox.setModel(new DefaultComboBoxModel(tasksDescription));
        taskComboBox.setSelectedIndex(0);
    }

    private void setUpMembersComboBox() {
        Set<Member> membersSet = null;
        try {
            membersSet = taskOcupado.getMembers();
        } catch (Exception e) {
            // no hay tasks
            membersSet = new HashSet<>();
        }

        List<Member> membersList = new ArrayList<>(membersSet);
        membersList.sort(Comparator.comparing(Member::getName));

        String[] membersName = new String[membersList.size() + 1];
        membersName[0] = "Select member";

        int i = 1;
        for (Member m : membersList) {
            membersName[i++] = m.getName();
        }

        memberComboBox.setModel(new DefaultComboBoxModel(membersName));
        memberComboBox.setSelectedIndex(0);
    }

    private void setUpRemoveButton() {
        removeNotificationMethodButton.setEnabled(!(notificationMethodTable.getRowCount() == 0 || notificationMethodTable.getSelectedRow() == -1));
    }

}
