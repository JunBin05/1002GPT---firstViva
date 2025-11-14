import java.util.*;

public class vivaQ4 {

    //a function to compare two strings alphabetically, function got 3 input (2 strings, and 1 Boolean value where false is to look for smaller, true is to look for bigger)
    public static String AlphabeticallyCompare (String a, String b, Boolean bigger){
        int n = a.length();
        int valueOfA=0, valueOfB=0; //used to store ASCII value of alphabet in A and B later
        String big="",small=""; //used to stored String with alphabetically bigger and smaller
        for (int i=0; i<n; i++){
            valueOfA=a.charAt(i); //charAt will return char datatype which bring ASCII value itself
            valueOfB=b.charAt(i);
            if (valueOfA>valueOfB){
                big=a;
                small=b;
            }else if (valueOfA<valueOfB){
                small=a;
                big=b;
            }else if (valueOfA==valueOfB){
                continue; //next loop without running any other codes after this although they're in the same loop
            }
            
            if (bigger==true){
                return big;
            }else{
                return small;
            }
        }
        //There is one special case where two substrings are alphabetically same order
        return a; //can return a or b, as they are same
    }

    //function to find core value by comparing sum of ASCII value from each alphabet in a substring
    public static String CompareCoreValue(String a, String b){
        int n=a.length();
        int sumA=0, sumB=0;
        for (int i=0; i<n; i++){
            sumA+=a.charAt(i); //charAt will return char datatype which bring ASCII value itself
            sumB+=b.charAt(i);
        }
        if (sumA>=sumB){ //if same value, we will just choose either A or B, but here we choose A as it come first, but either should be okay as question didn't mention much
            return a;
        }else{
            return b;
        }
    }

    public static void main(String[] args) {
        //take input from user
        Scanner input = new Scanner (System.in);
        System.out.print("Enter a single word (string of letters) with no spaces: ");
        String word = input.nextLine().toLowerCase();
        System.out.print("Enter a single positive integer representing the length (k) of the substrings: ");
        int k = input.nextInt();

        //declare variable
        int wordLen = word.length();
        String a="",firstWhisper = "z".repeat(k), lastEcho = "a".repeat(k), coreValue = "a".repeat(k); //z because alphabetically biggest, a because alphabetically smallest, use .repeat() because we need the initalized value having same length as k, so there will be no error when we pass to the function

        //Special case where length of word entered is as same as the length of substring required
        if (wordLen==k){
            firstWhisper=lastEcho=coreValue=word;
        }else{ //Normal cases: make substring and look for First Whisper
            for (int i=0; (i+k-1)<=wordLen-1; i++){
                a=word.substring(i,i+k); //stopIndex of substring() is excluded, example when i=0, k=3: it will become substring (0,3) which is substring from index 0 to 2
                firstWhisper=AlphabeticallyCompare(firstWhisper,a,false); //false here because we want to find alphabetically smaller substring
                lastEcho=AlphabeticallyCompare(lastEcho,a,true); //true here because we want to find alphabetically bigger substring
                coreValue=CompareCoreValue(coreValue,a);
            }
        }

        //print result
        System.out.printf("First Whisper: %s%n",firstWhisper);
        System.out.printf("Last Echo: %s%n",lastEcho);
        System.out.printf("Core Value: %s%n",coreValue);
    }
}
