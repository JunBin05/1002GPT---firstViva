
package viva;

import java.util.Scanner;
public class Viva {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();

        if(q<=500){
                int [][]query=new int [q][3];
                for(int i=0;i<q;i++){
                    for(int j=0;j<3;j++){
                        query[i][j]=sc.nextInt();
                        
                        if(query[i][0]<0 || query[i][0]>50){
                            System.out.println("Invalid input. a must be in the range of 0-50");
                            return;
                        }
                        if(query[i][1]<0 || query[i][1]>50){
                            System.out.println("Invalid input. b must be in the range of 0-50");
                            return;
                        }
                        if(query[i][0]<1 || query[i][0]>15){
                            System.out.println("Invalid input. n must be in the range of 1-15");
                            return;
                        }
                        }
                    }
                
                for(int i=0;i<q;i++){
                    for(int j=0;j<query[i][2];j++){
                        int charm=query[i][0]+query[i][1]* (int) Math.pow(2,j);
                        System.out.print(charm+" ");
                    }
                        System.out.println();
                }
        }
        else{
            System.out.print("Queries must not exceed 500");
        }
        
    }
    
}
