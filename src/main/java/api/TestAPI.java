package api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/test")
public class TestAPI {

    @GET
    @Path("testGET")
    @Produces("text/plain")
    public String testGet(){
        return "Get Method Test Successful";
    }


}
