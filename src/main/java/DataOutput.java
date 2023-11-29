public class DataOutput {
    public static void showMessage(double personalPrice) {

        String[] rightEndsForRuble = {"ля", "лей", "ль"};

        if ((int) personalPrice % 100 >= 10 && (int) personalPrice % 100 <= 20) {
            System.out.printf("Каждый человек должен заплатить %.2f руб%s",
                    personalPrice, rightEndsForRuble[1]);
        } else {
            switch ((int) personalPrice / 10) {
                case 1 -> System.out.printf("Каждый человек должен заплатить %.2f руб%s",
                        personalPrice, rightEndsForRuble[3]);
                case 2, 3, 4 -> System.out.printf("Каждый человек должен заплатить %.2f руб%s",
                        personalPrice, rightEndsForRuble[0]);
                default -> System.out.printf("Каждый человек должен заплатить %.2f руб%s",
                        personalPrice, rightEndsForRuble[1]);
            }
        }
    }
}
