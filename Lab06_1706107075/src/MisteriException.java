import java.util.Scanner;

class ExceptionMu extends Exception{
    public ExceptionMu () { super (); }
    public ExceptionMu (String s) { super (s); }
}
class ExceptionMu1 extends ExceptionMu{
    public ExceptionMu1 () { super (); }
    public ExceptionMu1 (String s) { super (s); }
}
public class MisteriException {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int i;
        try {
            MisteriException me = new MisteriException ();
            i = me.a (s);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println ("tidak ditemukan");
            return;
        }
        catch (NumberFormatException ex) {
            System.out.println ("format bermasalah juga");
            return;
        }
        System.out.println (i);
    }

    public int a (String s) throws NumberFormatException{
        int x = 0;
        try {
            x = b (Integer.parseInt (s));
            return x;
        }
        catch (NumberFormatException ex) {
            System.out.println ("ada masalah format");
        }
        catch (ExceptionMu1 e) {
            System.out.println ("ExceptionMu1: " + e.getMessage ());
        }
        catch (ExceptionMu e) {
            System.out.println ("ExceptionMu: " + e.getMessage ());
        }
        catch (Exception e) {
            System.out.println ("Exception lainnya");
        }
        finally {
            System.out.println ("akhirnya");
        }
        return x;
    }
    public int b (int n) throws ExceptionMu {
        if (n > 100) {
            if (n % 2 == 0) {
                throw new ExceptionMu ("pesan bakmi");
            } else {
                throw new ExceptionMu1 ("pesan ketoprak");
            }
        }
        return n * n;
    }
}