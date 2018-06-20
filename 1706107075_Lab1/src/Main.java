import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        System.out.println("===Soal1===");
        Account agung = new Account();
        Account david = new Account(1000);
        System.out.println("agung balance : " + agung.getBalance());
        System.out.println("david balance : " + david.getBalance());

        agung.setBalance(1000);
        System.out.println("agung balance after set balance : " + agung.getBalance());

        david.deposit(500);
        System.out.println("david balance after deposit 500 : " + david.getBalance());
        agung.withdraw(100);
        System.out.println("agung balance after withdraw 100 : " + agung.getBalance());
        david.withdraw(250);
        System.out.println("david balance after withdraw 250 : " + david.getBalance());
        agung.deposit(500);
        System.out.println("agung balance after deposit 500 : " + agung.getBalance());
        agung.withdraw(1310);

        System.out.println("\n===Soal2===");
        Kalender kal= new Kalender();
        System.out.println("Hari ini : "+kal.dayOfMonth + " " + kal.getNamaBulan(kal.Month) + " " + kal.Year);

        int hari=100;
        kal.addHari(kal,hari);
        System.out.println(hari +" hari ke depan: "+"tanggal "+ kal.dayOfMonth+" dan hari "+ kal.getNamaHari(kal.dayOfWeek));

        hari=10000;
        kal.addHari(kal,hari);
        System.out.println(hari +" hari ke depan: " + kal.dayOfMonth + " " + kal.getNamaBulan(kal.Month) + " " + kal.Year);

        int tahun=2017;
        String hariUltah= kal.ultahDiTahun(tahun);
        System.out.println("Hari ultahku di tahun "+tahun+" adalah "+hariUltah);

        System.out.println("\n===Soal3===");
        Scanner n = new Scanner(System.in);
        String command = n.next();
        String firstName = n.next();
        String lastName = n.next();
        BingBingCorp bingCorp = new BingBingCorp();
        if(command.contains("daftar")){
            bingCorp.daftar(firstName,lastName);
            System.out.println("nama : " + bingCorp.firstName + " " + bingCorp.lastName);
            System.out.println("email : " + bingCorp.email);
        }
    }
}
