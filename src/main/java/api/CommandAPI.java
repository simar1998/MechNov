package api;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import pojo.Command;
import pojo.crud.HelperCRUD;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.io.IOException;

@Path("/commandAPI")
public class CommandAPI {

    @POST
    @Path("/addCommand")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("text/plain")
    public  String addCommand(MultipartFormDataInput multipartFormDataInput) throws IOException {

        String firmware = multipartFormDataInput.getFormDataPart("firmware", String.class, null);
        String command = multipartFormDataInput.getFormDataPart("command", String.class, null);
        String commandDescShort = multipartFormDataInput.getFormDataPart("cmdShort", String.class, null);
        String commandDescLong = multipartFormDataInput.getFormDataPart("cmdLong",String.class, null);

        Command commandObj = new Command();
        System.out.println("Incoming Command: " + commandObj.toString());
        commandObj.setFirmware(firmware);
        commandObj.setCommand(command);
        commandObj.setCommandDesc(commandDescShort);
        commandObj.setCommandDescLong(commandDescLong);

        HelperCRUD.saveObjectIntoDB(commandObj);

        return "Command Added Successfully!";
    }
}
