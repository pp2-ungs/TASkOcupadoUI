package ui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import com.formdev.flatlaf.themes.FlatMacDarkLaf; // Do not remove it
import core.Member;
import core.Notificator;
import core.TASkOcupado;
import core.Observer;
import core.Task;

@SuppressWarnings("serial")
public class TASkOcupadoView extends javax.swing.JFrame implements Observer, Notificator {

    private static final String LIGHT = "com.formdev.flatlaf.themes.FlatMacLightLaf";
    private static final String DARK = "com.formdev.flatlaf.themes.FlatMacDarkLaf";
    private static final String SIMPLE = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
    private static final String CLASSIC = "javax.swing.plaf.metal.MetalLookAndFeel";
    private static final String UGLY = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

    private TASkOcupadoController taskOcupadoController;

    public TASkOcupadoView(TASkOcupado taskOcupado) {
        taskOcupado.addObserverToAssigner(this); // esto no hace nada
        taskOcupadoController = new TASkOcupadoController(taskOcupado);

        // Swing
        initComponents();
        setAppearance(DARK);
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tasksComboBox = new javax.swing.JComboBox<String>();
        memberComboBox = new javax.swing.JComboBox<String>();
        asignTaskButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        notificationsTextArea = new javax.swing.JTextArea();
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

        tasksComboBox.addItem("Select a task...");
        for (String task: taskOcupadoController.obtainTasks()) { tasksComboBox.addItem(task); } 
        tasksComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tasksComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskTextFieldActionPerformed(evt);
            }
        });

        memberComboBox.addItem("Select a member...");
        for (String member: taskOcupadoController.obtainMembers()) { memberComboBox.addItem(member); } 

        asignTaskButton.setText("Assign");
        asignTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignTaskButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        notificationsTextArea.setColumns(20);
        notificationsTextArea.setRows(5);
        jScrollPane1.setViewportView(notificationsTextArea);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tasksComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(memberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(asignTaskButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton)
                    .addComponent(asignTaskButton)
                    .addComponent(tasksComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void taskTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taskTextFieldActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        notificationsTextArea.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

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

    private void asignTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignTaskButtonActionPerformed
        if (tasksComboBox.getSelectedIndex() != 0 && memberComboBox.getSelectedIndex() != 0) {
            taskOcupadoController.assignTask(tasksComboBox.getSelectedItem().toString(), memberComboBox.getSelectedItem().toString());
            System.out.println(tasksComboBox.getSelectedItem().toString() + " " + memberComboBox.getSelectedItem().toString());
        }
    }//GEN-LAST:event_asignTaskButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenu appMenu;
    private javax.swing.JMenuBar appMenuBar;
    private javax.swing.JMenu appearanceMenu;
    private javax.swing.JButton asignTaskButton;
    private javax.swing.JRadioButtonMenuItem classicRadioButtonMenuItem;
    private javax.swing.JButton clearButton;
    private javax.swing.JMenuItem copyrightMenuItem;
    private javax.swing.JRadioButtonMenuItem darkRadioButtonMenuItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButtonMenuItem lightRadioButtonMenuItem;
    private javax.swing.JComboBox<String> memberComboBox;
    private javax.swing.JTextArea notificationsTextArea;
    private javax.swing.JMenuItem quitMenuItem;
    private javax.swing.JRadioButtonMenuItem simpleRadioButtonMenuItem;
    private javax.swing.JComboBox<String> tasksComboBox;
    private javax.swing.JRadioButtonMenuItem uglyRadioButtonMenuItem;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Task task, Member member, Object obj) {
        notify(task, member, obj);
    }

    @Override
    public void notify(Task task, Member member, Object msg) {
        notificationsTextArea.append((String) msg);
    }

}
