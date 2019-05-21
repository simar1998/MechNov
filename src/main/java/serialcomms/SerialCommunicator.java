package serialcomms;

import com.fazecast.jSerialComm.SerialPort;

import java.io.PrintWriter;
import java.util.Scanner;


/**
 * The type Serial communicator.
 */
public class SerialCommunicator {

    /**
     * The Is serial port connected.
     */
    boolean isSerialPortConnected;

    private SerialPort comPort;
    private String portDescription;
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
            try {Thread.sleep(100);} catch(Exception e){}
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






}