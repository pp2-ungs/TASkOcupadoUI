package ui;

import core.CoreFactory;

public class TASkOcupadoApp {
    
     /**
     * @param args[0] = config.properties path
     */
    public static void main(String[] args) {
        // init model
        var taskOcupado = new CoreFactory(args.length > 0 ? args[0]: "").create();

        // init view
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TASkOcupadoView(taskOcupado).setVisible(true);
            }
        });
    }

}
