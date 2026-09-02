public class Polymorphism {
    public static void main(String[] args) {
        PolymorphismDemo obj = new PolymorphismDemo();
        obj.addition(58, 58);
        obj.addition(7f, 4f);
    }
}

class PolymorphismDemo{
    int x;
    int y;
    int sum;

    void addition(int x, int y){
        sum = x + y;
        System.out.println("Sum of two Integer parameters : "+sum);
    }

    public void addition(float f, float g) {
        float sum = f + g;
        System.out.println("Sum of two Float parameters : " + sum);
    }
}

