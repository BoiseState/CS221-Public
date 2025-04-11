/**
 * Represents a single position in a maze of characters.
 *
 * @author Java Foundations
 * @author mvail adding previous position so path can be marked
 * @version 4.0
 */
public class Position
{
    private int row; 
    private int col;
    
    private Position prev;

    /**
     * Constructs a position and sets the x & y coordinates to 0,0.
     */
    Position ()
    {
        row = 0;
        col = 0;
        prev = null;
    }

    /**
     * Returns the y-coordinate value of this position.
     * @return the y-coordinate of this position
     */
    public int getRow()
    {
        return row;
    }

    /**
     * Returns the x-coordinate value of this position.
     * @return the x-coordinate of this position
     */
    public int getCol()
    {
        return col;
    }

    /**
     * Sets the value of the current position's y-coordinate.
     * @param a value of y-coordinate
     */
    public void setRow(int a)
    {
        row = a;
    }

    /**
     * Sets the value of the current position's x-coordinate.
     * @param a value of x-coordinate
     */ 
    public void setCol(int a)
    {
        col = a;
    }

	/**
	 * @return the prev
	 */
	public Position getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Position prev) {
		this.prev = prev;
	}
}
