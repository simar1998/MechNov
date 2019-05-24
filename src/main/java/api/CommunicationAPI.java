package api;

import com.fazecast.jSerialComm.SerialPort;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import pojo.Command;
import pojo.printer.Printer;
import serialcomms.SerialCommunicator;
import subroutines.thread.PrinterCommunicationHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/communication")
public class CommunicationAPI {

    /**
     * Sends command to printer specified
     * @param multipart
     * @return
     * @throws IOException
     */
    @POST
    @Path("/sendCommand")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("text/plain")
    public String testCommandToPrinter(MultipartFormDataInput multipart) throws IOException {

        String printerName = multipart.getFormDataPart("printerName",String.class,null);
        String command = multipart.getFormDataPart("command",String.class,null);

        if (PrinterCommunicationHandler.getPrinterBundle(printerName).getPrinterCommThread().getPrinter().getSerialCommunicator().getSerialPort().isOpen()) {
            System.out.println("PRINTER STATUS : " + PrinterCommunicationHandler.getPrinterBundle(printerName).getPrinterCommThread().getPrinter().getSerialCommunicator().getSerialPort().isOpen());
            PrinterCommunicationHandler.sendCommand(printerName, new Command(command));
        }
        return "Command Sent";
    }

    /**
     * Connects to printer on a com port specified
     * @param multipart
     * @return
     * @throws IOException
     */
    @POST
    @Path("/connectToPrinter")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("text/plain")
    public String connectToPrinter(MultipartFormDataInput multipart) throws IOException {

        String printerName = multipart.getFormDataPart("printerName",String.class,null);
        String comPort = multipart.getFormDataPart("comPort",String.class,null);

        Printer printer = new Printer();
        printer.setPrinterName(printerName);
        printer.setSerialCommunicator(new SerialCommunicator(comPort, 115200));
        printer.getSerialCommunicator().setPortDescription(comPort);
        PrinterCommunicationHandler.addPrinterToStack(printer, true);

        for (int i = 0; i < 5; i++) {
            if (PrinterCommunicationHandler.getPrinterBundle(printerName).getPrinterCommThread().getPrinter().getSerialCommunicator().getSerialPort().isOpen()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("PRINTER STATUS : " + PrinterCommunicationHandler.getPrinterBundle(printerName).getPrinterCommThread().getPrinter().getSerialCommunicator().getSerialPort().isOpen());
                PrinterCommunicationHandler.getPrinterBundle(printerName).getPrinterCommThread().getPrinter().sendCommandToPrinter(new Command("G28"), printer);
                return printerName + " is connected";
            } else {
                break;
            }
        }

        return "Attempting to connect to printer";
    }


    /**
     * Gets the status of the printer and returns it
     * @param multipartFormDataInput
     * @return
     */
    @GET
    @Path("/checkStatus/{printerName}")
    @Produces("text/plain")
    public String checkPrinterStatus(MultipartFormDataInput multipartFormDataInput) throws IOException{

        String printerName = multipartFormDataInput.getFormDataPart("printerName", String.class, null);
        return PrinterCommunicationHandler.getPrinterBundle(printerName).getPrinterCommThread().getPrinter().getSerialCommunicator().getSerialPort().isOpen() + "";

    }

    /**
     * Gets all open ports on the printer
     * @return
     */
    @GET
    @Path("/getComPorts")
    @Produces("text/plain")
    public String getComPorts() {
        String comPorts = "";
        try {
            for (SerialPort serialPort : SerialCommunicator.getComPorts()) {
                comPorts = comPorts + " " + serialPort.getSystemPortName();
            }
        }
        catch (NullPointerException e){
            return "NO OPEN PORTS AVAILABLE";
        }
        return comPorts;
    }


}
