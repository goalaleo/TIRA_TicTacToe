
package tictactoe;

/**
 * This class contains the main game logic and loop, including references to the 3 {@link Board}s, the list of {@link Fingerprint}s etc.
 * @author Lepa
 */
public class Game {
    
    /**
     * leftmost {@link Board}
     */
    protected Board board1;
    /**
     * middle {@link Board}
     */
    protected Board board2;
    /**
     * rigtmost {@link Board}
     */
    protected Board board3;
    /**
     * Library of all unique variations of a {@link Fingerprint}s
     */
    public FingerprintLibrary fprintLibrary;
    /**
     * the calculated gamestate, which is the concatenation/multiplication of
     * the misère quotients of the 3 {@link Board}s.
     */
    protected String gameState;
    
    /**
     * Constructor for creating an instane of {@link Game}, wich is the class
     * containing most of the game's logic.
     */
    public Game(){
        
        this.fprintLibrary = new FingerprintLibrary();
        
        this.board1 = new Board(1,fprintLibrary.fingerprints[0]);
        this.board2 = new Board(2,fprintLibrary.fingerprints[0]);
        this.board3 = new Board(3,fprintLibrary.fingerprints[0]);
        
    }
    
    /**
     * This method contains the main game loop/logic.
     */
    public void run(){
        //main game loop here
    }
    
    
}
