package api;

import com.fazecast.jSerialComm.SerialPort;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import pojo.Command;
import pojo.printer.Printer;
import pojo.printer.descriptors.ControlLoopPID;
import serialcomms.SerialCommunicator;
import subroutines.thread.PrinterCommThread;
import subroutines.thread.HibernateThread;
import subroutines.thread.PrinterCommunicationHandler;

import javax.ejb.PostActivate;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * The type Test api.
 */
@Path("/test")
public class TestAPI {

    /**
     * Test get string.
     *
     * @return the string
     */
    @GET
    @Path("testGET")
    @Produces("text/plain")
    public String testGet() {
        Thread commsThread1 = new Thread(new PrinterCommThread());
        commsThread1.start();
        return "Get Method Test Successful";
    }

    @GET
    @Path("testDB")
    @Produces("text/plain")
    public String testDB() {
        String fromPID = "from ControlLoopPID";
        Query query = HibernateThread.getSession().openSession().createQuery(fromPID);
        return query.list().toString();
    }

    @GET
    @Path("testDBSave")
    @Produces("text/plain")
    public String testDBSave() {

        Session session = HibernateThread.getSession().openSession();
        session.beginTransaction();

        ControlLoopPID controlLoopPID = new ControlLoopPID(1310, 1114, 2056);

        session.save(controlLoopPID);
        session.getTransaction().commit();
        HibernateThread.shutDown();
        // HibernateThread.getSession().getTransaction().commit();
        return "SAVED";
    }


    @POST
    @Path("testCommand")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("text/plain")
    public String testCommandToPrinter(MultipartFormDataInput multipart) throws IOException {

        String printerName = multipart.getFormDataPart("printerName",String.class,null);
        String command = multipart.getFormDataPart("command",String.class,null);

        if (PrinterCommunicationHandler.getPrinterBundle(printerName).getPrinterCommThread().getPrinter().getSerialCommunicator().getSerialPort().isOpen()) {
            System.out.println("PRINTER STATUS : " + PrinterCommunicationHandler.getPrinterBundle(printerName).getPrinterCommThread().getPrinter().getSerialCommunicator().getSerialPort().isOpen());
            //PrinterCommunicationHandler.getPrinterBundle("Ender 3").getPrinterCommThread().getPrinter().sendCommandToPrinter(new Command(command), PrinterCommunicationHandler.getPrinterBundle("Ender 3").getPrinter());
            PrinterCommunicationHandler.sendCommand(printerName, new Command(command));
        }
        return "Command Sent";
    }

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


    @GET
    @Path("/checkStatus/{printerName}")
    @Produces("text/plain")
    public String checkPrinterStatus(@PathParam("printerName") String printerName) {

        return PrinterCommunicationHandler.getPrinterBundle(printerName).getPrinterCommThread().getPrinter().getSerialCommunicator().getSerialPort().isOpen() + "";
    }

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




