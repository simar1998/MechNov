package subroutines.thread;

public class PrinterCommunicationException extends RuntimeException {

    public PrinterCommunicationException(String errorMessage){
        super(errorMessage);
    }
}
