import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        SimpleStringCalculator calculator = new SimpleStringCalculator();
        int sum = calculator.add(numbers);
        System.out.println(sum);
    }
}
