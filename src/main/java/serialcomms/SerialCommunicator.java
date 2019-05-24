package serialcomms;

import com.fazecast.jSerialComm.SerialPort;

import javax.persistence.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * The type Serial communicator.
 */
@Entity
@Table(name = "SerialCommunicator")
public class SerialCommunicator {

    /**
     * The Serial port array list.
     */
    @Transient
    public static ArrayList<SerialPort> serialPortArrayList;
    /**
     * The Is serial port connected.
     */
    @Transient
    boolean isSerialPortConnected;

    /**
     * The Id.
     */
    @Id
    @Column(name = "Id")
    int id;

    @Transient
    SerialPort comPort;

    @Column(name = "portDescription")
    private String portDescription;

    @Column(name = "Baud_Rate")
    private int baud_rate;

    /**
     * Instantiates a new Serial communicator.
     */
    public SerialCommunicator() {
        //empty constructor if port undecided
    }

    /**
     * Instantiates a new Serial communicator.
     *
     * @param portDescription the port description
     */
    public SerialCommunicator(String portDescription) {
        //make sure to set baud rate after
        this.portDescription = portDescription;
        comPort = SerialPort.getCommPort(this.portDescription);
    }

    /**
     * Instantiates a new Serial communicator.
     *
     * @param portDescription the port description
     * @param baud_rate       the baud rate
     */
    public SerialCommunicator(String portDescription, int baud_rate) {
        //preferred constructor
        this.portDescription = portDescription;
        comPort = SerialPort.getCommPort(this.portDescription);
        this.baud_rate = baud_rate;
        comPort.setBaudRate(this.baud_rate);
    }


    /**
     * Open connection boolean.
     *
     * @return the boolean
     */
    public boolean openConnection(){
        if(comPort.openPort()){
            try {Thread.sleep(500);
            serialPortArrayList.add(getSerialPort());
            } catch(Exception e){}
            return true;
        }
        else {
            System.out.println("Error Connecting Try Another port");
            return false;
        }
    }

    /**
     * Close connection.
     */
    public void closeConnection() {
        comPort.closePort();
    }

    /**
     * Set port description.
     *
     * @param portDescription the port description
     */
    public void setPortDescription(String portDescription){
        this.portDescription = portDescription;
        comPort = SerialPort.getCommPort(this.portDescription);
    }

    /**
     * Set baud rate.
     *
     * @param baud_rate the baud rate
     */
    public void setBaudRate(int baud_rate){
        this.baud_rate = baud_rate;
        comPort.setBaudRate(this.baud_rate);
    }

    /**
     * Get port description string.
     *
     * @return the string
     */
    public String getPortDescription(){
        return portDescription;
    }

    /**
     * Get serial port serial port.
     *
     * @return the serial port
     */
    public SerialPort getSerialPort(){
        return comPort;
    }


    /**
     * Serial read string.
     *
     * @return the string
     */
    public String serialRead(){
        //will be an infinite loop if incoming data is not bound
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        String out="";
        Scanner in = new Scanner(comPort.getInputStream());
        try
        {
            while(in.hasNext())
                out += (in.next()+"\n");
            in.close();
        } catch (Exception e) { e.printStackTrace(); }
        return out;
    }

    /**
     * Serial read string.
     *
     * @param limit the limit
     * @return the string
     */
    public String serialRead(int limit){
        //in case of unlimited incoming data, set a limit for number of readings
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        String out="";
        int count=0;
        Scanner in = new Scanner(comPort.getInputStream());
        try
        {
            while(in.hasNext()&&count<=limit){
                out += (in.next()+"\n");
                count++;
            }
            in.close();
        } catch (Exception e) { e.printStackTrace(); }
        return out;
    }

    /**
     * Serial write.
     *
     * @param s the s
     */
    public void serialWrite(String s){
        //writes the entire string at once.
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        try{Thread.sleep(5);} catch(Exception e){}
        PrintWriter pout = new PrintWriter(comPort.getOutputStream());
        pout.print(s);
        pout.flush();

    }

    /**
     * Serial write.
     *
     * @param s     the s
     * @param delay the delay
     */
    public void serialWrite(String s, int delay) {
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
        }
        PrintWriter pout = new PrintWriter(comPort.getOutputStream());
        pout.write(s);
        pout.flush();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }

    /**
     * Serial write.
     *
     * @param c the c
     */
    public void serialWrite(char c){
        //writes the character to output stream.
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        try{Thread.sleep(5);} catch(Exception e){}
        PrintWriter pout = new PrintWriter(comPort.getOutputStream());pout.write(c);
        pout.flush();
    }

    /**
     * Serial write.
     *
     * @param c     the c
     * @param delay the delay
     */
    public void serialWrite(char c, int delay){
        //writes the character followed by a delay of 'delay' milliseconds.
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        try{Thread.sleep(5);} catch(Exception e){}
        PrintWriter pout = new PrintWriter(comPort.getOutputStream());pout.write(c);
        pout.flush();
        try{Thread.sleep(delay);}catch(Exception e){}
    }

    /**
     * Get open connection serial port.
     *
     * @return the serial port
     */
    public SerialPort getOpenConnection(){
        if(getSerialPort().isOpen()){
            return getSerialPort();
        }
        else{
            System.out.println("Serial Port is not open Please connect");
            return null;
        }
    }

    /**
     * Gets the comm ports available
     * @return
     */
    public static SerialPort[] getComPorts() {
        System.out.println("getComPorts() CALLED...... APPLICATION LOOKING FOR PORTS");
        SerialPort[] serialPorts = SerialPort.getCommPorts();
        if (serialPorts.length == 0){
            System.out.println("NO PORTS DETECTED");
            return null;
        }
        for (SerialPort serialPort : serialPorts) {
            System.out.println("Port Description : " + serialPort.getPortDescription());
        }
        return serialPorts;
    }

    public static SerialCommunicator createSerialCommunicator(SerialPort serialPort){
        SerialCommunicator serialCommunicator = new SerialCommunicator();
        serialCommunicator.setPortDescription(serialPort.getPortDescription());
        return serialCommunicator;
    }


    /**
     * Is serial port connected boolean.
     *
     * @return the boolean
     */
    public boolean isSerialPortConnected() {
        return isSerialPortConnected;
    }

    /**
     * Sets serial port connected.
     *
     * @param serialPortConnected the serial port connected
     */
    public void setSerialPortConnected(boolean serialPortConnected) {
        isSerialPortConnected = serialPortConnected;
    }

    /**
     * Gets baud rate.
     *
     * @return the baud rate
     */
    public int getBaud_rate() {
        return baud_rate;
    }
    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }
}