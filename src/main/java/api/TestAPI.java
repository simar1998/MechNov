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



}




