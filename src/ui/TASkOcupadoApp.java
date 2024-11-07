package ui;

import core.TASkOcupadoFactory;

public class TASkOcupadoApp {
    
     /**
     * @param args[0] = config.properties path
     */
    public static void main(String[] args) {
        // init model
        var taskOcupado = new TASkOcupadoFactory(args.length > 0 ? args[0]: "").create();

        // init view
        java.awt.EventQueue.invokeLater(() -> new TASkOcupadoView(taskOcupado));
    }

}