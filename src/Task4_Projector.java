import java.time.LocalDate;
import java.util.*;

public class Task4_Projector {
    public static void main(String[] args) {

//        Створіть клас Проектор. Він має містити інформацію про назву проектора, рік випуску, ціна, виробник.
// Потрібно створити набір проекторів і виконати наступні завдання:
// Вивести всі проектори
// Вивести всі проектори одного виробника
// Вивести всі проектори поточного року
// Вивести всі проектори вище вказаної ціни
// Вивести всі проектори, відсортувати по ціна зростання
// Вивести всі проектори, відсортувати по ціні спадання
// Вивести всі проектори, відсортувати по року випуску по зростанню
// Вивести всі проектори, відсортувати по року випуску по спаданню

        Scanner scanner = new Scanner(System.in);

        List<Projector> projectorList = Arrays.asList(
                new Projector("Projector1", 2022,15000,"Samsung"),
                new Projector("Projector2",2023,20000,"hp"),
                new Projector("Projector3",2019, 11000,"Dell"),
                new Projector("Projector4",2020, 10000,"Compaq"),
                new Projector("Projector5",2021, 25000,"Sony")
        );
        System.out.println("Вивести всі проектори");
        projectorList.forEach(System.out::println);

        System.out.println("Вивести всі проектори одного виробника");
        projectorList.stream().filter(p->p.getManufacturer().equals("Dell")).forEach(System.out::println);

        System.out.println("Вивести всі проектори поточного року");System.out.println();

        int currentYear = LocalDate.now().getYear();
        projectorList.stream().filter(p->p.getYear().equals(currentYear)).forEach(System.out::println);


        System.out.println("Вивести всі проектори вище вказаної ціни");System.out.println();
        System.out.print("Enter Price: ");
        int price = scanner.nextInt();
        projectorList.stream().filter(p->p.getPrice()>=price).forEach(System.out::println);

        System.out.println("Вивести всі проектори, відсортувати по ціні в порядку зростання");System.out.println();

        System.out.println("Всі проектори, відсортовані по ціні в порядку зростання:");
        projectorList.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice))
                .forEach(System.out::println);


        //projectorList.stream().sorted(Comparator.comparingInt(Projector::getPrice).forEach(System.out::println);
        System.out.println();
        System.out.println("Відсортувати по ціні спадання");System.out.println();

        projectorList.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice).reversed())
                .forEach(System.out::println);



        System.out.println("Відсортувати по року випуску по зростанню");System.out.println();

        projectorList.stream()
                .sorted(Comparator.comparingDouble(Projector::getYear)).forEach(System.out::println);
        System.out.println("Відсортувати по року випуску по спаданню");System.out.println();

        projectorList.stream()
                .sorted(Comparator.comparingDouble(Projector::getYear)
                        .reversed())
                .forEach(System.out::println);

    }

    static public class Projector
    {
        private String Name;
        private Integer Year;

        private Integer Price;

        private String Manufacturer;

        public Projector(String name, int year, int price, String manufacturer) {
            this.Name = name;
            this.Year = year;
            this.Price = price;
            this.Manufacturer= manufacturer;
        }

        public String getName()
        {
            return this.Name;
        }

        public Integer getYear()
        {
            return this.Year;
        }

        public Integer getPrice()
        {
            return this.Price;
        }

        public String getManufacturer()
        {
            return this.Manufacturer;
        }

        @Override
        public String toString() {
            return "Projector{" +
                    "Name='" + Name + '\'' +
                    ", Year=" + Year +
                    ", Price=" + Price +
                    ", Manufacturer='" + Manufacturer + '\'' +
                    '}';
        }
    }

}
