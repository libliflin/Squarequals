/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package squarequals;

import java.math.BigInteger;

/**
 * 
 * Pronounced Square-Qual 
 *
 * if x is a squarequal then x * 10^n for any int in is a squarequal
 * 
 * if x is a squarequal then all right substrings of x are squarequals
 *      You know, deal with leading zeros too yeah?
 * 
 * 
 * 
 * @author wjlaffin
 */
public class Squarequals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Squarequals squarequals = new Squarequals();
        int[] digitsBackward = new int[34];
        System.out.println(1 % 10);
        int[] singles = {1, 5, 6};
        for(int starter : singles){
            extend(BigInteger.valueOf(starter), 1);
        }
//        squarequals.search(digitsBackward,0, 0, 0);
    }
    
    public static int numDigits(BigInteger i){
        return i.toString().length(); // no log method?
//        return 1 + (int)Math.floor(Math.log10(i));
    }
    
    static int maxDepth = 30;
    
    public static  void extend(BigInteger toExtend, int depth){
        if(depth > maxDepth){
            return;
        }else{
//            System.out.println(String.format("%"+depth+"d", toExtend).replace(" ", "0"));
        }
        if(depth == numDigits(toExtend)){
            System.out.println("squarequal: " + String.format("%"+maxDepth+"d", toExtend));
        }
        // leading zeros
        extend(toExtend, depth+1);
        int numDigits = depth;//numDigits(toExtend);
        for(int i = 1; i < 10; i++){
            BigInteger Edepth = BigInteger.TEN.pow(numDigits); // pow
            BigInteger I = BigInteger.valueOf(i);
            BigInteger possibleExtended = I.multiply(Edepth).add(toExtend);
            BigInteger toCheck = possibleExtended.multiply(possibleExtended).mod(Edepth.multiply(BigInteger.TEN));
            
            boolean check = possibleExtended.equals(toCheck);
//            if(depth > numDigits(toExtend.add(BigInteger.valueOf(4)))){
//                System.out.println("tabs:" );
//                System.out.println(String.format("s  %20d", toExtend));
//                System.out.println(String.format("e  %20d", i));
//                System.out.println(String.format("p  %20d", possibleExtended));
//                System.out.println(String.format("^2 %20d", toCheck));
//                System.out.println(String.format("%%^ %20d", squared % (pow*10)));
//                System.out.println("");
//            }
            if(check){
                extend(possibleExtended, depth + 1);
            }
        }
//        Math.log
    }
    
    
    public void search(int[] digitsBackward, int index, int lastCarry, int squared){
        for(int j = 0; j < index; j++){
//            lastCarry + 2 * 
            for(int i = 0; i < 10; i ++){
                int iSquared = i * i;
                int xbit = iSquared % 10;
                int carry = iSquared / 10;
                if(xbit == i){
                    System.out.println(i + " " + carry);
//                    digitsSoFar.add(i);
//                    //recurse
//                    digitsSoFar.r
                }
            }
        }
    }
    
}
