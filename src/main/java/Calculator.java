import java.util.ArrayList;
import java.util.List;

class Calculator {
    List<String> storage = new ArrayList<>();
    private int peopleCount;
    private double moneySum;

    public Calculator(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public void addPrice(double singlePrice) {
        moneySum += singlePrice;
    }


    public double getPersonalPrice() {
        return moneySum / peopleCount;
    }

    public double getMoneySum() {
        return moneySum;
    }
}