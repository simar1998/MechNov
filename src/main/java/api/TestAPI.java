package api;

import org.hibernate.Query;
import org.hibernate.Session;
import pojo.Command;
import pojo.printer.Printer;
import pojo.printer.descriptors.ControlLoopPID;
import serialcomms.SerialCommunicator;
import subroutines.thread.PrinterCommThread;
import subroutines.thread.HibernateThread;
import subroutines.thread.PrinterCommunicationHandler;

import javax.ws.rs.*;

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


    @GET
    @Path("testCommand/{command}")
    @Produces("text/plain")
    public String testCommandToPrinter(@PathParam("command") String command) throws InterruptedException {
        if (PrinterCommunicationHandler.getPrinterBundle("Ender 3").getPrinterCommThread().getPrinter().getSerialCommunicator().getSerialPort().isOpen()) {
            System.out.println("PRINTER STATUS : " + PrinterCommunicationHandler.getPrinterBundle("Ender 3").getPrinterCommThread().getPrinter().getSerialCommunicator().getSerialPort().isOpen());
            PrinterCommunicationHandler.getPrinterBundle("Ender 3").getPrinterCommThread().getPrinter().sendCommandToPrinter(new Command(command), PrinterCommunicationHandler.getPrinterBundle("Ender 3").getPrinter());
        }
        return "Command Sent";
    }

    @GET
    @Path("/connectToPrinter/{printerName}")
    @Produces("text/plain")
    public String connectToPrinter(@PathParam("printerName") String printerName) {
        Printer printer = new Printer();
        printer.setPrinterName("Ender 3");
        printer.setSerialCommunicator(new SerialCommunicator("COM3", 115200));
        printer.getSerialCommunicator().setPortDescription("COM3");
        PrinterCommunicationHandler.addPrinterToStack(printer, true);

        for (int i = 0; i < 5; i++) {
            if (PrinterCommunicationHandler.getPrinterBundle("Ender 3").getPrinterCommThread().getPrinter().getSerialCommunicator().getSerialPort().isOpen()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("PRINTER STATUS : " + PrinterCommunicationHandler.getPrinterBundle("Ender 3").getPrinterCommThread().getPrinter().getSerialCommunicator().getSerialPort().isOpen());
                PrinterCommunicationHandler.getPrinterBundle("Ender 3").getPrinterCommThread().getPrinter().sendCommandToPrinter(new Command("G28"), printer);
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

        return PrinterCommunicationHandler.getPrinterBundle("Ender 3").getPrinterCommThread().getPrinter().getSerialCommunicator().getSerialPort().isOpen() + "";
    }
}




