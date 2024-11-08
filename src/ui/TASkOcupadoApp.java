package ui;

import core.TASkOcupadoFactory;
import logger.Logger;

public class TASkOcupadoApp {

    /**
     * @param args[0] = config.properties path
     * @param args[0] = logger.txt path
     */
    public static void main(String[] args) {

        // init model
        var taskOcupado = new TASkOcupadoFactory(args.length > 0 ? args[0]: "").create();
        
        // init logger
        var logger = new Logger(args.length > 2 ? args[1]: "");
        
        taskOcupado.addObserver(logger);

        // init view
        java.awt.EventQueue.invokeLater(() -> new TASkOcupadoView(taskOcupado));
    }

}
