package api;

import org.hibernate.Query;
import org.hibernate.Session;
import pojo.printer.descriptors.ControlLoopPID;
import subroutines.thread.CommunicationThread;
import subroutines.thread.HibernateThread;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
    public String testGet(){
        Thread commsThread1 = new Thread(new CommunicationThread());
        commsThread1.start();
        return "Get Method Test Successful";
    }

    @GET
    @Path("testDB")
    @Produces("text/plain")
    public String testDB(){
        String fromPID = "from ControlLoopPID";
        Query query = HibernateThread.getSession().openSession().createQuery(fromPID);
        return query.list().toString();
    }

    @GET
    @Path("testDBSave")
    @Produces("text/plain")
    public String testDBSave(){

        Session session = HibernateThread.getSession().openSession();
        session.beginTransaction();

        ControlLoopPID controlLoopPID = new ControlLoopPID(1310,1114,2056);

        session.save(controlLoopPID);
        session.getTransaction().commit();
        HibernateThread.shutDown();
       // HibernateThread.getSession().getTransaction().commit();
        return "SAVED";
    }


}
