package serialcomms;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

import java.util.ArrayList;

/**
 * The type Listner handler.
 */
public class ListnerHandler {

    public static

    /**
     * Attach reader listner.
     *
     * @param serialCommunicator the serial communicator
     */
    public static void attachReaderListner(SerialCommunicator serialCommunicator){
        SerialPort serialPort = serialCommunicator.getOpenConnection();

        if(serialPort == null){
            System.out.println("Serial Port not null in Listner Handler Class");
            return;
        }

        serialPort.addDataListener(new SerialPortDataListener() {
            public int getListeningEvents() { return SerialPort.LISTENING_EVENT_DATA_RECEIVED; }
            public void serialEvent(SerialPortEvent event)
            {
                String line = "";
                byte[] newData = event.getReceivedData();
                System.out.println("Received data of size: " + newData.length);
                for (int i = 0; i < newData.length; ++i) {
                    System.out.print((char) newData[i]);
                }
                String[] lines = line.split("\\r?\\n");
                System.out.println("\n");
            }
        });
    }


}
