import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

//        Для набору випадково згенерованих цілих чисел потрібно:
// Кількість додатних
// Кількість від’ємних
// Кількість двозначних
// Кількість дзеркальних чисел. Наприклад, 121 або 4224
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int len = scanner.nextInt();
        List<Integer> numbers = generateRandomNumbers2(len);

       numbers.forEach(num -> System.out.print(num+" "));

       long positiveCount = numbers.stream()
                .filter(num -> num > 0)
                .count();
       long negativeCount = numbers.stream().filter(num ->num <0).count();

       long twoValuesDigit = numbers.stream().filter(n -> n>=10&&n<=99||n>=-99&&n<=-10).count();

         long polindromCount = numbers.stream().filter(Main::isPalindrome).count();


        System.out.println("\nCount Negative Numbers: "+ negativeCount);
        System.out.println("Count Positive Numbers: " + positiveCount);
        System.out.println("Count two digits: " + twoValuesDigit);
        System.out.println("Polindroms: " + polindromCount);

        System.out.println("Numbers Polindrom: ");

        numbers.stream().filter(Main::isPalindrome).forEach(System.out::println);

    }

    private static List<Integer> generateRandomNumbers2(int size) {
        Random random = new Random();
        return random.ints(size, -100, 100)
                .boxed()
                .collect(Collectors.toList());
    }
    private static List<Integer> generateRandomNumbers(int size) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt());
        }
        return numbers;
    }


    private static boolean isPalindrome(int number) {
        String numStr = String.valueOf(number);
        return numStr.equals(new StringBuilder(numStr).reverse().toString());
    }
}