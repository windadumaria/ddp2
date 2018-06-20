public class A {
    int n;

    public A(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }
}

class B extends A{
    String a;

    public B(int n, String a) {
        super(n);
        this.a = a;
    }

    public int getN(){
        return (int) (0.85*n);
    }

    public static void main (String[] args){
        A objA = new B(10,"abc");
        System.out.println(objA.getN());
    }
}
