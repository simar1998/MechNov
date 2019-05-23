package subroutines.thread;

import pojo.printer.Printer;
import serialcomms.SerialCommunicator;

/**
 * The type Communication thread.
 */
public class PrinterCommThread implements Runnable {

    /**
     * The Printer for this thread.
     */
    Printer printer;

    String comPort= "";

    int baudRate;

    public PrinterCommThread(){

    }

    public PrinterCommThread(Printer printer){
        this.printer = printer;
    }

    @Override
    public void run() {
        if(printer != null  && comPort.equals("") && baudRate == 0){
            printer.connectToPrinter(printer);
        }
        else if (printer == null &&  !comPort.equals("") && baudRate != 0){
            printer = new Printer();
            printer.setSerialCommunicator(new SerialCommunicator(comPort,baudRate));
            printer.connectToPrinter(printer);
        }
        else {
            throw new PrinterCommunicationException("Cannot start printer thread, please make sure connection is open and printer object is assigned to PrinterCommThread");
        }
    }

    /**
     * Gets printer for this thread.
     *
     * @return the printer for this thread
     */
    public Printer getPrinter() {
        return printer;
    }

    /**
     * Sets printer for this thread.
     *
     * @param printer the printer for this thread
     */
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
}
