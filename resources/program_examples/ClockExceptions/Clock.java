import java.text.DecimalFormat;
/**
   Represents a 24-hour clock
   @author krodgers
**/

public class Clock {
    private int hour;
    private int minute;

    /**
       Sets initial clock time
       @param hour - value between 0 and 23; the hour of the clock
       @param minute - value between 0 and 59; the minute of the clock
     */
    public Clock(int hour, int minute){
	setHour(hour);
	setMinute(minute);
    }

    // Returns current hour
    public int getHour(){
	return hour;
    }

    // Returns current minute
    public int getMinute(){
	return minute;
    }

    // Could declare that it throws an exception
    // Does not have to -- RunTimeExceptions are unchecked
    /**
     *  Sets the hour of the clock
     *  Throws BadHourException if hour is not an integer
     *  in the range [0, 23]
     */
    public void setHour(int hour){
	if(hour < 0 || hour > 23){
	    throw new BadHourException("Invalid hour: " + hour);
	}
	this.hour = hour;
    }

    
    /**
     *  Sets the minute of the clock
     *  Throws BadMinuteException if minute is not an integer
     *  in the range [0, 59]
     */
    public void setMinute(int minute){
	if(minute < 0 || minute > 59){
	    throw new BadMinuteException("Invalid minute: " + minute);
	}
	this.minute = minute;
    }

    /**
       Advances the clock by one minute
     **/
    public void tickTock(){
	if(minute == 59){
	    minute = 0;
	    hour = (hour + 1) % 24;
	} else {
	    minute++;	    
	}
    }

    // Returns clock time
    public String toString(){
	DecimalFormat df = new DecimalFormat("00");
	return hour + ":" + df.format(minute);
    }

}
