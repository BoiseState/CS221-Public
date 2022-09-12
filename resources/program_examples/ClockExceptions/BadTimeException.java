/**
   Exception for when a bad clock time is used
   @author krodgers
 **/


public class BadTimeException extends IllegalArgumentException{
    public BadTimeException(String msg){
	super(msg);
    }
}
