import java.util.Scanner;

public class Anagram {
    public void anagram(String s1, String s2)	{
        if(s1.length() == 0)	{
            System.out.println(s2);
        }
        for(int i = 0; i < s1.length(); i++)	{
            System.out.println("i="+i+" s1="+s1.substring(0, i) + s1.substring(i+1, s1.length())+" s2="+s2+s1.charAt(i));
            anagram(s1.substring(0, i) + s1.substring(i+1, s1.length()), s2 + s1.charAt(i));
        }
    }
    public static void main(String[] args)	{
        Anagram a = new Anagram();
        a.anagram((new Scanner(System.in)).next(), "");
    }
}
