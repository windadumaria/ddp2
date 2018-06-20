import java.util.ArrayList;
import java.util.List;

/* Deskripsi: Merupakan sebuah kelas yang merepresentasikan
              suatu area yang berisikan banyak kos-kosan
*/
public class AreaKosKosan {
    private List<Kosan>  daftarKosan = new ArrayList<Kosan>();

    public AreaKosKosan() {
    }

    //Merepresentasikan suatu kosan di dalam sebuah area kos-kosan.
    class Kosan{
        private List<Kamar> daftarKamar = new ArrayList<Kamar>();

        public Kosan() {
            daftarKosan.add(this);
        }

        //Merepresentasikan suatu kamar di dalam sebuah kosan.
         class Kamar{
            private Integer panjangRuangan;
            private Integer lebarRuangan;
            private Integer hargaPerBulan;

            public Kamar(Integer panjangRuangan, Integer lebarRuangan, Integer hargaPerBulan) {
                this.panjangRuangan = panjangRuangan;
                this.lebarRuangan = lebarRuangan;
                this.hargaPerBulan = hargaPerBulan;
                daftarKamar.add(this);
            }

            @Override
            public String toString() {
                return
                        "panjangRuangan=" + panjangRuangan +
                        ", lebarRuangan=" + lebarRuangan +
                        ", hargaPerBulan=" + hargaPerBulan ;
            }
        }
    }

    /*Deskripsi: Merupakan Static​ ​Inner​ ​Class​ dari kelas AreaKosKosan​.
                 Merepresentasikan suatu class yang dapat memberikan informasi dari
                 kelas-kelas AreaKosKosan, Kosan, dan Kamar.*/
    static class AplikasiPencariKos{
        public static Integer getJumlahKosan(AreaKosKosan a){
            return a.daftarKosan.size();
        };
        public static Integer getJumlahKamar(Kosan a){
            return a.daftarKamar.size();
        };
        public static Integer getPanjangKamar(Kosan.Kamar a){
            return a.panjangRuangan;
        };
        public static Integer getLebarKamar(Kosan.Kamar a){
            return a.lebarRuangan;
        };
        public static Integer getLuasKamar(Kosan.Kamar a){
            return a.panjangRuangan * a.lebarRuangan;
        };
        public static Integer getHargaPerBulan(Kosan.Kamar a){
            return a.hargaPerBulan;
        };
        public static Integer getTotalKamar(AreaKosKosan a){
            Integer total = 0;
            for(Kosan ko : a.daftarKosan){
                total += ko.daftarKamar.size();
            }
            return total;
        };
        public static Kosan.Kamar getKamarTerluas(AreaKosKosan a){
            if(AplikasiPencariKos.getTotalKamar(a)==0){
                return null;
            }
            Kosan.Kamar k = a.daftarKosan.get(0).daftarKamar.get(0);
            for(Kosan kosan : a.daftarKosan){
                for(Kosan.Kamar kamar : kosan.daftarKamar){
                    if(AplikasiPencariKos.getLuasKamar(kamar)>AplikasiPencariKos.getLuasKamar(k)){
                        k = kamar;
                    }
                }
            }
            return k;
        };
        public static Kosan.Kamar getKamarTermurah(AreaKosKosan a){
            if(AplikasiPencariKos.getTotalKamar(a)==0){
                return null;
            }
            Kosan.Kamar k = a.daftarKosan.get(0).daftarKamar.get(0);
            for(Kosan kosan : a.daftarKosan){
                for(Kosan.Kamar kamar : kosan.daftarKamar){
                    if(AplikasiPencariKos.getHargaPerBulan(kamar)<AplikasiPencariKos.getHargaPerBulan(k)){
                        k = kamar;
                    }
                }
            }
            return k;
        };
    }



}
