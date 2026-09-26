import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double applyDiscount(double discountPercent) {
        return price - (price * discountPercent / 100);
    }
}

public class ECommerceProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Product: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Discount: ");
        double discount = sc.nextDouble();

        Product product = new Product(name, price);
        double finalPrice = product.applyDiscount(discount);

        System.out.println("Product: " + product.getName());
        System.out.println("Original Price: " + product.getPrice());
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: " + finalPrice);
        sc.close();
    }
}
