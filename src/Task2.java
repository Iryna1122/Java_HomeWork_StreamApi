import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
//        Для набору назви продуктів (продукти можуть повторюватися) потрібно:
// Показати всі продукти
// Показати всі продукти з назвою менше п’яти символів
// Порахувати скільки разів зустрічається продукт, назву якого ввів користувач
// Показати всі продукти, що починаються на задану букву
// Показати всі продукти із категорії «Молоко»

        Scanner scanner = new Scanner(System.in);
        List<Product> productList = Arrays.asList(
                new Product("Apple", "Fruit"),
                new Product("Pear","Fruit"),
                new Product("Bread","Bread"),
                new Product("Milk","Milk"),
                new Product("Cucumber", "Vegetables" ),
                new Product("Pear","Fruit"),
                new Product("Cheese", "Milk")
        );

        System.out.println("All products:");
        productList.forEach(s-> System.out.println(s));

        System.out.println("All products:");
        productList.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------");

        System.out.println("Products with name length less than 5 characters:");
        productList.stream().filter(prod ->prod.getName().length()<5).forEach(System.out::println);

        System.out.println("Category Milk:");
        productList.stream().filter(prod-> prod.getCategory()=="Milk").forEach(System.out::println);

        System.out.print("Enter word:");
        String wordInput = scanner.next();

        long countOfWords = productList.stream().filter(prod->prod.getName().equals(wordInput)).count();
        System.out.println("Count: " + countOfWords);


        System.out.print("Enter Letter: ");
        String userLetter = scanner.next();
        System.out.println("\nProducts that start with the letter '" + userLetter + "':");

        productList.stream().filter(prod->prod.getName().startsWith(String.valueOf(userLetter))).forEach(System.out::println);

        System.out.println("All Products from Milk Category:");

        productList.stream().filter(prod->prod.getCategory().equals("Milk")).forEach(System.out::println);

    }

    static public class Product
    {
        private String  fruit;
        private String category;

        public Product(String fruit,String category)
        {
            this.fruit = fruit;
            this.category = category;
        }

        public String getName()
        {
            return this.fruit;

        }

        public String getCategory()
        {
            return this.category;
        }
        @Override
        public String toString() {
            return "Product{" +
                    "fruit='" + fruit + '\'' +
                    ", category='" + category + '\'' +
                    '}';
        }
    }
}
