/**
   A 24-hour alarm clock with the ability
   to set one alarm.
   @author krodgers
**/

public class AlarmClock extends Clock{
    private int offHour;
    private int offMinute;

    public AlarmClock(int currentHr, int currentMin){

	super(currentHr, currentMin);
	
	offHour = -1;
	offMinute = -1;
    }

    /**
       Sets the alarm to go off at hour:min
       Throws BadTimeException if either hour or minute has
       an invalid value

       @param hour - value between 0 and 23
       @param min - value between 0 and 59
     */
    public void setAlarm(int hour, int min){

	if(hour < 0 || hour > 23 || min < 0 || min > 59)
	    throw new BadTimeException("Invalid alarm time: ");

	offHour = hour;
	offMinute = min;
	
    }

    /**
       Resets and turns off the alarm
     **/
    public void clearAlarm(){
	offHour = -1;
	offMinute = -1;
    }

    /**
       Sounds alarm if the alarm is set and it's the correct time
       Throws AlarmNotSetException if the alarm time has not been set
     */
    public void soundAlarm(){
	if(offHour == -1 || offMinute == -1)
	    throw new AlarmNotSetException("Alarm cannot sound before it is set");
	else if(getHour() == offHour || getMinute() == offMinute)
	    System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEPPPPPPPPPPPPPPPPPPPPPPPPP");
    }
    
    /**
       Sets the clock time (not the alarm time)

       @param hour - value between 0 and 23
       @param min - value between 0 and 59       
     */
    public void setClockTime(int hour, int minute){
	setHour(hour);
	setMinute(minute);
    }

    /**
       Prints clock time and alarm time, if set
     */
    public String toString(){
	String time = super.toString();
	if(offHour != -1 && offMinute != -1){
	    time += "\nAlarm Set: " + offHour + ":" + offMinute;
	} else{
	    time += "\nAlarm Not Set";
	}

	return time;
    }
}
