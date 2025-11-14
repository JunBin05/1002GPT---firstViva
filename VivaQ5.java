import java.util.Scanner;

public class vivaQ5 {

    public static boolean isVowel(char c){
        char lower = Character.toLowerCase(c); // Convert the character to lowercase first.
        return(lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u'); // Return the result of the boolean expression.

    }
    public static void main (String [] args){
       
        Scanner sc = new Scanner (System.in); // Create a new Scanner object to read from the standard input

        int T = sc.nextInt();
        String [] word = new String [T]; 
        for(int i = 0 ; i < T ; i++){
            word[i] = sc.next(); 
        }

        for(int i = 0; i < T ; i++){ // Start the main loop. This outer loop processes one word at a time.
            boolean isChaos = false; // Create a boolean "flag" for each word.
            if(isVowel(word[i].charAt(word[i].length()-1))){  // This single check correctly handles 1-letter words like "a".
                isChaos = true; // Create a boolean "flag" for each word.
            }
            
            if(!isChaos){  // if(!isChaos) is the same as "if (isChaos == false)"
                for(int j = 0 ; j < word[i].length() - 1; j++){ // This inner loop checks for consecutive vowels.
                                                                // The loop stops at .length() - 1 to prevent IndexOutOfBoundsException crash,
                    char currentChar = word[i].charAt(j);  // Get the character at the current position (j)
                    char nextChar = word[i].charAt(j+1); // Get the *next* character (j+1)

                    if(isVowel(currentChar) && isVowel(nextChar)){  // Check if *both* are vowels.
                        isChaos = true;
                        break; // 'break' to exit this inner loop. We found our answer.
                    }
                }
            }
 
            if(isChaos){ // if(isChaos) is the same as "if (isChaos == true)"
                word[i] = "Chaos";   // If the flag was ever set to true, replace the word with "Chaos".
            } else {
                word[i] = "Harmony"; // If the flag is still false, replace the word with "Harmony".
            }
        }

        for(int k = 0; k < T ; k++){
            System.out.print(word[k] + " " ); // Print the modified word ("Chaos" or "Harmony") followed by a space.
        }
    }
}
