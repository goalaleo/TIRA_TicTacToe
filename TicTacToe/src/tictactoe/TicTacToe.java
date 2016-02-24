
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
        String uniques = "144184482442448888844482444284844848888884484441441844888484844888448444114488844884248244844844224411";
        System.out.println("elements :"+uniques.length());
        int i = 0;
        int sum = 0;
        int counter = 0;
        while(i<uniques.length()){
            sum += Integer.parseInt(uniques.substring(i, i+1));
            i++;
            counter++;
        }
        System.out.println("sum of isomorphisms :"+sum);
        System.out.println("counter: "+counter);
        
        int numberof8 = 0;
        int numberof4 = 0;
        int numberof2 = 0;
        int numberof1 = 0;
        i = 0;
        while(i<uniques.length()){
            int number = Integer.parseInt(uniques.substring(i,i+1));
            if(number == 8)
                numberof8++;
            if(number == 4)
                numberof4++;
            if(number == 2)
                numberof2++;
            if(number == 1)
                numberof1++;
            i++;
        }
        System.out.println("8s: "+numberof8);
        System.out.println("4s: "+numberof4);
        System.out.println("2s: "+numberof2);
        System.out.println("1s: "+numberof1);
        System.out.println("no. of numbers in string: "+(numberof8+numberof4+numberof2+numberof1));
        
        
        
        
        
    }

    
    
    
    
}
