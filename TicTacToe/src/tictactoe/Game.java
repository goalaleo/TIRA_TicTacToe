
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
     * and array of all unique {@link Fingerprint}s
     */
    public Fingerprint[] fingerprints;
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
        
        this.fingerprints = createFingerprintLibrary();
        
        this.board1 = new Board(1,fingerprints[0]);
        this.board2 = new Board(2,fingerprints[0]);
        this.board3 = new Board(3,fingerprints[0]);
        
    }
    
    /**
     * This method contains the main game loop/logic.
     */
    public void run(){
        //main game loop here
    }
    
    /**
     * Generates the complete array containing all the different variations of a board.
     * The generated objects called {@link Fingerprint}s, have an assigned id number and a value,
     * where {@link Fingerprint#value} is the misère quotient of the Fingerprint.
     * 
     * @return an array of all unique Fingerprints (total of 102)
     */
    protected static Fingerprint[] createFingerprintLibrary() {
        Fingerprint[] fingerprints = new Fingerprint[102];
        
        // Level 0
        fingerprints[0] = new Fingerprint(0,"c",new int[] {});
        // Level 1
        fingerprints[1] = new Fingerprint(1,"1",new int[] {7});
        fingerprints[2] = new Fingerprint(2,"1",new int[] {8});
        fingerprints[3] = new Fingerprint(3,"cc",new int[] {5});
        // Level 2
        fingerprints[4] = new Fingerprint(4,"ad",new int[] {7,8});
        fingerprints[5] = new Fingerprint(5,"b",new int[] {7,9});
        fingerprints[6] = new Fingerprint(6,"b",new int[] {7,5});
        fingerprints[7] = new Fingerprint(7,"b",new int[] {7,6});
        fingerprints[8] = new Fingerprint(8,"a",new int[] {7,3});
        fingerprints[9] = new Fingerprint(9,"a",new int[] {8,4});
        fingerprints[10] = new Fingerprint(10,"b",new int[] {8,5});
        fingerprints[11] = new Fingerprint(11,"a",new int[] {8,2});
        // Level 3
        fingerprints[12] = new Fingerprint(12,"1",new int[] {7,8,9});
        fingerprints[13] = new Fingerprint(13,"b",new int[] {7,8,4});
        fingerprints[14] = new Fingerprint(14,"ab",new int[] {7,8,5});
        fingerprints[15] = new Fingerprint(15,"d",new int[] {7,8,6});
        fingerprints[16] = new Fingerprint(16,"a",new int[] {7,8,1});
        fingerprints[17] = new Fingerprint(17,"d",new int[] {7,8,2});
        fingerprints[18] = new Fingerprint(18,"d",new int[] {7,8,3});
        fingerprints[19] = new Fingerprint(19,"a",new int[] {7,9,5});
        fingerprints[20] = new Fingerprint(20,"ab",new int[] {7,9,1});
        fingerprints[21] = new Fingerprint(21,"a",new int[] {7,9,2});
        fingerprints[22] = new Fingerprint(22,"a",new int[] {7,5,6});
        fingerprints[23] = new Fingerprint(23,"1",new int[] {7,5,3});
        fingerprints[24] = new Fingerprint(24,"1",new int[] {7,6,2});
        fingerprints[25] = new Fingerprint(25,"ab",new int[] {8,4,5});
        fingerprints[26] = new Fingerprint(26,"b",new int[] {8,4,6});
        fingerprints[27] = new Fingerprint(27,"1",new int[] {8,5,2});
        // Level 4
        fingerprints[28] = new Fingerprint(28,"1",new int[] {7,8,9,4});
        fingerprints[29] = new Fingerprint(29,"1",new int[] {7,8,9,5});
        fingerprints[30] = new Fingerprint(30,"1",new int[] {7,8,9,1});
        fingerprints[31] = new Fingerprint(31,"1",new int[] {7,8,9,2});
        fingerprints[32] = new Fingerprint(32,"a",new int[] {7,8,4,5});
        fingerprints[33] = new Fingerprint(33,"a",new int[] {7,8,4,6});
        fingerprints[34] = new Fingerprint(34,"a",new int[] {7,8,4,3});
        fingerprints[35] = new Fingerprint(35,"b",new int[] {7,8,5,6});
        fingerprints[36] = new Fingerprint(36,"b",new int[] {7,8,5,1});
        fingerprints[37] = new Fingerprint(37,"1",new int[] {7,8,5,2});
        fingerprints[38] = new Fingerprint(38,"1",new int[] {7,8,5,3});
        fingerprints[39] = new Fingerprint(39,"b",new int[] {7,8,6,1});
        fingerprints[40] = new Fingerprint(40,"ab",new int[] {7,8,6,2});
        fingerprints[41] = new Fingerprint(41,"ab",new int[] {7,8,6,3});
        fingerprints[42] = new Fingerprint(42,"b",new int[] {7,8,1,2});
        fingerprints[43] = new Fingerprint(43,"b",new int[] {7,8,1,3});
        fingerprints[44] = new Fingerprint(44,"a",new int[] {7,8,2,3});   
        fingerprints[45] = new Fingerprint(45,"1",new int[] {7,9,5,1});
        fingerprints[46] = new Fingerprint(46,"b",new int[] {7,9,5,2});
        fingerprints[47] = new Fingerprint(47,"a",new int[] {7,9,1,3});
        fingerprints[48] = new Fingerprint(48,"b",new int[] {7,5,6,2});
        fingerprints[49] = new Fingerprint(49,"1",new int[] {8,4,5,6});
        fingerprints[50] = new Fingerprint(50,"a",new int[] {8,4,6,2});
        // Level 5
        fingerprints[51] = new Fingerprint(51,"1",new int[] {7,8,9,4,5});
        fingerprints[52] = new Fingerprint(52,"1",new int[] {7,8,9,5,6});
        fingerprints[53] = new Fingerprint(53,"1",new int[] {7,8,9,4,1});
        fingerprints[54] = new Fingerprint(54,"1",new int[] {7,8,9,4,2});
        fingerprints[55] = new Fingerprint(55,"1",new int[] {7,8,9,4,3});
        fingerprints[56] = new Fingerprint(56,"1",new int[] {7,8,9,5,1});
        fingerprints[57] = new Fingerprint(57,"1",new int[] {7,8,9,5,2});
        fingerprints[58] = new Fingerprint(58,"1",new int[] {7,8,9,1,2});
        fingerprints[59] = new Fingerprint(59,"1",new int[] {7,8,9,1,3});
        fingerprints[60] = new Fingerprint(60,"1",new int[] {7,8,4,5,6});
        fingerprints[61] = new Fingerprint(61,"1",new int[] {7,8,4,5,3});
        fingerprints[62] = new Fingerprint(62,"b",new int[] {7,8,4,6,2});
        fingerprints[63] = new Fingerprint(63,"b",new int[] {7,8,4,6,3});
        fingerprints[64] = new Fingerprint(64,"a",new int[] {7,8,5,6,1});
        fingerprints[65] = new Fingerprint(65,"1",new int[] {7,8,5,6,2});
        fingerprints[66] = new Fingerprint(66,"1",new int[] {7,8,5,6,3});
        fingerprints[67] = new Fingerprint(67,"1",new int[] {7,8,5,1,2});
        fingerprints[68] = new Fingerprint(68,"1",new int[] {7,8,5,1,3});
        fingerprints[69] = new Fingerprint(69,"1",new int[] {7,8,5,2,3});
        fingerprints[70] = new Fingerprint(70,"a",new int[] {7,8,6,1,2});
        fingerprints[71] = new Fingerprint(71,"a",new int[] {7,8,6,1,3});
        fingerprints[72] = new Fingerprint(72,"1",new int[] {7,9,5,1,3});
        fingerprints[73] = new Fingerprint(73,"1",new int[] {8,4,5,6,2});
        // Level 6
        fingerprints[74] = new Fingerprint(74,"1",new int[] {7,8,9,4,5,6});
        fingerprints[75] = new Fingerprint(75,"1",new int[] {7,8,9,4,5,1});
        fingerprints[76] = new Fingerprint(76,"1",new int[] {7,8,9,4,5,2});
        fingerprints[77] = new Fingerprint(77,"1",new int[] {7,8,9,4,5,3});
        fingerprints[78] = new Fingerprint(78,"1",new int[] {7,8,9,4,6,1});
        fingerprints[79] = new Fingerprint(79,"1",new int[] {7,8,9,4,6,2});
        fingerprints[80] = new Fingerprint(80,"1",new int[] {7,8,9,4,1,3});
        fingerprints[81] = new Fingerprint(81,"1",new int[] {7,8,9,4,2,3});
        fingerprints[82] = new Fingerprint(82,"1",new int[] {7,8,9,5,1,2});
        fingerprints[83] = new Fingerprint(83,"1",new int[] {7,8,9,5,1,3});
        fingerprints[84] = new Fingerprint(84,"1",new int[] {7,8,9,1,2,3});
        fingerprints[85] = new Fingerprint(85,"1",new int[] {7,8,4,5,6,2});
        fingerprints[86] = new Fingerprint(86,"1",new int[] {7,8,4,5,6,3});
        fingerprints[87] = new Fingerprint(87,"a",new int[] {7,8,4,6,2,3});
        fingerprints[88] = new Fingerprint(88,"1",new int[] {7,8,5,6,1,2});
        fingerprints[89] = new Fingerprint(89,"1",new int[] {7,8,5,6,1,3});
        // Level 7
        fingerprints[90] = new Fingerprint(90,"1",new int[] {7,8,9,4,5,6,1});
        fingerprints[91] = new Fingerprint(91,"1",new int[] {7,8,9,4,5,6,2});
        fingerprints[92] = new Fingerprint(92,"1",new int[] {7,8,9,4,5,1,3});
        fingerprints[93] = new Fingerprint(93,"1",new int[] {7,8,9,4,5,2,3});
        fingerprints[94] = new Fingerprint(94,"1",new int[] {7,8,9,4,6,1,2});
        fingerprints[95] = new Fingerprint(95,"1",new int[] {7,8,9,4,6,1,3});
        fingerprints[96] = new Fingerprint(96,"1",new int[] {7,8,9,5,1,2,3});
        fingerprints[97] = new Fingerprint(97,"1",new int[] {7,8,4,5,6,2,3});
        // Level 8
        fingerprints[98] = new Fingerprint(98,"1",new int[] {7,8,9,4,5,6,1,2});
        fingerprints[99] = new Fingerprint(99,"1",new int[] {7,8,9,4,5,6,1,3});
        fingerprints[100] = new Fingerprint(100,"1",new int[] {7,8,9,4,6,1,2,3});
        // Level 9
        fingerprints[101] = new Fingerprint(101,"1",new int[] {7,8,9,4,5,6,1,2,3});
        
        return fingerprints;
    }
    
}
