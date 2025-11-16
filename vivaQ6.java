import java.util.Scanner;

public class vivaQ6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of logs, T (1-100): ");
        int T=sc.nextInt();
        while ((T<1) || (T>100)){
            System.out.print("T can only be 1 to 100. Please enter again: ");
            T = sc.nextInt();
        }

        for(int i=0;i<T;i++){
            System.out.print("Enter the compressed string (1-50 characters, alphabets in lowercase only): ");
            String compressed = sc.next();
            int length=0;
            while (compressed.length()<1 || compressed.length()>50 || !compressed.matches("[a-z0-9]+")){
                if (compressed.length()<1 || compressed.length()>50){
                    System.out.print("The compressed string can only be 1-50 characters. Please enter again: ");
                }else if (!compressed.matches("[a-z0-9]+")){
                    System.out.print("The alphabets in compressed string can only be lowercase letters. Please enter again: ");
                }
                compressed = sc.next();
            }
            
            boolean inputValid=true;
            if(Character.isDigit(compressed.charAt(0))){
                inputValid=false;
            }

            if(inputValid){
                for(int j=0;j<compressed.length();j++){
                    char currentLetter = compressed.charAt(j);
                    if(Character.isLetter(currentLetter)){
                        length++;
                    }else if(Character.isDigit(currentLetter)){
                        if(currentLetter=='0' || currentLetter=='1'){
                            inputValid=false;
                            break;
                        }else if ((j+1)==compressed.length() || !(Character.isDigit(compressed.charAt(j+1)))){
                            int digitValue = currentLetter-'0';
                            for (int count=0; count<digitValue-1; count++){
                                length++;
                            }
                        }else{
                            inputValid=false;
                            break;
                        }
                    }
                }
            }
            if(inputValid && length<=200){
                System.out.println(length);
            }else if(!inputValid){
                System.out.println("Invalid Log");
            }else if (length>200){
                System.out.println("The decompressed string exceed 200 characters in length. Please try again ...");
                i--;
            }
        }
    }
}
