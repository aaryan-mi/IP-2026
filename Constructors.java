public class Constructors {
    public static void main(String[] args) {
        ConstructorsDemo obj = new ConstructorsDemo(14, 45); // as soon as we create an object constructor gets called
        obj.display(); 
        System.out.println(obj.x);
        System.out.println(obj.y);
    }
}


class ConstructorsDemo{
    int x;
    int y;
    ConstructorsDemo(int y, int x){
        this.x = x;
        this.y = y;
        System.out.println("Inside Default Function");
        
    }

    void display(){
    System.out.println("Inside Display Function");
    }
}