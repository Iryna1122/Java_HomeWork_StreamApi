import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

//        Створіть клас Пристрій. Він повинен зберігати інформацію про назву пристрою, рік випуску, ціна, колір,
//                тип пристрою. Потрібно створити набір пристроїв і виконати наступні завдання:
// Вивести всі пристрої
// Вивести всі пристрої заданого кольору
// Вивести всі пристрої заданого року випуску
// Вивести всі прилади дорожче вказаної ціни
// Вивести всі прилади заданого типу
// Вивести всі прилади, чий рік випуску входить в заданий діапазон

        Scanner scanner = new Scanner(System.in);

        List<Device> deviceList = Arrays.asList(
                new Device("Nokia3310", 2017,10000,"Red","Phone" ),
                new Device("Lenovo",2021,10000, "Black", "Laptop"),
                new Device("Dell",2022,5000,"Blue","Monitor")
        );

        System.out.println("All Device:");
        deviceList.forEach(System.out::println);

        System.out.println("Device Red Color:");
        deviceList.stream().filter(dev->dev.getColor().equals("Red")).forEach(System.out::println);

        System.out.println("Device 2021 year:");
        deviceList.stream().filter(dev->dev.getYear().equals(2021)).forEach(System.out::println);

        System.out.println("Device laptop:");
        deviceList.stream().filter(dev->dev.getType().equals("Laptop")).forEach(System.out::println);

        System.out.println("Device from 2021 to 2022 years:");
        deviceList.stream().filter(dev->dev.getYear()>=2021&&dev.getYear()<=2022).forEach(System.out::println);

    }

    static private class Device
    {
        private String Name;
        private Integer Year;

        private Integer Price;

        private String Color;

        private String Type;


        public Device(String name,Integer year, Integer price, String color,String type)
        {
            this.Name = name;
            this.Year = year;
            this.Price = price;
            this.Color = color;
            this.Type = type;
        }

        @Override
        public String toString() {
            return "Device{" +
                    "Name='" + Name + '\'' +
                    ", Year=" + Year +
                    ", Price=" + Price +
                    ", Color='" + Color + '\'' +
                    ", Type='" + Type + '\'' +
                    '}';
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

        public String getColor()
        {
            return this.Color;
        }

        public String getType()
        {
            return this.Type;
        }

    }



}
