public class Encapsulation {
    public static void main(String[] arg) {
        System.out.println("Inside Main Function");
        EncapsulationDemo obj = new EncapsulationDemo(); // allocate memory for object
        obj.display(); // access member methods
        System.out.println(obj.x); // prints x
        System.out.println(obj.y); // prints y
    }
}

class EncapsulationDemo{
    int x;
    int y;
    // both are characteristics, i.e variables are characteristics
    
    void display(){ // behaviour
        System.out.println("Inside Display Function");
    }
}
