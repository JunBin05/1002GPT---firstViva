package question3;
import java.util.Scanner;
public class vivaQ3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T;
        int x,y;
        
        T=sc.nextInt(); 
        while(T<1||T>50){ 
            System.out.print("Enter again: ");
            T=sc.nextInt();} 
        
        int[]H=new int[T]; 
        char[]S=new char[T]; 
        
        for (int i=0;i<T;i++){ 
            H[i]=sc.nextInt();
            S[i]=sc.next().charAt(0);
            while ((H[i]<1||H[i]>9)||(S[i]!='P'&&S[i]!='A')){ 
                H[i]=sc.nextInt();
                S[i]=sc.next().charAt(0);
            }}
        
        System.out.println("");
        for (int i=0;i<T;i++){ 
            if (S[i]=='A'){
                for (x=1;x<=H[i];x++){ 
                    for (y=0;y<x;y++){ 
                        System.out.print(x); 
                    }
                    System.out.println("");}
                }
            
            else if (S[i]=='P'){
                for (x=1;x<=H[i];x++){ 
                    for (y=0;y<H[i]-x;y++){ 
                        System.out.print(" ");
                    }
                    for(int s=1;s<x+1;s++){ 
                        System.out.print(s);
                        if (s>=2&&s==x){ 
                            for (int z=s-1;z>0;z--){ 
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
