package pojo.printer.descriptors;

import com.google.gson.Gson;
import pojo.Command;

import java.util.ArrayList;

public  class Serializer {

public String jsonSerializable(Object object){
    return (new Gson()).toJson(object);
}

    public String fromSerialOutput(ArrayList<String> stringArrayList, String descriptor){
        String serialCommand = Command.getCommandFromDesc(descriptor).getCommand();
        String commandLine = "";
        for (String line : stringArrayList){
            if (line.contains(serialCommand)){
                commandLine = line;
                break;
            }
        }
        return commandLine;
    }

}
