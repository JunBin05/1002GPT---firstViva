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
            System.out.print("Enter the compressed string (1-50 characters): ");
            String compressed = sc.next().toLowerCase();
            int length=0;
            while (compressed.length()<1 || compressed.length()>100){
                System.out.print("The compressed string can only be 1-50 characters. Please enter again: ");
                compressed = sc.next().toLowerCase();
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
                System.out.println("The decompressed string exceed 200 characters in length.");
            }
        }
    }
}
