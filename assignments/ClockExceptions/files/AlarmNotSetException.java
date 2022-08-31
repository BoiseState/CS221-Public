/**
   Exception thrown when alarm is set off before alarm time is set
   @author krodgers
 **/

public class AlarmNotSetException extends IllegalStateException{
    public AlarmNotSetException(String msg){
	super(msg);
    }
}
