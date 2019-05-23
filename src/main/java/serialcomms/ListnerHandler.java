package serialcomms;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The type Listner handler.
 */
public class ListnerHandler {

    public ArrayList<String> responses = new ArrayList<String>();

    /**
     * Attach reader listner.
     *
     * @param serialCommunicator the serial communicator
     */
    public void attachReaderListner(SerialCommunicator serialCommunicator){
        SerialPort serialPort = serialCommunicator.getSerialPort();

        if(serialPort == null){
            System.out.println("Serial Port not null in Listner Handler Class");
            return;
        }

        serialPort.addDataListener(new SerialPortDataListener() {
            public int getListeningEvents() { return SerialPort.LISTENING_EVENT_DATA_RECEIVED; }
            public void serialEvent(SerialPortEvent event)
            {
                String response = "";
                byte[] newData = event.getReceivedData();
                System.out.println("Received data of size: " + newData.length);
                for (int i = 0; i < newData.length; ++i) {
                    System.out.print((char) newData[i]);
                   // response += (char) newData[i];
                }
                //ArrayList<String> lines =
                responses.add(response);
                //System.out.println("RESPONSE : " + response);
                System.out.println("\n");
            }
        });
    }

    public ArrayList<String> getResponses() {
        return responses;
    }

    public void setResponses(ArrayList<String> responses) {
        this.responses = responses;
    }

}
