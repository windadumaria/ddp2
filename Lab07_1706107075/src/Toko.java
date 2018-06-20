import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Toko {
    private Scanner reader;
    private String nama;
    private Gudang gudang;
    private boolean running;
    ArrayList<Barang> keranjang;

    public Toko(String nama, Gudang gudang) {
        reader = new Scanner(System.in);
        this.nama = nama;
        this.gudang = gudang;
        running = false;
        this.keranjang = new ArrayList<Barang>();
    }
    public void buka() {
        running = true;
        while(running) {
            printMenu();
            int pilihan = Integer.parseInt(reader.nextLine());
            switch(pilihan) {
                case 1: // Cetak daftar barang
                    cetakDaftarBarang();
                    break;
                case 2: // Beli barang
                    cetakDaftarBarang();
                    if(gudang.getSize()<=0) System.out.println("\n"+"Gudang kosong!");
                    else {
                        System.out.print("Beli barang: ");
                        int choice = Integer.parseInt(reader.nextLine()); //nomor barang yang dipilih
                        if(choice>gudang.getSize()) System.out.println("\n"+"Barang tidak ada di dalam gudang!");
                        else {
                            Barang barang = beliBarang(choice);
                            System.out.println("\n"+barang.nama + " berhasil ditambahkan ke dalam keranjang belanja!");
                        }
                    }
                    break;
                case 3: // Hapus barang dari keranjang belanja
                    cetakKeranjangBelanja();
                    if(keranjang.size()<=0) System.out.println("\n"+"Keranjang belanja kosong!");
                    else {
                        System.out.print("Hapus barang: ");
                        int choice = Integer.parseInt(reader.nextLine()); //nomor barang yang dipilih
                        if(choice>keranjang.size()) System.out.println("\n"+"Barang tidak ada di dalam keranjang belanja!");
                        else {
                            Barang barang = hapusBarang(choice);
                            System.out.println("\n"+ barang.nama + " berhasil dihapus dari keranjang belanja!");
                        }
                    }
                    break;
                case 4: // Cetak kwitansi
                    cetakKwitansi();
                    break;
                case 5: // Keluar
                    System.exit(0);
                default:
                    running = false;
                    break;
            }
            System.out.println();
        }
    }
    private void cetakDaftarBarang() {
        //tidak ada barang di gudang
        if(gudang.getSize()<=0) System.out.println("Gudang kosong!");
        //ada barang di gudang
        else{
            System.out.println("\nDaftar Barang");
            for(int i=1;i<=gudang.getSize();i++)
                System.out.println("("+i+") "+gudang.getBarangs().get(i-1).nama+" - "+gudang.getBarangs().get(i-1).hargaBarang);
        }
    }

    private void cetakKeranjangBelanja() {
        System.out.println("\nKeranjang Belanja");
        for(int i=1;i<=keranjang.size();i++){
            System.out.println("("+i+") "+keranjang.get(i-1).nama+"  "+keranjang.get(i-1).hargaBarang);
        }
    }

    private Barang beliBarang(int nomorBarang) {
        Barang barang = gudang.getBarangs().get(nomorBarang-1);
        keranjang.add(barang);
        return barang;
    }


    private Barang hapusBarang(int nomorBarang) {
        Barang barang = keranjang.get(nomorBarang-1);
        keranjang.remove(barang);
        return barang;
    }

    private void cetakKwitansi() {
        System.out.println("\nKuitansi Toko "+nama);
        double total=0;
        for(int i=1;i<=keranjang.size();i++){
            System.out.println("("+i+") "+keranjang.get(i-1).nama+"  "+keranjang.get(i-1).hargaBarang);
            total=total+keranjang.get(i-1).hargaBarang;
        }
        System.out.println("\nTotal Biaya "+total);
    }

    private static void loadBarang(ArrayList<Barang> daftarBarang) throws IOException {
        ArrayList<String> listStringBarang = bacaFileBarang("/Users/windadumarias/IdeaProjects/Lab07_1706107075/src/daftarBarang.txt");
        for(String s:listStringBarang){
            String[] parts = s.split(",");
            String nama = parts[2];
            double harga = Double.parseDouble(parts[3]);
            if(parts[1].equalsIgnoreCase(" PerangkatKeras")){
                harga = 0.9*harga;
                KomponenPerangkat cpu = new KomponenPerangkat(parts[4]);
                KomponenPerangkat memory = new KomponenPerangkat(parts[5]);
                KomponenPerangkat hdd = new KomponenPerangkat(parts[6]);

                PerangkatKeras pk = new PerangkatKeras(nama,harga,cpu,memory,hdd);
                daftarBarang.add(pk);

            }else if(parts[1].equalsIgnoreCase(" PerangkatLunak")){
                harga = 0.85*harga;
                KomponenPerangkat os = new KomponenPerangkat(parts[4]);
                String jenis = parts[5];

                PerangkatLunak pl = new PerangkatLunak(nama,harga,os,jenis);
                daftarBarang.add(pl);
            }else if(parts[1].equalsIgnoreCase(" Aksesoris")){
                harga = 0.95*harga;
                String deskripsi = parts[4];

                Aksesoris a = new Aksesoris(nama,harga,deskripsi);
                daftarBarang.add(a);
            }

        }
    }

    private static ArrayList<String> bacaFileBarang(String fileName) {
        ArrayList<String> lines = new ArrayList<String>();
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                lines.add(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private void printMenu() {
        System.out.println("Toko " + nama);
        System.out.println("Menu");
        System.out.println("(1) Cetak daftar barang");
        System.out.println("(2) Beli barang");
        System.out.println("(3) Hapus barang dari keranjang belanja");
        System.out.println("(4) Cetak kwitansi");
        System.out.println("(5) Keluar");
        System.out.print("Pilihan Anda: ");
    }
    /**
     * Main method untuk menjalankan program.
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // Persiapkan barang-barang yang akan dijual
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        loadBarang(daftarBarang);
        Gudang gudang = new Gudang(daftarBarang);
        // Buka toko
        Toko toko = new Toko("Kom.com", gudang);
        toko.buka();
    }

}
class Barang {
    int id;
    String nama;
    double hargaBarang;
    private static int count=0;

    public Barang(String nama, double hargaBarang) {
        count++;
        this.id=count;
        this.nama = nama;
        this.hargaBarang = hargaBarang;
    }
}

class KomponenPerangkat{
    String komponen;

    public KomponenPerangkat(String komponen) {
        this.komponen = komponen;
    }
}

class PerangkatKeras extends Barang{
    KomponenPerangkat cpu;
    KomponenPerangkat memory;
    KomponenPerangkat hardisk;

    public PerangkatKeras(String nama, double hargaBarang, KomponenPerangkat cpu, KomponenPerangkat memory, KomponenPerangkat hardisk) {
        super(nama,hargaBarang);
        this.cpu = cpu;
        this.memory = memory;
        this.hardisk = hardisk;
    }
}

class PerangkatLunak extends Barang{
    KomponenPerangkat os;
    String jenis;

    public PerangkatLunak(String nama, double hargaBarang,KomponenPerangkat os,String jenis) {
        super(nama, hargaBarang);
        this.os=os;
        this.jenis=jenis;
    }
}

class Aksesoris extends Barang{
    String deskripsi;

    public Aksesoris(String nama, double hargaBarang, String deskripsi) {
        super(nama, hargaBarang);
        this.deskripsi=deskripsi;
    }
}

class Gudang{
    private ArrayList<Barang> daftarBarang;

    public Gudang(ArrayList<Barang> daftarBarang) {
        this.daftarBarang = daftarBarang;
    }

    public int getSize (){
        return daftarBarang.size();
    }

    public ArrayList<Barang> getBarangs() {
        return daftarBarang;
    }
}