package utils;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {
    public static Logger getLogger(String className) {
        Logger logger = Logger.getLogger(className);
        try {
            FileHandler fh = new FileHandler("logs/app.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (Exception e) {
            System.out.println("Failed to set up logger: " + e.getMessage());
        }
        return logger;
    }
}
