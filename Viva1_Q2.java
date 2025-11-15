package viva1_q2;
import java.util.Scanner;
public class Viva1_Q2{
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input;
        input = new Scanner(System.in);
        
        // Ask the user for the number of queries
        System.out.print("Enter the number of queries: ");
        int T = input.nextInt(); // number of queries
        
         // Validate range of number of queries,T (must be in the range 1 to 200)
        if (T < 1 || T > 200) {
            System.out.println("Invalid number of queries.");
            return;//Stop the program if T is invalid
        }

         // Loop through each test case
        for (int t = 0; t < T; t++) {
            System.out.print("Test case "+ (t+1) + ": ");
             // Read the number to analyse, N and Lucky Digit, L for the current test case
            long N = input.nextLong();
            int L = input.nextInt();
            
            // Validate input ranges
            boolean invalidN = (N < 0 || N > 2000000000);
            boolean invalidL = (L < 0 || L > 9);

            // Print combined error messages if both N and L are invalid
            if (invalidN && invalidL) {
                System.out.println("Invalid N value and Lucky Digit");
                continue; //skip to the next test case
            } 
            
            // Print error if only N is invalid
            else if (invalidN) {
                System.out.println("Invalid N value");
                continue; //skip to the next test case
            } 
            
            // Print error if only L is invalid
            else if (invalidL) {
                System.out.println("Invalid Lucky Digit");
                continue; //skip to the next test case
            }

            // Initialise counters for each category
            int lucky = 0; // Count of digits equal to Lucky Digit
            int zero = 0;  // Count of digits equal to 0 (only if L != 0)
            int even = 0;  // Count of other even digits (2,4,6,8)
            int odd = 0;   // Count of remaining odd digits (1,3,5,7,9)

            // Special case: if N = 0
            if (N == 0) {
                if (L == 0)
                    lucky++; // If Lucky Digit is 0, count it as Lucky
                else zero++; // Otherwise count as Zero
            } else {
                // Process each digit of N
                while (N > 0) {
                    int digit = (int)(N % 10); // Extract last digit
                    N /= 10; // Remove last digit from N

                    // Priority 1: Lucky Digit
                    if (digit == L) {
                        lucky++;
                    }
                    // Priority 2: Zero (only if L != 0)
                    else if (digit == 0 && L != 0) {
                        zero++;
                    }
                    // Priority 3: Even digits
                    else if (digit % 2 == 0) {
                        even++;
                    }
                    // Priority 4: Odd digits
                    else {
                        odd++;
                    }
                }
            }

            // Determine the digital signature based on highest count
            String result;

            if (lucky > zero && lucky > even && lucky > odd) {
                result = "LUCKY";  // Lucky digit count is strictly highest
            } else if (even > lucky && even > zero && even > odd) {
                result = "BALANCED"; // Even digit count is strictly highest
            } else if (odd > lucky && odd > zero && odd > even) {
                result = "ENERGETIC"; // Odd digit count is strictly highest
            } else {
                result = "NEUTRAL"; // Tie or zero count is highest
            }
            // Print the result for the current test case
            System.out.println(result);
        }
        // Close the Scanner to prevent resource leak
        input.close();
    }
}


