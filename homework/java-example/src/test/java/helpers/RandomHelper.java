package helpers;

import java.util.Random;

public class RandomHelper {

    private static final String DIGITS = "1234567890";
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    static Random rnd = new Random(System.currentTimeMillis());

    public static String getNumericLineWithLength(int length){
        return getRandomStringWithLength(length, DIGITS);
    }

    public static String getLettersLineWithLength(int length){
        return getRandomStringWithLength(length, LETTERS);
    }

    private static String getRandomStringWithLength(int length, String symbols){
        StringBuilder rndString = new StringBuilder();
        for(int i = 0; i < length; i++){
            rndString.append(getRandomSymbol(symbols));
        }
        return rndString.toString();
    }

    private static char getRandomSymbol(String symbols){
        return symbols.charAt(rnd.nextInt(symbols.length()));
    }


}
