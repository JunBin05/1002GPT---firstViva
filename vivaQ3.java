import java.util.Scanner;
public class vivaQ3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T; 
        int x,y; 
        
        T=sc.nextInt(); 
        while(T<1||T>50){ //loop until query is between 1-50
            System.out.print("Enter again: ");
            T=sc.nextInt();} 
        
        int[]H=new int[T];  //store height or number of rows
        char[]S=new char[T]; //store pattern
        
        for (int i=0;i<T;i++){ 
            H[i]=sc.nextInt();
            S[i]=sc.next().charAt(0);
            while ((H[i]<1||H[i]>9)||(S[i]!='P'&&S[i]!='A')){ //loop until height is between 1-50 and pattern is either 'P' or 'A'
                H[i]=sc.nextInt();
                S[i]=sc.next().charAt(0);
            }}
        
        System.out.println("");
        for (int i=0;i<T;i++){ //loop through the queries
            if (S[i]=='A'){ 
                for (x=1;x<=H[i];x++){  //loop from row 1 to assigned row
                    for (y=0;y<x;y++){ //loop until the times printed is equal to the number of x
                        System.out.print(x); //print the number of x 
                    }
                    System.out.println("");}
                }
            
            else if (S[i]=='P'){
                for (x=1;x<=H[i];x++){ //loop from row 1 to assigned row 
                    for (y=0;y<H[i]-x;y++){ //loop  for 0 to H[i]-x times for the staircase pattern from spaces
                        System.out.print(" ");
                    }
                    for(int s=1;s<x+1;s++){ //loop and print 1 to the number of the row number 
                        System.out.print(s);
                        if (s>=2&&s==x){ //stops when the row number is printed 
                            for (int z=s-1;z>0;z--){ //loop and print the row number -1 to 1 in decreasing order
                                System.out.print(z);
                            }
                        }
                    }
                    System.out.println(""); 
                }
            }
        }  
    }
}
