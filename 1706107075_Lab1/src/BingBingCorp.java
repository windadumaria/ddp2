public class BingBingCorp {
    String firstName;
    String lastName;
    String email;

    public BingBingCorp() {
    }

    public void daftar(String namaAwal, String namaAkhir){
        firstName=namaAwal;
        lastName=namaAkhir;
        System.out.println("Data customer berhasil dimasukkan");
        generateEmail();
    }

    private void generateEmail(){
        email=lastName.toLowerCase()+"."+firstName.toLowerCase()+"@bingbing.com";
    }
}
