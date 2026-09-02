public class swaptwo {
    public static void main(String args[]) {
        int a = 5;
        int b = 6;
        int temp;

        System.out.println("Before swap: A = " + a + ", B = " + b);

        temp = a;
        a = b;
        b = temp;

        System.out.println("After swap: A = " + a + ", B = " + b);
    }
}