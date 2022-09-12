/**
   Class representing a GrandfatherClock
   Clock chimes every quarter hour

   @author krodgers
 */

public class GrandfatherClock extends Clock{
    private String chime;

    /**
     *   Constructor for GrandfatherClock
     * @param hour - the start hour of the clock
     * @param minute - the start minute of the clock
     * @param chime - the chime that displays every quarter hour
     */
    public GrandfatherClock(int hour, int minute, String chime){
	super(hour, minute);
	this.chime = chime;
    }

    /**
       Advances the minute by one
       Prints the chime every quarter hour
       Prints the hourly toll
     */
    @Override
    public void tickTock(){
	super.tickTock();
	int min = super.getMinute();

	if(min == 0){
	    System.out.println(chime);
	    System.out.println("BBOONNGG\n".repeat(getHour()));
	} else if(min % 15 == 0){
	    System.out.println(chime.repeat(min / 15));
	}
    }

    // Set the chime 
    public void setChime(String chime){
	this.chime = chime;
    }

}
