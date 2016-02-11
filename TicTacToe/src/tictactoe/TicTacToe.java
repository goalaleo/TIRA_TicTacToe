
package tictactoe;

import java.util.Arrays;

/**
 * The main class of the program
 * @author Lepa
 */
public class TicTacToe {

    /**
     * main method of main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game peli = new Game();
        System.out.println("F0 symmetries:");
        Fingerprint f0 = peli.fingerprints[0];
        System.out.println(f0.horizontal_symmetry);
        System.out.println(f0.vertical_symmetry);
        System.out.println(f0.diagonal_1_symmetry);
        System.out.println(f0.diagonal_2_symmetry);
        System.out.println("--------------------------");
        System.out.println("F1 symmetries:");
        Fingerprint f1 = peli.fingerprints[1];
        System.out.println(f1.horizontal_symmetry);
        System.out.println(f1.vertical_symmetry);
        System.out.println(f1.diagonal_1_symmetry);
        System.out.println(f1.diagonal_2_symmetry);
        System.out.println("--------------------------");
        System.out.println("F2 symmetries:");
        Fingerprint f2 = peli.fingerprints[2];
        System.out.println(f2.horizontal_symmetry);
        System.out.println(f2.vertical_symmetry);
        System.out.println(f2.diagonal_1_symmetry);
        System.out.println(f2.diagonal_2_symmetry);
        System.out.println("--------------------------");
        System.out.println("F4 symmetries:");
        Fingerprint f4 = peli.fingerprints[4];
        System.out.println(f4.horizontal_symmetry);
        System.out.println(f4.vertical_symmetry);
        System.out.println(f4.diagonal_1_symmetry);
        System.out.println(f4.diagonal_2_symmetry);
        System.out.println("--------------------------");
        System.out.println("F27 symmetries:");
        Fingerprint f27 = peli.fingerprints[27];
        System.out.println(f27.horizontal_symmetry);
        System.out.println(f27.vertical_symmetry);
        System.out.println(f27.diagonal_1_symmetry);
        System.out.println(f27.diagonal_2_symmetry);
        
    }

    
    
    
    
}
