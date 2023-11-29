import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String goodName;
        int peopleCount;

        System.out.println("Привет!\nНа скольких человек будем делить счёт?" +
                " \n\uD83D\uDC49 введи значение: ");

        while (true) {
            try {
                peopleCount = sc.nextInt();
                if (peopleCount > 1) break;

            } catch (InputMismatchException e) {
                System.out.println("Неверный формат ввода! Введите положительное число больше 1 ");
                sc.nextLine();
            }
            System.out.println("\uD83D\uDE20 Введите положительное число больше 1 ");
        }

        Calculator calculator = new Calculator(peopleCount);

        while (true) {
            System.out.println("Введите название товара: ");
            goodName = sc.next();

            if (goodName.equalsIgnoreCase("завершить")) {
                break;
            }

            while (true) {
                try {
                    System.out.println("Введите стоимость товара в формате XX.YY : ");
                    double newPrice = Double.parseDouble(sc.next());
                    if (newPrice <= 0) {
                        System.out.println("Цена должна быть положительным числом!");
                    } else {
                        calculator.addPrice(newPrice);
                        System.out.printf("Товар %s успешно добавлен\n", goodName);
                        System.out.println("Общая сумма на данный момент: " + calculator.getMoneySum());
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Цена должна быть положительным числом!");
                    sc.nextLine();
                }
            }
            calculator.storage.add(goodName);
            System.out.println("Вы хотите добавить ещё один товар? Если нет, введите - завершить");
        }

        System.out.println("Добавленные товары: ");
        for (String good : calculator.storage) {
            System.out.println(" ** " + good + " ** ");
        }

        DataOutput finalOutput = new DataOutput();
        finalOutput.showMessage(calculator.getPersonalPrice());
    }
}
