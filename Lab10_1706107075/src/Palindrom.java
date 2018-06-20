import myutil.mylist.Node;
import myutil.myqueue.MyQueue;
import myutil.mystack.MyStack;

import java.util.*;

public class Palindrom {
    public static void main(String[ ] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] inputString =  new String[sc.nextInt()];
        sc.nextLine();

        for (int i = 0; i < inputString.length; i++)
        {
            inputString[i]=sc.nextLine().replaceAll("[^a-zA-Z]","");
        }

        for (int i = 0; i < inputString.length; i++)
        {
            if (isPalindrome(inputString[i]))
                System.out.println("KODE#"+(i+1)+"#KODE RAHASIA");
            else
                System.out.println("KODE#"+(i+1)+"#BUKAN KODE RAHASIA");
        }
    }

    private static boolean isPalindrome(String input) {
        MyQueue q = new MyQueue();
        MyStack s = new MyStack();
        String letter;

        //insert char to queue & stack
        for (int i = 0; i < input.length(); i++)
        {
            letter = String.valueOf(input.toLowerCase().charAt(i));
            q.add(letter);
            s.push(letter);
        }

        while (!q.isEmpty())
        {
            if (!q.remove().equals(s.pop()))
                return false;
        }
        return true;
    }



}
