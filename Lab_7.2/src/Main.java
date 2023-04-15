interface Transport {
    double calculateCost(int distance);
}

class Airplane implements Transport {
    public double calculateCost(int distance) {
        return 0.01 * distance * distance;
    }
}

class Train implements Transport {
    public double calculateCost(int distance) {
        return 0.05 * distance;
    }
}

class ProfitCalculator {
    private int distance;
    private double reward;
    private Transport transport;

    public ProfitCalculator(int distance, double reward, Transport transport) {
        this.distance = distance;
        this.reward = reward;
        this.transport = transport;
    }

    public double calculateProfit() {
        double cost = transport.calculateCost(distance);
        double profit = reward - cost;
        return profit;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example 1: train transport
        ProfitCalculator trainCalculator = new ProfitCalculator(200, 10, new Train());
        double trainProfit = trainCalculator.calculateProfit();
        System.out.println("Profit for train transport: " + trainProfit);

        // Example 2: airplane vs train transport
        ProfitCalculator airplaneCalculator1 = new ProfitCalculator(50, 50, new Airplane());
        double airplaneProfit1 = airplaneCalculator1.calculateProfit();
        ProfitCalculator airplaneCalculator2 = new ProfitCalculator(30, 40, new Airplane());
        double airplaneProfit2 = airplaneCalculator2.calculateProfit();
        ProfitCalculator trainCalculator2 = new ProfitCalculator(350, 45, new Train());
        double trainProfit2 = trainCalculator2.calculateProfit();
        if (airplaneProfit1 > airplaneProfit2 && airplaneProfit1 > trainProfit2) {
            System.out.println("The order with distance 50 and salary 50 will give the greater profit.");
        } else if (airplaneProfit2 > airplaneProfit1 && airplaneProfit2 > trainProfit2) {
            System.out.println("The order with distance 30 and salary 40 will give the greater profit.");
        } else {
            System.out.println("The train transport will give more profits for the order with distance 350 and salary 45.");
        }
    }
}
