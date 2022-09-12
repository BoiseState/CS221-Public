/**
   Exception thrown specifically when an invalid minute is used
   @author krodgers
**/

public class BadMinuteException extends BadTimeException{
    public BadMinuteException(String msg){
	super(msg);
    }
}
