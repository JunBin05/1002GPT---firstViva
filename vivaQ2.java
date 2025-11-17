import java.util.Scanner;
public class vivaQ2 {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);

        int T; // T = number of queries

        while (true) { // Loop until a valid number of queries is entered
            System.out.print("Enter the number of queries (1-200): "); // Ask the user for the number of queries
            T = input.nextInt();
            
            // Validate range of number of queries,T (must be in the range 1 to 200)
            if (T >= 1 && T <= 200) {
                break; // Immediately exits the while(true) loop
            }
            
            // If input invalid, print message and loop again
            System.out.println("Invalid input! Please enter one integer in the range 1 to 200.");
        }
        
        System.out.println("Please enter the value of N in range 0 to 2000000000 and value of L in range 0 to 9 ");

        // Use arrays to store inputs, so we can process outputs later
        String[] Ns = new String[T]; // Stores number to be analysed, N as string for each test case 
        String[] Ls = new String[T]; // Stores Lucky Digit, L as string for each test case

        for (int t = 0; t < T; t++) {
            while (true) { // Loop until valid input for this test case
                System.out.print("Test case " + (t + 1) + ": ");

                // Read the string
                String N = input.next();
                String L = input.next();


                // Validate input ranges
                boolean invalidN = (Integer.parseInt(N) < 0 || Integer.parseInt(N) > 2000000000);
                boolean invalidL = (Integer.parseInt(L) < 0 || Integer.parseInt(L) > 9);


                // Print combined error messages if both N and L are invalid
                if (invalidN && invalidL) {
                    System.out.println("Invalid N value and Lucky Digit");
                    continue; // skip to the next test case
                } 
                // Print error if only N is invalid
                else if (invalidN) {
                    System.out.println("Invalid N value");
                    continue; // skip to the next test case
                } 
                // Print error if only L is invalid
                else if (invalidL) {
                    System.out.println("Invalid Lucky Digit");
                    continue; // skip to the next test case
                }

                // Store valid inputs in arrays
                Ns[t] = N;
                Ls[t] = L;
                break; // Exit inner loop for this test case
            }
        }

        for (int t = 0; t < T; t++) {

            String N = Ns[t]; //Get the number to be analysed, N for this test case
            String L = Ls[t];  //Get the Lucky Digit, L for this test case

            // Initialise counters for each category
            int lucky = 0; // Count of digits equal to Lucky Digit
            int zero = 0;  // Count of digits equal to 0 (only if L != 0)
            int even = 0;  // Count of other even digits (2,4,6,8)
            int odd = 0;   // Count of remaining odd digits (1,3,5,7,9)

            // Special case: if N = 0
            if (N.equals("0")) {
                if (L.equals("0"))
                    lucky++; // If Lucky Digit is 0, count it as lucky
                else
                    zero++;  // Otherwise count as zero
            } else {
                for (int i=0;i<N.length();i++) {
                    char digit = N.charAt(i);
                    if (digit == L.charAt(0)) { //change L from String to char
                        lucky++; // Priority 1: Lucky digit
                    } else if (digit == '0' && L.charAt(0) != 0) {
                        zero++;  // Priority 2: Zero (if L != 0)
                    } 
                    else if ((digit-'0') % 2 == 0) {
                        even++;  // Priority 3: Even digits
                    } 
                    else {
                        odd++;   // Priority 4: Odd digits
                    }
                }            
            }

            // Determine the digital signature based on highest count
            String result;
            if (lucky > zero && lucky > even && lucky > odd)
                result = "LUCKY"; // Lucky digit count is strictly highest
            else if (even > lucky && even > zero && even > odd)
                result = "BALANCED"; // Even digits count is strictly highest
            else if (odd > lucky && odd > zero && odd > even)
                result = "ENERGETIC"; // Odd digits count is strictly highest
            else
                result = "NEUTRAL"; // Tie or zero count is highest

            // Print result for this test case
            System.out.println(result);
        }
    }
}
