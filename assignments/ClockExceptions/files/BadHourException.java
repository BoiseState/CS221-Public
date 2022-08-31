/**
   Exception thrown specifically when an invalid hour is used
   @author krodgers
**/
public class BadHourException extends BadTimeException{
    public BadHourException(String msg){
	super(msg);
    }
}
