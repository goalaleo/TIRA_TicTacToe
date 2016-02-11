/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import tictactoe.Fingerprint;
import tictactoe.Game;

/**
 *
 * @author Lepa
 */
public class GameTest {

    Game peli;

    public GameTest() {
    }

    @Before
    public void setUp() {
        peli = new Game();
    }

    @Test
    public void testSymmetries0() {

        //F0 symmetries
        Fingerprint f0 = peli.fingerprints[0];
        assertTrue(f0.horizontal_symmetry);
        assertTrue(f0.vertical_symmetry);
        assertTrue(f0.diagonal_1_symmetry);
        assertTrue(f0.diagonal_2_symmetry);
    }

    @Test
    public void testSymmetries1() {

        //F1 symmetries
        Fingerprint f1 = peli.fingerprints[1];
        assertFalse(f1.horizontal_symmetry);
        assertFalse(f1.vertical_symmetry);
        assertTrue(f1.diagonal_1_symmetry);
        assertFalse(f1.diagonal_2_symmetry);
    }

    @Test
    public void testSymmetries2() {

        //F2 symmetries
        Fingerprint f2 = peli.fingerprints[2];
        assertFalse(f2.horizontal_symmetry);
        assertTrue(f2.vertical_symmetry);
        assertFalse(f2.diagonal_1_symmetry);
        assertFalse(f2.diagonal_2_symmetry);
    }

    @Test
    public void testSymmetries4() {

        //F4 symmetries
        Fingerprint f4 = peli.fingerprints[4];
        assertFalse(f4.horizontal_symmetry);
        assertFalse(f4.vertical_symmetry);
        assertFalse(f4.diagonal_1_symmetry);
        assertFalse(f4.diagonal_2_symmetry);
    }

    @Test
    public void testSymmetries27() {

        //F27 symmetries
        Fingerprint f27 = peli.fingerprints[27];
        assertTrue(f27.horizontal_symmetry);
        assertTrue(f27.vertical_symmetry);
        assertFalse(f27.diagonal_1_symmetry);
        assertFalse(f27.diagonal_2_symmetry);
    }
    
    /**
     * This test is meant to test my justified guess of how to calculate the number of
     * isomorphisms for a given {@link Fingerprint}. The total number of different Board/Fingerprint
     * configurations is 102 when not counting isomorphisms, and 2^9= 512 when isomorphisms are
     * not taken into account. Thus the sum of the isomorphisms of each Fingerprint should equal 512.
     * A single Fingerprint has 8,4,2 or 1 isomorphisms depending on the number of axels of symmetry
     * that it has. This will be explained better in the documentation files of this project.
     */
    @Test
    public void testIsomorphicCalculation(){
        int configurations = 0;
        for (Fingerprint fprint : peli.fingerprints) {
            //no symmetries
            if(!fprint.horizontal_symmetry && !fprint.vertical_symmetry && !fprint.diagonal_1_symmetry && !fprint.diagonal_2_symmetry){
                configurations += 8;
            }
            //1 symmetry
            if(){
                
            }
            
            
        }
    }
}
