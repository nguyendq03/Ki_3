package charactercount;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * The program use StringTokenizer library and HashMap library, StringTokenizer
 * library will use to StringTokenizer a string and use HashMap to get the
 * occurrence of each word and each letter.  
 *
 */

public class CharacterCount {
    /**
     * The above code is a Java program that counts the occurrence of words and letters in a given input string.
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        //First, the program prompts the user to enter their content and converts it to lowercase
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String content = scanner.nextLine().toLowerCase();
        //Uses the StringTokenizer class to tokenize the string into individual words and counts the occurrence of each word using a HashMap.
        StringTokenizer tokenizer = new StringTokenizer(content);
        //Count the occurrence of each word with the call tokenizer.hasMoreTokens
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        //The program loops through each word and removes any non-letter characters, such as numbers and special characters.
        // It then checks if the resulting string is a valid word (i.e. starts with a letter) and adds it to the word count HashMap.
        // The hasMoreTokens check if there is any word part in the string
        while (tokenizer.hasMoreTokens()) {
            //nextToken is return element next in string
            String word = tokenizer.nextToken();
            //Create and edit strings
            StringBuilder test = new StringBuilder(" ");
            //Loop using run display only string
            for (int i = 0; i < word.length(); i++) {
                // Check if character, then add "test" StringBuilder object using the append() method
                if (Character.isLetter(word.charAt(i))) test.append(word.charAt(i));
            }
            //Check if word start with letter, then display string
            if (checkWord(test.toString())) {
                //Frequency of occurrence of word, if word then add,getOrDefault is if word then add
                wordCountMap.put(test.toString(), wordCountMap.getOrDefault(test.toString(), 0) + 1);
            }
        }
        System.out.println(wordCountMap);
        //Create another HashMap to count the occurrence times of each letter
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        //Delete any space of string
        content = content.replaceAll("\\s", "");
        //This loop display each letter loop for run all string, then adding it to letter count HashMap.
        for (char ch : content.toCharArray()) {
            //Frequency of occurrence of letters, if letter then add,getOrDefault is if letter then add
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }
        System.out.println(charCountMap);
    }

    /**
     * A function to check word when it exists, not start with numbers.
     * @param word the word to check
     * @return true if the word is valid, false otherwise
     */
    public static boolean checkWord(String word) {
        //Create check start with letter, toCharArray convert strings to character arrays
        char[] wordChar = word.toCharArray();
        //Loops through each character to check if it starts with a letter.
        for (char c : wordChar) {
            //If it does, the function returns true, otherwise, it returns false.
            if (Character.isLetter(c)) {
                return true;
            }
        }
        // Returns false if the word does not start with a letter
        return false;
    }
}

