
package tictactoe;

import java.util.Arrays;

/**
 *
 * @author Lepa
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        createFingerprintLibrary();
    }

    private static Fingerprint[] createFingerprintLibrary() {
        Fingerprint[] fingerprints = new Fingerprint[102];
        
        fingerprints[0] = new Fingerprint("0","c",new int[] {});
        
        fingerprints[1] = new Fingerprint("11","1",new int[] {7});
        fingerprints[2] = new Fingerprint("12","1",new int[] {8});
        fingerprints[3] = new Fingerprint("13","cc",new int[] {5});
        
        fingerprints[4] = new Fingerprint("21","ad",new int[] {7,8});
        fingerprints[5] = new Fingerprint("22","b",new int[] {7,9});
        fingerprints[6] = new Fingerprint("23","b",new int[] {7,5});
        fingerprints[7] = new Fingerprint("24","b",new int[] {7,6});
        fingerprints[8] = new Fingerprint("25","a",new int[] {7,3});
        fingerprints[9] = new Fingerprint("26","a",new int[] {8,4});
        fingerprints[10] = new Fingerprint("27","b",new int[] {8,5});
        fingerprints[11] = new Fingerprint("28","a",new int[] {8,2});
        
        fingerprints[12] = new Fingerprint("31","1",new int[] {7,8,9});
        fingerprints[13] = new Fingerprint("32","b",new int[] {7,8,4});
        fingerprints[14] = new Fingerprint("33","ab",new int[] {7,8,5});
        fingerprints[15] = new Fingerprint("34","d",new int[] {7,8,6});
        fingerprints[16] = new Fingerprint("35","a",new int[] {7,8,1});
        fingerprints[17] = new Fingerprint("36","d",new int[] {7,8,2});
        fingerprints[18] = new Fingerprint("37","d",new int[] {7,8,3});
        fingerprints[19] = new Fingerprint("38","a",new int[] {7,9,5});
        fingerprints[20] = new Fingerprint("39","ab",new int[] {7,9,1});
        fingerprints[21] = new Fingerprint("310","a",new int[] {7,9,2});
        fingerprints[22] = new Fingerprint("311","a",new int[] {7,5,6});
        fingerprints[23] = new Fingerprint("312","1",new int[] {7,5,3});
        fingerprints[24] = new Fingerprint("313","1",new int[] {7,6,2});
        fingerprints[25] = new Fingerprint("314","ab",new int[] {8,4,5});
        fingerprints[26] = new Fingerprint("315","b",new int[] {8,4,6});
        fingerprints[27] = new Fingerprint("316","1",new int[] {8,5,2});
        
        fingerprints[28] = new Fingerprint("41","1",new int[] {7,8,9,4});
        fingerprints[29] = new Fingerprint("42","1",new int[] {7,8,9,5});
        fingerprints[30] = new Fingerprint("43","1",new int[] {7,8,9,1});
        fingerprints[31] = new Fingerprint("44","1",new int[] {7,8,9,2});
        fingerprints[32] = new Fingerprint("45","a",new int[] {7,8,4,5});
        fingerprints[33] = new Fingerprint("46","a",new int[] {7,8,4,6});
        fingerprints[34] = new Fingerprint("47","a",new int[] {7,8,4,3});
        fingerprints[35] = new Fingerprint("48","b",new int[] {7,8,5,6});
        fingerprints[36] = new Fingerprint("49","b",new int[] {7,8,5,1});
        fingerprints[37] = new Fingerprint("410","1",new int[] {7,8,5,2});
        fingerprints[38] = new Fingerprint("411","1",new int[] {7,8,5,3});
        
        
        
        System.out.println(Arrays.toString(fingerprints));
        
        
        return fingerprints;
    }
    
}
