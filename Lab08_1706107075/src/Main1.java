public class Main1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i+" "+
                    (new Pengeja() {
                        String[] huruf={"","satu","dua","tiga","empat","lima","enam","tujuh","delapan","sembilan","sepuluh","sebelas"};
                        @Override
                        public String eja(Integer angka) {
                            if(angka==0)
                                return "nol";
                            else if(angka>0 && angka<12)
                                return huruf[angka.intValue()];
                            else if(angka>=12 && angka<=19)
                                return huruf[angka.intValue()%10]+" belas ";
                            else if(angka>=20 && angka<=99)
                                return eja(angka/10) + " puluh " + huruf[angka.intValue()%10];
                            else if(angka>=100 && angka<=199)
                                return "seratus " + eja(angka%100);
                            else if(angka>=200 && angka<=999){
                                if(angka%100==0)
                                    return eja(angka/100) + " ratus ";
                                else
                                    return eja(angka/100) + " ratus "+ eja(angka%100);
                            }
                            else if(angka>=1000 && angka<=1999){
                                if(angka%1000==0)
                                    return "seribu";
                                else
                                    return "seribu " + eja(angka%1000);
                            }
                            else if(angka>=2000 && angka<=99999){
                                if(angka%1000==0)
                                    return eja(angka/1000) + " ribu ";
                                else
                                    return eja(angka/1000) + " ribu "+eja(angka%1000);
                            }
                            else
                                return null;
                        }
                    }).eja(i)

            );
        }
    }
}

