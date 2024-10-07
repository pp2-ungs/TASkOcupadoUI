package ui;

import core.TASkOcupado;

public class TASkOcupadoApp {

    public static void main(String[] args) {
        // init model
        var taskAssignerAdapter = new TASkOcupado().init();

        // init view
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TASkOcupadoView(taskAssignerAdapter).setVisible(true);
            }
        });
    }

}
