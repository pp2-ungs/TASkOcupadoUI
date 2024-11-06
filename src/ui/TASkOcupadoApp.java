package ui;

import core.CoreFactory;
import java.io.File;
import logger.Logger;

public class TASkOcupadoApp {

    /**
     * @param args[0] = config.properties path
     */
    public static void main(String[] args) {
        
        // init logger
        var fileName = System.getProperty("user.home") + File.separator + "AssignmentLogger.txt"; // FIXME
        var logger = new Logger(fileName);
        
        // init model
        var taskOcupado = new CoreFactory(args.length > 0 ? args[0]: "").create();
        taskOcupado.addObserver(logger);

        // init view
        java.awt.EventQueue.invokeLater(() -> new TASkOcupadoView(taskOcupado));
    }

}
