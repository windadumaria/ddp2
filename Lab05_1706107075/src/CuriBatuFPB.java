import java.util.Scanner;

public class CuriBatuFPB {
    int player1Num;
    int player2Num;
    int jumlahBatu;
    int winner;

    public CuriBatuFPB(int player1Num, int player2Num, int jumlahBatu) {
        this.player1Num = player1Num;
        this.player2Num = player2Num;
        this.jumlahBatu = jumlahBatu;
    }

    public int fpb(int a, int b){
        if(b==0)return a;
        else return fpb(b,a%b);
    }

    public void curiBatu(boolean player1, boolean player2, int jumlahBatu){
        if(jumlahBatu <= 0){
            if(player1==true)
                this.winner=1;
            else if(player2==true)
                this.winner=0;
        }else{
            if(player1==true && player2==false){
                int fpb=fpb(this.player1Num,jumlahBatu);
                jumlahBatu=jumlahBatu-fpb;
                //System.out.println("player1"+" fpb="+fpb+" batu="+jumlahBatu);
                curiBatu(false,true,jumlahBatu);
            }else if(player1==false && player2==true){
                int fpb=fpb(this.player2Num,jumlahBatu);
                jumlahBatu=jumlahBatu-fpb;
                //System.out.println("player2"+" fpb="+fpb+" batu="+jumlahBatu);
                curiBatu(true,false,jumlahBatu);
            }
        }
    }

    public static void main(String[] args)	{
        Scanner sc = new Scanner(System.in);
        int agungNum = sc.nextInt();
        int davidNum = sc.nextInt();
        int jumlahBatu = sc.nextInt();

        CuriBatuFPB c = new CuriBatuFPB(agungNum,davidNum,jumlahBatu);
        c.curiBatu(true,false,c.jumlahBatu);
        System.out.println(c.winner);
    }
}
