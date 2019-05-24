package subroutines.thread;

import pojo.Command;
import pojo.printer.Printer;

import java.util.ArrayList;

/**
 * The type Printer communication handler.
 */
public class PrinterCommunicationHandler {

    private static ArrayList<PrinterBundle> printers = new ArrayList<>();


    /**
     * Add printer to stack.
     *
     * @param printer the printer
     */
    public static void addPrinterToStack(Printer printer, boolean shouldConnect) {
        //Makes new printer comm thread
        PrinterCommThread printerCommThread = new PrinterCommThread();
        printerCommThread.setPrinter(printer);
        //Makes new Thread Object
        Thread commsThread1 = new Thread(printerCommThread);
        //Starts the thread and connects to the printerSS
        if(shouldConnect) {
            commsThread1.start();
        }
        //Adds the printerComm Object and it's thread to a printer bundle object for managment
        PrinterBundle printerBundle = new PrinterBundle();
        printerBundle.setPrinterThread(commsThread1);
        printerBundle.setPrinterCommThread(printerCommThread);
        printers.add(printerBundle);

    }



    /**
     * Checks the connection status for
     *
     * @param printerBundle
     * @return
     */
    public static boolean checkThreadStatus(PrinterBundle printerBundle) {
        return printerBundle.getPrinterThread().isAlive();
    }

    /**
     * Reutrns the numbers of threads which are alive
     *
     * @return
     */
    public static int threadsAlive() {
        int counter = 0;
        for (PrinterBundle printerBundle : printers) {
            if (printerBundle.getPrinterThread().isAlive()) {
                counter++;
            }
        }
        return counter;
    }


    public static void sendCommand(String printerName, Command command){
        PrinterBundle printerBundle = getPrinterBundle(printerName);
        printerBundle.getPrinterCommThread().getPrinter().sendCommandToPrinter(command,printerBundle.getPrinter());
    }

    /**
     * Returns the printer Bundle from the list of printers if the name matches that of the printer in the printer bundle array list
     *
     * @param printerName
     * @return
     */
    public static PrinterBundle getPrinterBundle(String printerName) {
        for (PrinterBundle printerBundle : printers) {
            if (printerBundle.getPrinter().getPrinterName().equals(printerName)) {
                return printerBundle;
            }
        }
        throw new RuntimeException("Printer Does not exist");
    }

    /**
     * Returns all the connected printer object
     * @return
     */
    public static ArrayList<Printer> getConnectedPrinters(){
        ArrayList<Printer> printers = new ArrayList<>();
        for (PrinterBundle printerBundle : PrinterCommunicationHandler.printers){
            if (printerBundle.getPrinterCommThread().getPrinter().getSerialCommunicator().isSerialPortConnected()){
                printers.add(printerBundle.getPrinter());
            }
        }
        return printers;
    }




    /**
     * The type Printer bundle.
     */
    public static class PrinterBundle {
        /**
         * The Printer comm thread.
         */
        PrinterCommThread printerCommThread;
        /**
         * The Printer thread.
         */
        Thread printerThread;

        /**
         * Instantiates a new Printer bundle.
         */
        public PrinterBundle() {
        }

        /**
         * Instantiates a new Printer bundle.
         *
         * @param printerCommThread the printer comm thread
         * @param printerThread     the printer thread
         */
        public PrinterBundle(PrinterCommThread printerCommThread, Thread printerThread) {
            this.printerCommThread = printerCommThread;
            this.printerThread = printerThread;
        }

        /**
         * Gets printer comm thread.
         *
         * @return the printer comm thread
         */
        public PrinterCommThread getPrinterCommThread() {
            return printerCommThread;
        }

        /**
         * Sets printer comm thread.
         *
         * @param printerCommThread the printer comm thread
         */
        public void setPrinterCommThread(PrinterCommThread printerCommThread) {
            this.printerCommThread = printerCommThread;
        }

        /**
         * Gets printer thread.
         *
         * @return the printer thread
         */
        public Thread getPrinterThread() {
            return printerThread;
        }

        /**
         * Sets printer thread.
         *
         * @param printerThread the printer thread
         */
        public void setPrinterThread(Thread printerThread) {
            this.printerThread = printerThread;
        }

        /**
         * Reuturns the printer for the printer bundle
         * @return
         */
        public Printer getPrinter(){
            return  this.getPrinterCommThread().getPrinter();
        }
    }

}




