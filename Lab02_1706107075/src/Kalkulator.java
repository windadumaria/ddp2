public class Kalkulator {
    public static double hitung(int operand1, String operator, int operand2){
        double hasil=0;
        if(operator.equals("+"))
            hasil=operand1+operand2;
        if(operator.equals("-"))
            hasil=operand1-operand2;
        if(operator.equals("*"))
            hasil=operand1*operand2;
        if(operator.equals("/"))
            hasil=operand1/operand2;
        if(operator.equals("^"))
            hasil=Math.pow(operand1,operand2);
        if(operator.equals("V"))
            hasil=Math.pow(operand1,1.0/operand2);
        if(operator.equals("Mod"))
            hasil=operand1%operand2;
        return hasil;
    }

    public static double hitung(String operator, int[] operand){
        double hasil=0;
        if(operator.equals("~")){
            for(int i=0; i<operand.length; i++){
                hasil=hasil+operand[i];
            }
        }
        return hasil/operand.length;
    }

    public static double hitung(String operator, int operand){
        double hasil=0;
        if(operator.equals("log"))
            hasil=Math.log10(operand);
        return hasil;
    }

    public static void main(String[] args){
        System.out.println(Kalkulator.hitung(12,"+",3));
        System.out.println(Kalkulator.hitung(12,"-",3));
        System.out.println(Kalkulator.hitung(12,"*",3));
        System.out.println(Kalkulator.hitung(12,"/",3));
        System.out.println(Kalkulator.hitung(12,"^",3));
        System.out.println(Kalkulator.hitung(36,"V",2));
        System.out.println(Kalkulator.hitung("~",new int[] {1,2,3,4,5}));
        System.out.println(Kalkulator.hitung(12,"Mod",3));
        System.out.println(Kalkulator.hitung("log",100));
    }
}
