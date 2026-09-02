public class ArrayDemo {
    public static void main(String args[]) {
        int[] arr = {10, 20, 30, 40, 50};
        int sum = 0;

        System.out.println("Array elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
            sum += arr[i];
        }

        System.out.println("Sum of array elements: " + sum);
    }
}
