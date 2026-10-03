import java.io.*;
import java.util.*;

public class UniqueRandomNumber {

    public static void main(String[] args) throws Exception {

        String fileName = "usedNumbers.txt";

        Set<Integer> usedNumbers = new HashSet<>();

        // Read previously generated numbers
        File file = new File(fileName);

        if (file.exists()) {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextInt()) {
                usedNumbers.add(scanner.nextInt());
            }

            scanner.close();
        }

        // Check if all numbers are already used
        if (usedNumbers.size() == 36) {
            System.out.println("All numbers from 36 to 71 have been used.");
            return;
        }

        Random random = new Random();
        int number;

        // Generate until we get an unused number
        do {
            number = random.nextInt(36) + 36;
        } while (usedNumbers.contains(number));

        // Display the number
        System.out.println("Generated Number: " + number);

        // Save it for the next run
        FileWriter writer = new FileWriter(fileName, true);
        writer.write(number + "\n");
        writer.close();
    }
}