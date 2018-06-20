import java.util.Calendar;

public class Kalender {
    int dayOfWeek;
    int dayOfMonth;
    int Month;
    int Year;
    public Kalender()
    {
        Calendar cal = Calendar.getInstance();
        this.dayOfWeek= cal.get(Calendar.DAY_OF_WEEK);
        this.dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        this.Month = cal.get(Calendar.MONTH);
        this.Year = cal.get(Calendar.YEAR);
    }
    public Kalender(int hari, int bulan, int tahun)
    {
        this.dayOfMonth = hari;
        this.Month = bulan;
        this.Year = tahun;
    }

    public void addHari (Kalender k , int hari){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,hari);
        //System.out.println(cal.getTime());
        k.dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        k.dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        k.Month = cal.get(Calendar.MONTH);
        k.Year = cal.get(Calendar.YEAR);
    }

    public String getNamaHari(int dayOfWeek){
        String[] hari = {"", "Minggu", "Senin", "Selasa","Rabu","Kamis","Jumat","Sabtu"};
        return hari[dayOfWeek];
    }

    public String getNamaBulan(int month){
        String[] bulan = {"Januari", "Februari", "Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember"};
        return bulan[month];
    }

    public String ultahDiTahun (int year){
        Kalender k = new Kalender(31,9,1995);
        Calendar cal = Calendar.getInstance();
        cal.set(year, k.Month, k.dayOfMonth);
        //System.out.println(cal.getTime());
        String hari= getNamaHari(cal.get(Calendar.DAY_OF_WEEK));
        return hari;
    }
}
