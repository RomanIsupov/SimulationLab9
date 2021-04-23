package main.java.com.example.simulationlab9;

import java.util.concurrent.ThreadLocalRandom;

public class Simulation {

    private int totalQuantity;
    private final int experimentsAmount = 5;
    private final Experiment[] experiments;

    {
        experiments = new Experiment[experimentsAmount];
        double alpha = 1.0;
        for (int i = experimentsAmount - 1; i > 0; i--) {
            experiments[i] = new Experiment(alpha);
            double probability = ThreadLocalRandom.current().nextDouble(0.0, alpha);
            alpha -= probability;
        }
        experiments[0] = new Experiment(alpha);
    }

    public Simulation(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void simulate() {
        for (int i = 0; i < totalQuantity; i++) {
            double alpha = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
            for (int j = 0; j < experimentsAmount; j++) {
                if (alpha < experiments[j].getProbability()) {
                    experiments[j].increaseQuantity();
                    break;
                }
            }
        }
    }

    public double[] getFrequencies() {
        double[] frequencies = new double[experimentsAmount];
        for (int i = 0; i < experimentsAmount; i++) {
            frequencies[i] = (double)experiments[i].getQuantity() / (double)this.totalQuantity;
        }
        return frequencies;
    }

    public double[] getProbabilities() {
        double[] probabilities = new double[experimentsAmount];
        double previous = 0.0;
        for (int i = 0; i < experimentsAmount; i++) {
            probabilities[i] = experiments[i].getProbability() - previous;
            previous = experiments[i].getProbability();
        }
        return probabilities;
    }

    public int getExperimentsAmount() {
        return this.experimentsAmount;
    }
}
