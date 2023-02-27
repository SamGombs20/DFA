package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Character> alphabet =new ArrayList<>(2);
    public static void main(String[] args) {
        System.out.println("Enter the accepted symbols:");
        Scanner input = new Scanner(System.in);
        char val1 = input.next().charAt(0);
        char val2 = input.next().charAt(0);
        alphabet.add(val1);
        alphabet.add(val2);
        System.out.println("Alphabet = "+ alphabet);
        String inputWord=collectInput();
        //This process is repeated so long as the input is not 'Q'.
        while (!inputWord.equals("Q")){
            System.out.println(inputConfirmation(inputWord, val1, val2));
            inputWord = collectInput();
        }

    }
    //Rejects or accepts the input string.
    public static String inputConfirmation(String word, char symbol1, char symbol2){
        boolean isValid = checkStringSymbols(word, symbol1, symbol2);
        if (isValid){
            boolean isLanguage1 = language1(word, symbol1, symbol2);
            boolean isLanguage2 = language2(word, symbol1, symbol2);
            if (isLanguage1||isLanguage2){
                return "ACCEPTED";
            }
            return "REJECTED";
        }
        return "REJECTED";
    }
    //Allows for input of the string
    public static String collectInput(){
        System.out.println("Enter a string using the above alphabet:(press 'Q' to exit)");
        Scanner input = new Scanner(System.in);
        return input.next();
    }
    //Makes sure the input string consists of the symbols as specified in the alphabet only.
    public static boolean checkStringSymbols(String word, Character symbol1, Character symbol2){
        boolean isValid=true;
        for (int i =0;i<word.length();i++){
            if (!((word.charAt(i)==symbol1)||(word.charAt(i)==symbol2))){
                isValid=false;
                break;
            }
        }
        return isValid;
    }
    //Checks if the input string is L1,i.e, ends with the first symbol pair. e.g. 'aa'
    public static boolean language1(String word, char symbol1, char symbol2){
        char state='A';
        if(checkStringSymbols(word, symbol1, symbol2)){
            for (int i =0;i<word.length();i++){
                if((word.charAt(i)==symbol1) && state=='A'){
                    state= 'B';
                } else if ((word.charAt(i)==symbol1) && state=='B') {
                    state ='C';
                } else if ((word.charAt(i)==symbol2) && state=='B') {
                    state='A';
                }  else if ((word.charAt(i)==symbol2) && state=='C') {
                    state = 'A';
                }
            }
        }
        return state=='C';
    }
    //Checks if the input string forms L2, i.e, contains a combination of first symbol, second symbol then the first symbol.e.g. 'aba'.
    public static boolean language2(String word, char symbol1, char symbol2){
        char state ='A';
        if(checkStringSymbols(word, symbol1, symbol2)){
            for (int i =0; i<word.length();i++){
                if ((word.charAt(i)==symbol1) && state=='A'){
                    state = 'B';
                } else if ((word.charAt(i) == symbol2) && state == 'B') {
                    state = 'C';
                } else if ((word.charAt(i)==symbol1) && state == 'C') {
                    state='D';
                    break;
                } else if ((word.charAt(i)==symbol2) && state=='C') {
                    state ='A';
                }
            }
        }
        return state=='D';
    }
}