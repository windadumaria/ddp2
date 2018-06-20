public class Main2 {
    public static void main(String[] args) {
        AreaKosKosan sendowo = new AreaKosKosan();
        // MODIFIKASI DARI SINI
        // Pada area ini, silakan buat minimal 3 Kosan baru untuk area sendowo
        AreaKosKosan.Kosan kosanA = sendowo.new Kosan();
        AreaKosKosan.Kosan kosanB = sendowo.new Kosan();
        AreaKosKosan.Kosan kosanC = sendowo.new Kosan();
        // BATAS AKHIR MODIFIKASI

        // MODIFIKASI DARI SINI
        // Pada area ini, silakan buat minimal 3 kamar baru untuk minimal satu kosan yang telah kalian buat diatas
        AreaKosKosan.Kosan.Kamar kamar1 = kosanA.new Kamar(3,3,700000);
        AreaKosKosan.Kosan.Kamar kamar2 = kosanA.new Kamar(3,4,950000);
        AreaKosKosan.Kosan.Kamar kamar3 = kosanB.new Kamar(5,3,1100000);
        // BATAS AKHIR MODIFIKASI

        // MODIFIKASI DARI SINI
        // Pada area ini, silakan uji coba semua method Class AplikasiPencariKos
        System.out.println("Jumlah Kosan sendowo : "+ AreaKosKosan.AplikasiPencariKos.getJumlahKosan(sendowo));
        System.out.println("Jumlah Kamar kosanC : "+ AreaKosKosan.AplikasiPencariKos.getJumlahKamar(kosanC));
        System.out.println("Panjang Kamar kamar1 : "+ AreaKosKosan.AplikasiPencariKos.getPanjangKamar(kamar1));
        System.out.println("Lebar Kamar kamar2 : "+ AreaKosKosan.AplikasiPencariKos.getLebarKamar(kamar2));
        System.out.println("Luas Kamar kamar3 : "+ AreaKosKosan.AplikasiPencariKos.getLuasKamar(kamar3));
        System.out.println("Harga Per Bulan kamar3 : "+ AreaKosKosan.AplikasiPencariKos.getHargaPerBulan(kamar1));
        System.out.println("Total Kamar sendowo : "+ AreaKosKosan.AplikasiPencariKos.getTotalKamar(sendowo));
        System.out.println("Kamar terluas : "+ AreaKosKosan.AplikasiPencariKos.getKamarTerluas(sendowo));
        System.out.println("Kamar termurah: "+ AreaKosKosan.AplikasiPencariKos.getKamarTermurah(sendowo));
        // BATAS AKHIR MODIFIKASI
    }
}
