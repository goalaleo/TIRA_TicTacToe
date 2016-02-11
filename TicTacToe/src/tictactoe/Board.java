
package tictactoe;

/**
 * A Board on which the game is played of wich 3 exist in a single game.
 * @author Lepa
 */
public class Board {
    
    /**
     * whether or not the position in the board contains an X. Refers to corresponding
     * position of the number in the numpad (ie. num7 refers to top left corner)
     */
    protected boolean num7 = false;
    /**
     * @see #num7
     */
    protected boolean num8 = false;
    /**
     * @see #num7
     */
    protected boolean num9 = false;
    /**
     * @see #num7
     */
    protected boolean num4 = false;
    /**
     * @see #num7
     */
    protected boolean num5 = false;
    /**
     * @see #num7
     */
    protected boolean num6 = false;
    /**
     * @see #num7
     */
    protected boolean num1 = false;
    /**
     * @see #num7
     */
    protected boolean num2 = false;
    /**
     * @see #num7
     */
    protected boolean num3 = false;
    /**
     * the id of the Fingerprint, that matches the current board situation
     */
    protected Fingerprint matching_fingerprint;
    int boardNumber;
    
    /**
     * A Constructor for creating a Board, of which 3 exist in the game. When created,
     * the {@link #matching_fingerprint_id} field is set to 0 indicating an empty Board
     * @param boardNumber the number of the board (1-3) of which 1 is the leftmost
     * @param matching_fingerprint is the {@link Fingerprint} in the fingerprints library that matches the current Board configuration
     * 
     */
     public Board(int boardNumber, Fingerprint matching_fingerprint){
         this.matching_fingerprint = matching_fingerprint;
         this.boardNumber = boardNumber;
     }
}
