package tictactoe;

/**
 *
 * @author Lepa
 */
public class Fingerprint {

    protected boolean num7 = false;
    protected boolean num8 = false;
    protected boolean num9 = false;
    protected boolean num4 = false;
    protected boolean num5 = false;
    protected boolean num6 = false;
    protected boolean num1 = false;
    protected boolean num2 = false;
    protected boolean num3 = false;
    protected String id;
    protected String value;

    public Fingerprint(String id, String value, int[] filled) {
        this.id = id;
        this.value = value;

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
    }

    @Override
    public String toString() {
        return this.id;
    }
    
    
}
