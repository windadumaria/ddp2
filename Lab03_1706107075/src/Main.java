import java.util.Scanner;

public class Main {

    public static void main (String[] args){
        System.out.println("====Soal 1====");
        Scanner sc = new Scanner(System.in);
        int input1a = sc.nextInt();
        int input1b = sc.nextInt();

        if(input1b%2==0){
            for(int a=1;a<=input1b/2;a++)
            {
                for(int b=1;b<=a;b++)
                    if(b>1) {
                        System.out.print(" ");
                    }
                for(int b=1;b<=input1a;b++)
                    System.out.print("* ");
                System.out.println();
            }
            for(int a=input1b/2;a>=1;a--)
            {
                for(int b=a;b>=1;b--)
                    if(b>1) {
                        System.out.print(" ");
                    }
                for(int b=1;b<=input1a;b++)
                    System.out.print("* ");
                System.out.println();
            }
        }else{
            for(int a=1;a<=(input1b/2)+1;a++)
            {
                for(int b=1;b<=a;b++)
                    if(b>1) {
                        System.out.print(" ");
                    }
                for(int b=1;b<=input1a;b++)
                    System.out.print("* ");
                System.out.println();
            }
            for(int a=(input1b/2);a>=1;a--)
            {
                for(int b=a;b>=1;b--)
                    if(b>1) {
                        System.out.print(" ");
                    }
                for(int b=1;b<=input1a;b++)
                    System.out.print("* ");
                System.out.println();
            }
        }

        System.out.println("====Soal 2====");
        int input2 = sc.nextInt();
        int count = 1;

        //loop from 2 to (1 is not prima)
        for(int i=2; i<=input2;i++){
            boolean isPrima = true;

            //loop for check prima
            for (int j=2; j<i; j++){
                if(i%j==0){
                    isPrima=false;
                    break;
                }
            }

            if(isPrima){
                System.out.println("Bilangan prima ke "+count+" = "+ i);
                count++;
            }
        }

        System.out.println("====Soal 3====");
        int input3 = sc.nextInt();
        int fibnum=0,temp1=0,temp2=0;;

        for(int i=0;i<input3;i++){
            if(i==0){
                fibnum =1;
            }else if(i==1){
                temp1=fibnum;
            }else {
                temp2 = temp1;
                temp1 = fibnum;
                fibnum=fibnum+temp2;
            }
        }
        System.out.println(fibnum);
    }
}
