import java.util.Scanner;
import java.util.InputMismatchException;

// https://programming.guide/java/list-of-java-exceptions.html

/**
   Clock app with several clocks
   @author krodgers
**/
public class Main{

    
    // Start with catching Alarm Exceptions
    // Add exception handling for Scanner errors later
    public static void main(String[] args){

	System.out.println("Welcome to your All-In-One Clock App!");

	// Create an Alarm Clock [part 2: create an array of clocks]
	//	AlarmClock alarm = new AlarmClock(8,0);


	// The array makes all common operations easier - just iterate and
	// call the method on each object.
	// To call class specific methods, though, you have to
	// pull out the object and cast it to the proper type.
	Clock[] clocks = new Clock[3];
	clocks[0] = new Clock(8, 13);
	clocks[1] = new AlarmClock(8, 13);
	clocks[2] = new GrandfatherClock(8, 56, " {} \n<()>");
	
	// Print Menu
	printMenu();

	Scanner input = new Scanner(System.in);
	
	// Loop until user wants to quit
	boolean done = false;
	while(!done){
	    int option = getNumber(input, "Enter Menu choice: ");
	    
	    // Handle menu options
	    switch(option){

	    case 1:
		// Set clock time
		
		// One solution
		// Kicks the user back to the menu if they
		// enter something invalid
		/*
		  try{
		  int hr = getNumber(input, "Enter hour: ");
		  int min = getNumber(input, "Enter minute: " );

		  // alarm.setClockTime(hr, min);
		    
		  for(Clock clock : clocks){
		  clock.setHour(hr);
		  clock.setMinute(min);
		  }
		    
		    
		  } catch(BadHourException e){
		  System.out.println("Invalid hour.");
		  } catch(BadMinuteException e){
		  System.out.println("Invalid minute.");
		  }

		*/
		// A different solution
		
		// Allows the user to try until they enter something
		// valid.  Also combines the exceptions and just
		// catches a BadTimeException (which is allowed since
		// BadHourException IS-A BadTimeException and
		// BadMinuteException IS-A BadTimeException
		while(true){
		    try{
			int hr = getNumber(input, "Enter hour: ");
			int min = getNumber(input, "Enter minute: ");

			//alarm.setClockTime(hr, min);
			for(Clock clock : clocks){
			    clock.setHour(hr);
			    clock.setMinute(min);
			}

			break; // ends while loop
		    } catch(BadTimeException e){
			System.out.println("That time is invalid.  Try again.");
		    }
		}
		break;
	    case 2:
		// See clock time
		// System.out.println(alarm);

		System.out.println("Clock: " + clocks[0]);
		System.out.println("Alarm: " + clocks[1]);
		System.out.println("Grandfather Clock: " + clocks[2]);
		
		break;
	    case 3:
		// Set alarm time
		// Catch BadTimeException
		try{
		    int hr = getNumber(input, "Enter hour: ");
		    int min = getNumber(input, "Enter minute: " );

		    AlarmClock alarm = (AlarmClock) clocks[1];
		    alarm.setAlarm(hr, min);
		} catch(BadTimeException e){
		    System.out.println("Not a valid alarm time.");		          
		} catch (InputMismatchException e){
		    System.out.println("Hour and minute should be integer numbers");
		}
		break;
	    case 4:
		// Set off alarm
		// Catch AlarmNotSetException
		try{
		    //alarm.soundAlarm();

		    // Can't call soundAlarm() on a Clock, so you have
		    // to cast the AlarmClock to an AlarmClock
		    //
		    // You've probably seen this before -- remember
		    // ActionListeners? If you had a button, you had
		    // to cast the parameter of the ActionListener
		    // method to a button before you did anything with
		    // the button
		    
		    AlarmClock alarm = (AlarmClock) clocks[1];
		    alarm.soundAlarm();
		} catch(AlarmNotSetException e){
		    System.out.println(e.getMessage());
		}
		break;
	    case 5:
		// Print Menu
		printMenu();
		break;
	    case 6:
		// Quit
		done = true;
	    default:
		System.out.println("Not a valid menu option");
		// End menu handling
	    }
	    // Advance the clock
	    //alarm.tickTock();
	    for(Clock clock : clocks){
		clock.tickTock();
	    }

	}
	input.close();
    }

    // Prints menu options
    public static void printMenu(){
	// [part 2: Add menu items for your clock type]
	System.out.println("1. Set Clock Time");
	System.out.println("2. Display Time");
	System.out.println("3. Set Alarm Time");
	System.out.println("4. Set off Alarm");
	System.out.println("5. Print Menu");
	System.out.println("6. Quit");
    }
    
    /**
     * Gets an integer from the user using the prompt supplied

     * Version 2 - Adds exception handling to cover the case where the
     * user enters something that cannot be converted to an integer
     * value
     *
     * @param input - the Scanner with which to get the user's input
     * @param prompt - instructions for the user so they know what
     * kind of number to enter
     * @return - an integer whose value was supplied by the user
     */
    public static int getNumber(Scanner input, String prompt){
	/*
	  Version 1 Implementation
	  System.out.print(prompt);
	  return Integer.parseInt(input.next());
	*/

	// Version 2 Implementation
	// Implementation with exception handling
	int value = 0;
	while(true){
	    try{
		System.out.print(prompt);
		value = Integer.parseInt(input.next());
		return value; // method ends here if value successfully obtained
	    } catch (Exception e) {
		// Lots of exceptions could occur
		// Lazily catch them all
		System.out.println("Input could not be converted to an integer.");
		System.out.println("Try again.");
	    }

	}
    }
}





