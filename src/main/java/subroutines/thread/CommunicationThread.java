package subroutines.thread;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import pojo.Command;
import pojo.printer.Printer;
import serialcomms.SerialCommunicator;

public class CommunicationThread implements Runnable {

    @Override
    public void run() {

       SerialPort.getCommPort("COM3").closePort();
        Printer printer = new Printer();
        printer.connectToPrinter("COM3",115200, printer);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // printer.attachReaderListner(printer.getSerialCommunicator());
       // System.out.println("Config String : " + printer.getConfigStringLines());
       printer.sendCommandToPrinter(new Command("G28"), printer);

        printer.getSerialCommunicator().closeConnection();


    }

}
