import java.util.ArrayList;
import java.util.List;

public class SumOfIntegers {
    public static void main(String[] args) {
        // List of numbers as Strings
        String[] numberStrings = {"10", "20", "30", "40", "50"};
        
        // Using autoboxing to convert primitive to Integer objects
        List<Integer> numbers = new ArrayList<>();
        for (String numStr : numberStrings) {
            numbers.add(Integer.parseInt(numStr)); // Parsing string to int, then autoboxing to Integer
        }

        // Calculating sum using unboxing
        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // Unboxing Integer to int
        }

        // Displaying the sum
        System.out.println("Sum of numbers: " + sum);
    }
}
