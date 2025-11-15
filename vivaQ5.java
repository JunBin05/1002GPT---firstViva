import java.util.Scanner;

public class vivaQ5 {

    
    public static boolean isVowel(char c){ 
        return(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');  // We check if 'c' is equal to 'a', 'e', 'i', 'o', OR 'u'.
   }
 
    public static void main (String [] args){
       
        Scanner sc = new Scanner (System.in); 

        System.out.print("Enter T lines : ");
        int T = sc.nextInt();
    
        for(int i = 0; i < T ; i++){
            
            System.out.print("word " + (i+1) + ": ");
            String currentWord = sc.next(); 


            boolean isChaos = false; // We'll "assume harmony" (isChaos = false) until we find a rule violation.

            // --- CHECK RULE 1: A vowel cannot be the very last letter. ---
            // We get the last character by using the index 'currentWord.length() - 1'

            if(isVowel(currentWord.charAt(currentWord.length()-1))){  
                isChaos = true;  // If the last character is a vowel, the rule is broken.
            }
            
            // --- CHECK RULE 2: A vowel cannot be immediately followed by another vowel. ---
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