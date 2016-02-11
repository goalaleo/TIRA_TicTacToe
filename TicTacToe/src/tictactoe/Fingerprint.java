package tictactoe;

/**
 * An instance of this class - called a Fingerprint - defines a unique board situation.
 * There are 102 nonisomorphic ways to arrange 0-9 X's to a tic-tac-toe board. Each unique
 * instance of a Fingerprint has an assigned id number and a value, which is the misère
 * quotient of the Fingerprint as given in the Notakto Table in the "Dokumentaatio" -folder of
 * the repository.
 * @author Lepa
 */

public class Fingerprint {

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
     * unique identifier for a Fingerprint.
     * Count starts from 0 and increases from left to right and top to bottom
     * as given in the Notakto Table image in the "Dokumentaatio" -folder of the repository.
     */
    protected int id;
    /**
     * the misère quotient of the Fingerprint as given in the Notakto Table in the "Dokumentaatio" -folder of
     * the repository.
     */
    protected String value;
    /**
     * the number of X's in the Fingerprint. Possible following configurations of the board (Fingerprints)
     * is a subset of the Fingerprints of the next level.
     */
    protected int level;
    /**
     * whether or not the Fingerprint is symmetrical over the horizontal axis (axis trought nums 4,5 and 6)
     */
    public boolean horizontal_symmetry;
    /**
     * whether or not the Fingerprint is symmetrical over the vertical axis (axis trought nums 8,5 and 2)
     */
    public boolean vertical_symmetry;
    /**
     * whether or not the Fingerprint is symmetrical over the first diagonal axis (axis trought nums 7,5 and 3)
     */
    public boolean diagonal_1_symmetry;
    /**
     * whether or not the Fingerprint is symmetrical over the second diagonal axis (axis trought nums 1,5 and 9)
     */
    public boolean diagonal_2_symmetry;
    
/**
 * A Constructor for creating a Fingerprint.
 * @param id unique indentifier of the unique Fingerprint
 * @param value the misère quotient of the Fingerprint
 * @param filled which positions have an X
 */
    public Fingerprint(int id, String value, int[] filled) {
        this.id = id;
        this.value = value;
        this.level = filled.length;

        //this for loops cycles trought the array of integers given as a 
        //parameter, and changes the corresponding boolean value to true.
        for (int num : filled) {
            switch (num) {
                case 1:
                    num1 = true;
                    break;
                case 2:
                    num2 = true;
                    break;
                case 3:
                    num3 = true;
                    break;
                case 4:
                    num4 = true;
                    break;
                case 5:
                    num5 = true;
                    break;
                case 6:
                    num6 = true;
                    break;
                case 7:
                    num7 = true;
                    break;
                case 8:
                    num8 = true;
                    break;
                case 9:
                    num9 = true;
                    break;
            }
        }
        calculateSymmetries();
        
    }

    /**
     * converts the integer field id to string
     * @return a string representation of the integer
     */
    @Override
    public String toString() {
        return Integer.toString(id);
    }
/**
 * calculates and assings a boolean value for the symmetry fields
 */
    private void calculateSymmetries() {
        horizontal_symmetry = (num7 == num1 && num8 == num2 && num9 == num3);
        vertical_symmetry = (num7 == num9 && num4 == num6 && num1 == num3);
        diagonal_1_symmetry = (num4 == num8 && num1 == num9 && num2 == num6);
        diagonal_2_symmetry = (num8 == num6 && num7 == num3 && num4 == num3);
    }
  
}
