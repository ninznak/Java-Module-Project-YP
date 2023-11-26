import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String goodName;
        int peopleCount = 0;
        String[] rightEndsForRuble = {"ля","лей", "ль"};

        System.out.println("Привет!\nНа скольких человек будем делить счёт?" +
                           " \n\uD83D\uDC49 введи значение: ");

        while (peopleCount<=1){
            peopleCount = sc.nextInt();

            if (peopleCount<=1)
                System.out.println("\uD83D\uDE20 Введите положительное число больше 1 ");
        }

        Calculator calculator = new Calculator(peopleCount);

        while (true){
            System.out.println("Введите название товара: ");

            goodName = sc.next();
            if (goodName.equalsIgnoreCase("завершить")){
                break;
            }
            calculator.storage.add(goodName);

            System.out.println("Введите стоимость товара в формате XX.YY : ");
            double newPrice = Double.parseDouble(sc.next());
            calculator.addPrice(newPrice);

            System.out.printf("Товар %s успешно добавлен\n", goodName);
            System.out.println("Общая сумма на данный момент: " + calculator.getMoneySum());

            System.out.println("Вы хотите добавить ещё один товар? Если нет, введите - завершить");
        }

        System.out.println(calculator.storage);

        System.out.println("Добавленные товары: ");
        for (String good : calculator.storage) {
            System.out.println(" ** " + good + " ** ");
        }

        switch ((int) calculator.getPersonalPrice() / 10) {
            case 1 -> System.out.printf("Каждый человек должен заплатить %.2f руб%s",
                    calculator.getPersonalPrice(), rightEndsForRuble[2]);
            case 2, 3, 4 -> System.out.printf("Каждый человек должен заплатить %.2f руб%s",
                    calculator.getPersonalPrice(), rightEndsForRuble[0]);
            default -> System.out.printf("Каждый человек должен заплатить %.2f руб%s",
                    calculator.getPersonalPrice(), rightEndsForRuble[1]);
        }
    }
}
