import javax.swing.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        BigInteger e = new BigInteger("17");
        BigInteger p1p2 = new BigInteger("6050707769");

        String input = JOptionPane.showInputDialog("Enter something to encrypt:");
        String inputAsNumbers = turnStringIntoWordString(input);
        //System.out.println(inputAsNumbers);









        String numbersString = turnStringIntoWordString("Hello");
        System.out.println(numbersString);
        System.out.println(grabFirst9(numbersString));
        System.out.println(encrypt(grabFirst9(numbersString), e, p1p2));













    }

    public static String turnStringIntoWordString(String s) {
        String out = "";
        for(int i=0; i < s.length(); i++) {
            String currentLetter = grabLetter(s,i);
            int charCode = changeLetterToNumber(currentLetter);
            String threeDigitString = turnIntInto3DigitString(charCode);
            out += threeDigitString;
        }
        return out;
    }

    public static String grabLetter(String s, int index) {
        return s.substring(index, index+1);
    }

    public static void grabLetters(String s) {
        for(int i=0; i < s.length(); i++) {
            String currentCharacter = s.substring(i,i+1);
            System.out.println(currentCharacter);
            changeLetterToNumber(currentCharacter);
        }
    }

    public static BigInteger encrypt(String s, BigInteger e, BigInteger p1p2) {
        //step 1, get String s into BigInteger format
        BigInteger m = new BigInteger(s);
        BigInteger encrypted = m.modPow(e,p1p2); //encryption algorithm
        return  encrypted;
    }

    public static String grabFirst9(String s) {
        String front9 = "";
        if(s.length() >= 9)
            front9 = s.substring(0,9);
        else {
            if (s.length() == 6)
                front9 = s + "000";
            else if(s.length() == 3)
                front9 = s + "000000";
        }
        return front9;
    }

    /*
     * String letter MUST BE a single letter
     */
    public static int changeLetterToNumber(String letter) {
        char character = letter.charAt(0); //turn String into single character
        int charCode = (int)character;
        return charCode;
    }

    /*
     * int num MUST BE 3-digits or less
     */
    public static String turnIntInto3DigitString(int num) {
        //if num is 3-digits
        if(num >= 100) {
            return "" + num;
        }
        //else if num is 2-digits
        else if(num >= 10) {
            return "0" + num;
        }
        //else if num is a single digit
        else if(num >= 0) {
            return "00" + num;
        }

        return "???";//Why would this happen??????
    }
}
