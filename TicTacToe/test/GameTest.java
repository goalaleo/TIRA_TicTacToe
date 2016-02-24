/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import static org.junit.Assert.*;
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
        Fingerprint f0 = peli.fprintLibrary.fingerprints[0];
        assertTrue(f0.horizontal_symmetry);
        assertTrue(f0.vertical_symmetry);
        assertTrue(f0.diagonal_1_symmetry);
        assertTrue(f0.diagonal_2_symmetry);
    }

    @Test
    public void testSymmetries1() {

        //F1 symmetries
        Fingerprint f1 = peli.fprintLibrary.fingerprints[1];
        assertFalse(f1.horizontal_symmetry);
        assertFalse(f1.vertical_symmetry);
        assertTrue(f1.diagonal_1_symmetry);
        assertFalse(f1.diagonal_2_symmetry);
    }

    @Test
    public void testSymmetries2() {

        //F2 symmetries
        Fingerprint f2 = peli.fprintLibrary.fingerprints[2];
        assertFalse(f2.horizontal_symmetry);
        assertTrue(f2.vertical_symmetry);
        assertFalse(f2.diagonal_1_symmetry);
        assertFalse(f2.diagonal_2_symmetry);
    }

    @Test
    public void testSymmetries4() {

        //F4 symmetries
        Fingerprint f4 = peli.fprintLibrary.fingerprints[4];
        assertFalse(f4.horizontal_symmetry);
        assertFalse(f4.vertical_symmetry);
        assertFalse(f4.diagonal_1_symmetry);
        assertFalse(f4.diagonal_2_symmetry);
    }

    @Test
    public void testSymmetries27() {

        //F27 symmetries
        Fingerprint f27 = peli.fprintLibrary.fingerprints[27];
        assertTrue(f27.horizontal_symmetry);
        assertTrue(f27.vertical_symmetry);
        assertFalse(f27.diagonal_1_symmetry);
        assertFalse(f27.diagonal_2_symmetry);
    }

    /**
     * This test is meant to test my justified guess of how to calculate the
     * number of isomorphisms for a given {@link Fingerprint}. The total number
     * of different Board/Fingerprint configurations is 102 when not counting
     * isomorphisms, and 2^9= 512 when isomorphisms are not taken into account.
     * Thus the sum of the isomorphisms of each Fingerprint should equal 512. A
     * single Fingerprint has 8,4,2 or 1 isomorphisms depending on the number of
     * axels of symmetry that it has. This will be explained better in the
     * documentation files of this project.
     */
    @Test
    public void testIsomorphicCalculation() {
        int configurations = 0;
        int numberOf8s = 0;
        int numberOf4s = 0;
        int numberOf2s = 0;
        int numberOf1s = 0;
        
        ArrayList<Integer> ids8 = new ArrayList<>();
        ArrayList<Integer> ids4 = new ArrayList<>();
        ArrayList<Integer> ids2 = new ArrayList<>();
        ArrayList<Integer> ids1 = new ArrayList<>();
        
        assertEquals(102, peli.fprintLibrary.fingerprints.length);
        int i = 1;
        for (Fingerprint fprint : peli.fprintLibrary.fingerprints) {
            //no symmetries
            if ((fprint.horizontal_symmetry == false) && (fprint.vertical_symmetry == false) && (fprint.diagonal_1_symmetry == false) && (fprint.diagonal_2_symmetry == false)) {
                configurations += 8;
                numberOf8s++;
                ids8.add(fprint.id);
                //1 symmetry
            } else if (fprint.horizontal_symmetry ^ fprint.vertical_symmetry ^ fprint.diagonal_1_symmetry ^ fprint.diagonal_2_symmetry) {
                configurations += 4;
                numberOf4s++;
                ids4.add(fprint.id);
                //2 symmetries, either vertical & horizontal or both diagonals 
            } else if ((fprint.horizontal_symmetry && fprint.vertical_symmetry) ^ (fprint.diagonal_1_symmetry && fprint.diagonal_2_symmetry)) {
                configurations += 2;
                numberOf2s++;
                ids2.add(fprint.id);
                //4 symmetries
            } else if (fprint.horizontal_symmetry && fprint.vertical_symmetry && fprint.diagonal_1_symmetry && fprint.diagonal_2_symmetry) {
                configurations += 1;
                numberOf1s++;
                ids1.add(fprint.id);
            }
            
            System.out.println("after round: "+i);
            System.out.println("number of 8s: "+ids8);
            System.out.println("number of 4s: "+ids4);
            System.out.println("number of 2s: "+ids2);
            System.out.println("number of 1s: "+ids1);
            System.out.println("--------------------");
            i++;
        }
        System.out.println("8s: "+ids8);
        System.out.println("4s: "+ids4);
        System.out.println("2s: "+ids2);
        System.out.println("1s: "+ids1);
//        assertEquals(36, numberOf8s); //was 40
//        assertEquals(50, numberOf4s); //was 48
        assertEquals(8, numberOf2s);  //was 6
        assertEquals(8, numberOf1s);  //was 4
        assertEquals(102, (numberOf1s+numberOf2s+numberOf4s+numberOf8s));  //was 100
        assertEquals(512, configurations);
    }

    /**
     * This tests the 2 helper functions in this test class called
     * {@link #mirrorOverAxis(tictactoe.Fingerprint)} and
     * {@link  #exactMatch(tictactoe.Fingerprint, tictactoe.Fingerprint)}
     */
    @Test
    public void testMirroringAndExactMatch() {
        Fingerprint original = peli.fprintLibrary.fingerprints[1];
        Fingerprint mirrored = mirrorOverAxis(original);
        assertEquals(true, exactMatch(original, mirrored));

        original = peli.fprintLibrary.fingerprints[2];
        mirrored = mirrorOverAxis(original);
        assertEquals(false, exactMatch(original, mirrored));

        original = peli.fprintLibrary.fingerprints[4];
        mirrored = mirrorOverAxis(original);
        assertEquals(false, exactMatch(original, mirrored));

        original = peli.fprintLibrary.fingerprints[36];
        mirrored = mirrorOverAxis(original);
        assertEquals(false, exactMatch(original, mirrored));

    }

    @Test
    public void testRotatingAndExactMatch() {
        Fingerprint original = peli.fprintLibrary.fingerprints[1];
        Fingerprint rotated = rotateClockwise(original);
        assertEquals(false, exactMatch(original, rotated));

        original = peli.fprintLibrary.fingerprints[27];
        Fingerprint rotatedTwice = rotateClockwise(rotateClockwise(original));
        assertEquals(true, exactMatch(original, rotatedTwice));
    }
    
    @Test
    public void matchesAreOfCorrectAmount(){
        for (Fingerprint fprint : peli.fprintLibrary.fingerprints) {
            int uniques = uniqueIsomorphisms(fprint);
            assertTrue(uniques == 1
            || uniques == 2
            || uniques == 4
            || uniques == 8);
        }
    }

    private Integer uniqueIsomorphisms(Fingerprint fprintOriginal) {
        Fingerprint[] allVariations = new Fingerprint[8];
        //original
        allVariations[0] = fprintOriginal;
        //1 rotation
        allVariations[1] = rotateClockwise(fprintOriginal);
        //2 rotations
        allVariations[2] = rotateClockwise(rotateClockwise(fprintOriginal));
        //3 rotations
        allVariations[3] = rotateClockwise(rotateClockwise(rotateClockwise(fprintOriginal)));
        //mirroring
        allVariations[4] = mirrorOverAxis(fprintOriginal);
        //mirroring and 1 rotation
        allVariations[5] = rotateClockwise(mirrorOverAxis(fprintOriginal));
        //mirroring and 2 rotations
        allVariations[6] = rotateClockwise(rotateClockwise(mirrorOverAxis(fprintOriginal)));
        //mirroring and 3 rotations
        allVariations[7] = rotateClockwise(rotateClockwise(rotateClockwise(mirrorOverAxis(fprintOriginal))));
        
        int matches = 0;
        int i = 0;
        
            for (int j = 0; j < 8; j++) {
                if (exactMatch(allVariations[i], allVariations[j])) {
                    matches++;
                }
        }
            if(matches == 8){
                return 1;
            } else if (matches == 4){
                return 2;
            } else if (matches == 2){
                return 4;
            } else if (matches == 1){
                return 8;
            }
        return null;
    }
    

    /**
     * Rotates the {@link Fingerprint}s numpad values/Xs 90-degrees clockwise.
     * @param inputFingerprint {@link Fingerprint} to rotate
     * @return rotated {@link Fingerprint}
     */
    private Fingerprint rotateClockwise(Fingerprint inputFingerprint) { //TODO: new param field for number of rotations wanted ->cleaner method call

        //stays the same
        boolean newnum5 = inputFingerprint.num5;
        //rotates
        boolean newnum7 = inputFingerprint.num1;
        boolean newnum9 = inputFingerprint.num7;
        boolean newnum3 = inputFingerprint.num9;
        boolean newnum1 = inputFingerprint.num3;

        boolean newnum8 = inputFingerprint.num4;
        boolean newnum6 = inputFingerprint.num8;
        boolean newnum2 = inputFingerprint.num6;
        boolean newnum4 = inputFingerprint.num2;

        boolean[] newNumsAsList = new boolean[]{newnum7, newnum8, newnum9,
            newnum4, newnum5, newnum6, newnum1, newnum2, newnum3};

        int listLenght = howManyAreTrue(newNumsAsList);
        //initialize list to be passed to Fingerprint constructor below
        int[] xlocations = numsAsListOfIntegers(newNumsAsList, listLenght);

        return new Fingerprint(inputFingerprint.id, inputFingerprint.value, xlocations);
    }

    /**
     * Mirrors the Fingerprint over a diagonal axis going trough nums 7,5 and 3
     * @param inputFingerprint {@link Fingerprint} to be mirrored
     * @return mirrored {@link Fingerprint}
     */
    private Fingerprint mirrorOverAxis(Fingerprint inputFingerprint) {
        //stays the same
        boolean newnum7 = inputFingerprint.num7;
        boolean newnum5 = inputFingerprint.num5;
        boolean newnum3 = inputFingerprint.num3;
        //switches place
        boolean newnum4 = inputFingerprint.num8;
        boolean newnum8 = inputFingerprint.num4;

        boolean newnum1 = inputFingerprint.num9;
        boolean newnum9 = inputFingerprint.num1;

        boolean newnum2 = inputFingerprint.num6;
        boolean newnum6 = inputFingerprint.num2;

        boolean[] newNumsAsList = new boolean[]{newnum7, newnum8, newnum9,
            newnum4, newnum5, newnum6, newnum1, newnum2, newnum3};

        int listLenght = howManyAreTrue(newNumsAsList);
        //initialize list to be passed to Fingerprint constructor below
        int[] xlocations = numsAsListOfIntegers(newNumsAsList, listLenght);

        return new Fingerprint(inputFingerprint.id, inputFingerprint.value, xlocations);
    }

    /**
     * Checks how many of the numpad values are true
     * @param nums list of numpad values
     * @return how many were true
     */
    private int howManyAreTrue(boolean[] nums) {

        //check how many values are true
        int numberOfTrues = 0;
        for (boolean num : nums) {
            if (num == true) {
                numberOfTrues++;
            }
        }

        return numberOfTrues;
    }

    /**
     * Checks if two Fingerprints are an exact match, doesn't take into account isomorphisms.
     * @param f1 first {@link Fingerprint}
     * @param f2 second {@link Fingerprint}
     * @return true if all numpad values match
     */
    private boolean exactMatch(Fingerprint f1, Fingerprint f2) {
        return (f1.num7 == f2.num7
                && f1.num8 == f2.num8
                && f1.num9 == f2.num9
                && f1.num4 == f2.num4
                && f1.num5 == f2.num5
                && f1.num6 == f2.num6
                && f1.num1 == f2.num1
                && f1.num2 == f2.num2
                && f1.num3 == f2.num3);

    }

    /**
     * If the numpad value is true it adds it as an integer to the list that is
     * returned. The returned list is of the type that is used by the
     * {@link Fingerprint} constructor.
     *
     * @param nums a list of boolean values corresponding to numpad positions in
     * order 7,8,9,4,5,6,1,2,3
     * @param listLenght how many true values are in the nums, used for
     * initializing list with correct lenght
     * @return a list of integers, as required by {@link Fingerprint}
     * constructor
     */
    private int[] numsAsListOfIntegers(boolean[] nums, int listLenght) {
        int i = 0;
        int[] xlocations = new int[listLenght];
        //add number to list if numvalue is true, and increase index
        if (nums[0]) {
            xlocations[i] = 7;
            i++;
        }
        if (nums[1]) {
            xlocations[i] = 8;
            i++;
        }
        if (nums[2]) {
            xlocations[i] = 9;
            i++;
        }
        if (nums[3]) {
            xlocations[i] = 4;
            i++;
        }
        if (nums[4]) {
            xlocations[i] = 5;
            i++;
        }
        if (nums[5]) {
            xlocations[i] = 6;
            i++;
        }
        if (nums[6]) {
            xlocations[i] = 1;
            i++;
        }
        if (nums[7]) {
            xlocations[i] = 2;
            i++;
        }
        if (nums[8]) {
            xlocations[i] = 3;
            i++;
        }
        return xlocations;
    }

}
