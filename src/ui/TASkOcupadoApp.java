package ui;

import core.CoreFactory;

public class TASkOcupadoApp {

    public static void main(String[] args) {
        // init domain model
        var coreFactory = new CoreFactory("");
        var taskOcupado = coreFactory.create();

        // init view
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TASkOcupadoView(taskOcupado).setVisible(true);
            }
        });
    }

}
