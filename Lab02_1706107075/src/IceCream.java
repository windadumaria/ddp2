public class IceCream {
    private Integer red;
    private Integer green;
    private Integer blue;

    public static IceCream merah = new IceCream(255,0,0);
    public static IceCream hitam = new IceCream(0,0,0);

    public IceCream(Integer red, Integer green, Integer blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public static Integer[] tebakWarna(IceCream a, IceCream b, double posisiFromA){
        Integer distance1= Math.abs(a.red-b.red);
        Integer distance2= Math.abs(a.green-b.green);
        Integer distance3= Math.abs(a.blue-b.blue);
        Integer newRed;
        Integer newGreen;
        Integer newBlue;

        //System.out.println("distance = "+distance1+" "+distance2+" "+distance3);

        if(a.red < (posisiFromA*distance1))
            newRed=a.red + (int)(posisiFromA*distance1);
        else
            newRed=a.red - (int)(posisiFromA*distance1);

        if(a.green < (posisiFromA*distance2))
            newGreen=a.green + (int)(posisiFromA*distance2);
        else
            newGreen=a.green - (int)(posisiFromA*distance2);

        if(a.blue < (posisiFromA*distance3))
            newBlue=a.blue + (int)(posisiFromA*distance3);
        else
            newBlue=a.blue - (int)(posisiFromA*distance3);

        return new Integer[]{newRed,newGreen,newBlue};
    }

    public static void gabungIceCream(IceCream a, IceCream b, double posisiFromA){
        Integer[] warnaBaru = tebakWarna(a,b,posisiFromA);
        IceCream c = new IceCream(warnaBaru[0],warnaBaru[1],warnaBaru[2]);

        Integer newRed = (a.red+b.red+c.red)/3;
        Integer newGreen = (a.green+b.green+c.green)/3;
        Integer newBlue = (a.blue+b.blue+c.blue)/3;

        String rasaBaru="";
        if(newRed > newGreen && newRed > newBlue)
            rasaBaru="Rendang Balado";
        if(newGreen > newRed && newGreen > newBlue)
            rasaBaru="Hijau Daun";
        if(newBlue > newRed && newBlue > newGreen)
            rasaBaru="Biru Laut";

        System.out.println("Ice Cream baru dengan warna RGB("+newRed+","+newGreen+","+newBlue
                +")  dengan rasa "+rasaBaru+", enak sekali!");
    }

    public static void main(String[] args){
        IceCream merahBaru = IceCream.merah;
        IceCream hitamBaru = IceCream.hitam;

        Integer[] warnaBaru=IceCream.tebakWarna(new IceCream(0,250,0),
                new IceCream(255,0,0),0.25);
        System.out.println("RGB("+warnaBaru[0]+","+warnaBaru[1]+","+warnaBaru[2]+")");

        IceCream.gabungIceCream(new IceCream(0,250,0),
                new IceCream(255,0,0),0.25);
    }
}
