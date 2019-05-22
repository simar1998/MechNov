package subroutines.thread;

import com.fazecast.jSerialComm.SerialPort;
import serialcomms.ListnerHandler;
import serialcomms.SerialCommunicator;

public class CommunicationThread implements Runnable {

    @Override
    public void run() {
        SerialPort[] serialPorts = SerialPort.getCommPorts();

        for (SerialPort port : serialPorts) {
            System.out.println(port.getSystemPortName());
        }

        SerialCommunicator serialCommunicator = new SerialCommunicator("COM3",115200);
        serialCommunicator.openConnection();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ListnerHandler.attachReaderListner(serialCommunicator);

        serialCommunicator.serialWrite("G28"+ " \r\n\r\n ");
        // System.out.println(serialCommunicator.serialRead(200));   Could not get past that as it was a open while loop
        final SerialPort comPort =serialCommunicator.getSerialPort();
        serialCommunicator.serialWrite("M115"+ " \r\n\r\n ");
        serialCommunicator.serialWrite("M104 S50" + " \r\n\r\n ");
    }

}
