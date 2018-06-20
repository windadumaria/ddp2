import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan ukuran spiral yang diinginkan:");
        int n = sc.nextInt();

        int m[][] = new int[n][n];
        int k=1, l=10, c1=0, c2=n-1, r1=0, r2=n-1;

        //loop as number of element matrix
        while(k<=n*n)
        {
            //loop for upper column, left to right
            for(int i=c1;i<=c2;i++)
            {
                m[r1][i]=l%10;
                k++;l++;
            }
            //loop for right row, top to down
            for(int j=r1+1;j<=r2;j++)
            {
                m[j][c2]=l%10;
                k++;l++;
            }
            //loop for bottom column, right to left
            for(int i=c2-1;i>=c1;i--)
            {
                m[r2][i]=l%10;
                k++;l++;
            }
            //loop for left row, down to top
            for(int j=r2-1;j>=r1+1;j--)
            {
                m[j][c1]=l%10;
                k++;l++;
            }

            c1++;
            c2--;
            r1++;
            r2--;
        }

        // Print the circular matrix
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(m[i][j]+ "\t");
            }
            System.out.println();
        }
    }
}
