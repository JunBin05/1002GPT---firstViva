import java.util.Scanner;

public class vivaQ5 {

    
    public static boolean isVowel(char c){ 
        return(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');  // We check if 'c' is equal to 'a', 'e', 'i', 'o', OR 'u'.
    }
 
    public static void main (String [] args){
       
        Scanner sc = new Scanner (System.in); 

        System.out.print("Enter T lines (1-100) : ");
        int T = sc.nextInt();
        while(T < 1 || T > 100){
            System.out.println("Invalid input! T should be between 1 and 100. Please enter again.");
            System.out.print("Enter T lines (1-100) : ");
            T = sc.nextInt();
        }
        System.out.println();
        System.out.println("Rule 1 -- Enter each word only containing lowercase alphabets.");
        System.out.println("Rule 2 -- The length of each word should be between 1 and 50.");
        System.out.println();

        for(int i = 0; i < T ; i++){
            
            System.out.print("word " + (i+1) + ": ");
            String currentWord = sc.next(); 
            while(currentWord.length() < 1 || currentWord.length() > 50 || !currentWord.matches("[a-z]+")){
                System.out.println("Invalid input! Please enter a word with only lowercase alphabets and length between 1 and 50.");
                System.out.print("word " + (i+1) + ": ");
                currentWord = sc.next();
            }
 

            boolean isChaos = false; // We'll "assume harmony" (isChaos = false) until we find a rule violation.

            // check rule 1: A vowel cannot be the very last letter. 
            // We get the last character by using the index 'currentWord.length() - 1'

            if(isVowel(currentWord.charAt(currentWord.length()-1))){  
                isChaos = true;  // If the last character is a vowel, the rule is broken.
            }
            
            // check rule 2: A vowel cannot be immediately followed by another vowel. 
            // We only need to do this check if Rule 1 hasn't already been broken.
            // This is an optimization: if (!isChaos) is the same as (isChaos == false)

            if(!isChaos){  
                for(int j = 0 ; j < currentWord.length() - 1; j++){ 
                    char currentChar = currentWord.charAt(j);  // Get the character at the current position (j)
                    char nextChar = currentWord.charAt(j+1); // Get the *next* character (j+1)

                    if(isVowel(currentChar) && isVowel(nextChar)){   // Check if *both* characters are vowels
                        isChaos = true;
                        break;  // We can stop checking this word. 'break' exits the inner loop.
                    }
                }
            }
 
   
            if(isChaos){ // This is the same as (isChaos == true)
                System.out.println("Chaos");   // If the flag was set to true, a rule was broken.
            } else {
                System.out.println("Harmony"); // If the flag is still false, no rules were broken.
            }
        }
        
    }
}