import java.util.Scanner;
//edrian
public class vivaQ1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of queries (q):");
        int q = sc.nextInt();
        while (q < 1 || q > 500) {
            System.out.println("Invalid input! q must be in the range of 1-500");
            System.out.print("Reenter q:");
            q = sc.nextInt();
        }

        int[][] query = new int[q][3];
        for (int i = 0; i < q; i++) {
            System.out.print("Enter a b n for query " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                query[i][j] = sc.nextInt();
            }
            while (query[i][0] < 0 || query[i][0] > 50) {
                System.out.println("Invalid input! a must be in the range of 0-50");
                System.out.print("Reenter a:");
                query[i][0] = sc.nextInt();
            }
            while (query[i][1] < 0 || query[i][1] > 50) {
                System.out.println("Invalid input! b must be in the range of 0-50");
                System.out.print("Reenter b:");
                query[i][1] = sc.nextInt();
            }
            while (query[i][2] < 1 || query[i][2] > 15) {
                System.out.println("Invalid input! n must be in the range of 1-15");
                System.out.print("Reenter n:");
                query[i][2] = sc.nextInt();
            }
        }
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < query[i][2]; j++) {
                int charm = query[i][0] + query[i][1] * (int) Math.pow(2, j);
                System.out.print(charm + " ");
            }
            System.out.println();
        }

    }
}
