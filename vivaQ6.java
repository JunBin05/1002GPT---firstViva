import java.util.Scanner;

public class vivaQ6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of logs, T (1-100): "); 
        int T=sc.nextInt();
        while ((T<1) || (T>100)){  //limit number of logs 1-100 only, if no then need to input again
            System.out.print("T can only be 1 to 100. Please enter again: ");
            T = sc.nextInt();
        }

        for(int i=0;i<T;i++){
            System.out.print("Enter the compressed string (1-50 characters, alphabets in lowercase only): ");
            String compressed = sc.next();
            int length=0;
            while (compressed.length()<1 || compressed.length()>50 || !compressed.matches("[a-z0-9]+")){ //check if string has length of 1-50, and is there only lowercase alphabet and number (uppercase not accepted)
                if (compressed.length()<1 || compressed.length()>50){ //if string length not 1-50
                    System.out.print("The compressed string can only be 1-50 characters. Please enter again: ");
                }else if (!compressed.matches("[a-z0-9]+")){  //if string contains characters other than lowercase alphabet and number (for example: uppercase letter)
                    System.out.print("The alphabets in compressed string can only be lowercase letters. Please enter again: ");
                }
                compressed = sc.next(); //input again
            }
            
            boolean inputValid=true; //used to check later whether input is valid or not, if not valid will print "Invalid Log"
            if(Character.isDigit(compressed.charAt(0))){ //check if first character is a digit
                inputValid=false; //if first character is a digit then is not valid
            }

            if(inputValid){ //if first character is already a digit, then no need to run this section d, as inputValid if false already
                for(int j=0;j<compressed.length();j++){
                    char currentLetter = compressed.charAt(j); 
                    if(Character.isLetter(currentLetter)){ //if current character is a letter (alphabet)
                        length++;
                    }else if(Character.isDigit(currentLetter)){ //if current character is a digit 
                        if(currentLetter=='0' || currentLetter=='1'){ //check if it is 0 or 1, if yes then invalid
                            inputValid=false;
                            break;
                        }else if ((j+1)==compressed.length() || !(Character.isDigit(compressed.charAt(j+1)))){ //check if next character is digit or not, since cannot have 2 continuous digit. But if let say current character is already the last character, then no need to check d as we don't have next character anymore
                            int digitValue = currentLetter-'0'; //to convert a char to integer using ASCII value trick
                            for (int count=0; count<digitValue-1; count++){ //print a same character for repeated times based on the digitValue-1
                                length++;
                            }
                        }else{
                            inputValid=false; //if next character is a digit then invalid, as there cannot be 2 continuous digit
                            break;
                        }
                    }
                }
            }
            if(inputValid && length<=200){ //everything okay, valid input
                System.out.println(length);
            }else if(!inputValid){ //invalid input
                System.out.println("Invalid Log");
            }else if (length>200){ //the decompressed string has a length more than 200, so need to take input again
                System.out.println("The decompressed string exceed 200 characters in length. Please try again ...");
                i--; //you can understand it like, we don't count this loop as one time because we need to take the input again, so i-- means this loop doesn't count
            }
        }
    }
}
