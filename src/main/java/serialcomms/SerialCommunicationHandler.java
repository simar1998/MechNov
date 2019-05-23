package serialcomms;

import com.fazecast.jSerialComm.SerialPort;
import pojo.Command;
import pojo.printer.Printer;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Handles Communication from the printer and to the printer
 */
public class SerialCommunicationHandler extends ListnerHandler{

    ArrayList<String> configStringLines = new ArrayList<>();

    public void sendCommandToPrinter(Command command, Printer printer){
        printer.getSerialCommunicator().serialWrite(command.getCommand() + " \r\n\r\n ");
    }

    public ArrayList<String> getConfigStringLines(){
       return new ArrayList<String>(Arrays.asList( getResponses().get(0).split("\\r?\\n")));
    }

    public void setConfigStringLines(ArrayList<String> configStringLines) {
        this.configStringLines = configStringLines;
    }

    public void connectToPrinter(String portDesc, int baud, Printer printer){
        SerialCommunicator serialCommunicator = new SerialCommunicator(portDesc,115200);
        serialCommunicator.openConnection();
        printer.setSerialCommunicator(serialCommunicator);
    }
}
