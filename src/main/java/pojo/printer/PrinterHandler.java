package pojo.printer;

import serialcomms.SerialCommunicator;
import java.util.ArrayList;

public class PrinterHandler {

    public static ArrayList<Printer> printerArrayList = new ArrayList<>();

    public void assignPrinterComPort(SerialCommunicator serialCommunicator, Printer printer){
        printer.setSerialCommunicator(serialCommunicator);
    }


}
