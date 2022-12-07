import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {
    "+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String word = randomWord(words);

        int x = word.length();
        char[] charList = new char[x];

        System.out.print("\nWord: ");
        for (int i=0; i<x; i++){
            charList[i] = '_';
            System.out.print(charList[i] + " ");
        }

        String missedWord = "";

        int misscount = 0;

        String s;
        char guessChar;

        while (misscount<6){

            System.out.print("\nGuess: ");
            s = scan.next();
            guessChar = s.charAt(0);

            if (checkGuess(word, guessChar)){
                charList = updatePlaceHolders(charList, word, guessChar);

            } else {
                missedWord = printMissedGuess(missedWord, guessChar);
                misscount++;
            }


            printDrawing(gallows, misscount);

            System.out.print("\nWord: ");
            for (int i=0; i<charList.length; i++){
                System.out.print(charList[i] + " ");
            }

            if (checkWin(word, charList)){
                System.out.println("\nYou win!!!");
                System.exit(0);
            }

            System.out.println("\nMissed guess: " + missedWord);

        }//while loop

        System.out.println("Sorry! You lose!");
        System.out.println("The correct word: " + word);

        scan.close();

    }//main



    public static String randomWord(String[] array){

        int i = (int)(Math.random()*words.length) + 1;
        return array[i];

    }//metoder: pick a random word

    public static void printDrawing(String[] array, int count){
        System.out.println(array[count]);
    }//metoder: print drawings

    public static boolean checkGuess(String s, char c){
        return s.indexOf(c)>=0;
    }//metoder: checkGuess

    public static char[] updatePlaceHolders(char[] array, String word, char c){
        int x = word.length();
        char[] newList = array;
        
        for (int i=0; i<x; i++){
            if (word.charAt(i)==c){
                newList[i] = c;
            }
        }

        return newList;

    }//metoder: update the word array

    public static String printMissedGuess(String s, char c){
        s += c;
        return s;
    }//metoder: missed guess (String)

    public static boolean checkWin (String s, char[] array){
        String s1 = String.valueOf(array);

        return s.equalsIgnoreCase(s1);

    }
    
}//class






