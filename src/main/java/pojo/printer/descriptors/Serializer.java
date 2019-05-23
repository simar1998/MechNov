package pojo.printer.descriptors;

import com.google.gson.Gson;
import pojo.Command;

import java.util.ArrayList;

/**
 * The type Serializer.
 */
public  class Serializer {

    /**
     * Json serializable string.
     *
     * @param object the object
     * @return the string
     */
    public String jsonSerializable(Object object){
    return (new Gson()).toJson(object);
}

    /**
     * From serial output string.
     *
     * @param stringArrayList the string array list
     * @param descriptor      the descriptor
     * @return the string
     */
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
