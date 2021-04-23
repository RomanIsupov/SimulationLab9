package main.java.com.example.simulationlab9;

public class Experiment {

    private int quantity;
    private final double probability;

    public Experiment(double alpha) {
        this.quantity = 0;
        this.probability = alpha;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public double getProbability() {
        return this.probability;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
