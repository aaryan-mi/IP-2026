public class Inheritance {
    public static void main(String[] args) {
        Child obj = new Child(10, 20, 30, 40);

        obj.parentDisplay(); 
        obj.childDisplay();  
        obj.addition();      
    }
}

class Parent {
    int x, y;

    Parent(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Parent constructor called");
    }

    void parentDisplay() {
        System.out.println("Parent values: x=" + x + ", y=" + y);
    }

    void addition() {
        System.out.println("Parent addition: " + (x + y));
    }
}

class Child extends Parent {
    int a, b;

    Child(int x, int y, int a, int b) {
        super(x, y);
        this.a = a;
        this.b = b;
        System.out.println("Child constructor called");
    }

    void childDisplay() {
        System.out.println("Child values: a=" + a + ", b=" + b);
    }

    // overriding parent method
    void addition() {
        System.out.println("Child addition: " + (a + b));
    }
}