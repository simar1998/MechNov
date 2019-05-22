package api;

import subroutines.thread.CommunicationThread;

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


}
