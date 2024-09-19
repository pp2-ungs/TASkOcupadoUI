package ui;

import core.TASkOcupado;

public class TASkOcupadoApp {

    public static void main(String[] args) {
        var taskOcupado = new TASkOcupado();
        var taskOcupadoController = new TASkOcupadoController(taskOcupado);

        //Notificator notificator = new ConcreteNotificator();

        //taskOcupado.getTaskAssigner().addObserver(notificator);

        // taskOcupadoView display
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TASkOcupadoView(taskOcupado, taskOcupadoController).setVisible(true);
            }
        });
    }

}
