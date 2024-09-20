package ui;

import core.TASkOcupado;
import ext.EmailNotificator;

public class TASkOcupadoApp {

    public static void main(String[] args) {
        var taskOcupado = new TASkOcupado();
        var taskOcupadoController = new TASkOcupadoController(taskOcupado);

        EmailNotificator notificator = new EmailNotificator();

        taskOcupado.addObserverToAssigner(notificator);
        
        // taskOcupadoView display
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TASkOcupadoView(taskOcupado, taskOcupadoController).setVisible(true);
            }
        });
    }

}
