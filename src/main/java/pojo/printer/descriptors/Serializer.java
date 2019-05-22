package pojo.printer.descriptors;

import com.google.gson.Gson;

public  class Serializer {

public String jsonSerializable(Object object){
    return (new Gson()).toJson(object);
}

}
