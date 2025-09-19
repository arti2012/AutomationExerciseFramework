// package utils;

// import org.apache.log4j.FileAppender;
// import org.apache.log4j.Logger;
// import org.apache.log4j.PatternLayout;
// import java.text.SimpleDateFormat;
// import java.util.Date;


// /**
//  * This class provides helper methods for logging messages at different levels.
//  */
// public class LoggerHandler {

//     private static final Logger logger = Logger.getLogger(LoggerHandler.class);
   
//     static {
//         try {
//             String logFileName = "logs/avonCycle_" + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + ".log";
//             logger.addAppender(new FileAppender(new PatternLayout("%d{ISO8601} %-5p %c - %m%n"), logFileName, true));
//         } catch (Exception e) {
//             System.err.println("Logger initialization failed: " + e.getMessage());
//         }
//     }
    

//     /**
//      * Logs an info-level message.
//      * @param message The message to log.
//      */
//     public void info(String message) {
//         logger.info(message);
//     }

//     /**
//      * Logs a debug-level message.
//      * @param message The message to log.
//      */
//     public  void debug(String message) {
//         logger.debug(message);
//     }

//     /**
//      * Logs a warn-level message.
//      * @param message The message to log.
//      */
//     public  void warn(String message) {
//         logger.warn(message);
//     }

//     /**
//      * Logs an error-level message.
//      * @param message The message to log.
//      */
//     public void error(String message) {
//         logger.error(message);
//     }

//     /**
//      * Logs a fatal-level message.
//      * @param message The message to log.
//      */
//     public void fatal(String message) {
//         logger.fatal(message);
//     }

//     /**
//      * Logs a trace-level message.
//      * @param message The message to log.
//      */
//     public void trace(String message) {
//         logger.trace(message);
//     }
// }
