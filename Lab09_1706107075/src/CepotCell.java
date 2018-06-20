import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CepotCell {

    public static void main (String[] args) {
        try{
            FileReader	reader = new FileReader("/Users/windadumarias/IdeaProjects/Lab09_1706107075/src/input.txt");
            Scanner	in	=	new	Scanner(reader);

            int counter = 0;
            String[] line;
            String date="";
            int totalHoward=0; List<Integer> terjualHoward = new ArrayList<Integer>();
            int totalFriday=0; List<Integer> terjualFriday = new ArrayList<Integer>();
            int totalJarvis=0; List<Integer> terjualJarvis = new ArrayList<Integer>();
            int totalPepper=0; List<Integer> terjualPepper = new ArrayList<Integer>();
            int totalHappy=0; List<Integer> terjualHappy = new ArrayList<Integer>();

            while(in.hasNextLine()){
                if(counter==0){
                    try{
                        line=in.nextLine().split("/");
                        date = Integer.parseInt(line[0])+"/"+Integer.parseInt(line[1])+"/"+Integer.parseInt(line[2]);
                    }catch (NumberFormatException e){ //date format check
                        System.out.println("Terdapat kesalahan penulisan tanggal");
                    }
                }else {
                    try{
                        line=in.nextLine().split(" ");
                        int harga = 0;
                        if(line[0].equalsIgnoreCase("Howard")){
                            harga = getHargaJual(line[1], "Howard");
                            totalHoward += harga;
                            terjualHoward.add(harga);
                        }else if(line[0].equalsIgnoreCase("Jarvis")){
                            harga = getHargaJual(line[1], "Jarvis");
                            totalJarvis += harga;
                            terjualJarvis.add(harga);
                        }else if(line[0].equalsIgnoreCase("Friday")){
                            harga = getHargaJual(line[1], "Friday");
                            totalFriday += harga;
                            terjualFriday.add(harga);
                        }else if(line[0].equalsIgnoreCase("Pepper")){
                            harga = getHargaJual(line[1], "Pepper");
                            totalPepper += harga;
                            terjualPepper.add(harga);
                        }else if(line[0].equalsIgnoreCase("Happy")){
                            harga = getHargaJual(line[1], "Happy");
                            totalHappy += harga;
                            terjualHappy.add(harga);
                        }else{
                            throw new Exception("Data provider tidak terdaftar");
                        }
                    }catch (Exception e){ //provider check
                        System.out.println("Data yang dimasukkan tidak terdaftar");
                    }
                }
                counter++;
            }
            in.close();

            //create output file
            if(totalHoward!=0){
                cetakOutputFile("Howard",date,totalHoward,terjualHoward);
            }if(totalJarvis!=0){
                cetakOutputFile("Jarvis",date,totalJarvis,terjualJarvis);
            }if(totalFriday!=0){
                cetakOutputFile("Friday",date,totalFriday,terjualFriday);
            }if(totalPepper!=0){
                cetakOutputFile("Pepper",date,totalPepper,terjualPepper);
            }if(totalHappy!=0){
                cetakOutputFile("Happy",date,totalHappy,terjualHappy);
            }
        }catch (FileNotFoundException e1){ //file check
            System.out.println("File tidak ditemukan");
        }

    }

    private static void cetakOutputFile(String p, String date, int total, List<Integer> terjual) throws FileNotFoundException {
        PrintWriter	out = new	PrintWriter("/Users/windadumarias/IdeaProjects/Lab09_1706107075/src/"+p+".txt");
        String cetak = date+" Total Penjualan = Rp "+total+",000 (";
        for(int i=0;i<terjual.size();i++){
            if(i<terjual.size()-1) cetak = cetak+terjual.get(i)+"+";
            else cetak = cetak+terjual.get(i);
        }
        out.println(cetak+")");
        out.close();
    }


    private static int getHargaJual(String s, String p) {
        int harga=0;
        try{
            char jenis = s.charAt(0);
            harga = Integer.parseInt(s.substring(1, s.length()));
            //System.out.println(harga);
            if(harga==10 || harga==25 || harga==50 || harga==100){
                if(jenis=='V') harga = harga + getNominalTambahan(p)+1;
                else if (jenis=='E') harga = harga + getNominalTambahan(p);
            }else{
                throw new Exception("Nominal tidak terdaftar");
            }
        }catch (NumberFormatException e1){//price check
            System.out.println("Terdapat kesalahan penulisan nominal");
        } catch (Exception e2){//nominal check
            System.out.println("Data yang dimasukkan tidak terdaftar");
        }
        return harga;
    }

    private static int getNominalTambahan(String p) {
        int a=0;
        if(p.equalsIgnoreCase("Howard") || p.equalsIgnoreCase("Pepper") || p.equalsIgnoreCase("Happy")){
            a = 2;
        }else if(p.equalsIgnoreCase("Jarvis") || p.equalsIgnoreCase("Friday")){
            a = 1;
        }
        return a;
    }
}
