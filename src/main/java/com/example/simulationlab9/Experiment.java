package main.java.com.example.simulationlab9;

import java.util.concurrent.ThreadLocalRandom;

public class Experiment {

    private int totalQuantity;
    private final int eventsAmount = 5;
    private final Event[] events;

    {
        events = new Event[eventsAmount];
        double alpha = 1.0;
        for (int i = eventsAmount - 1; i > 0; i--) {
            events[i] = new Event(alpha);
            double probability = ThreadLocalRandom.current().nextDouble(0.0, alpha);
            alpha -= probability;
        }
        events[0] = new Event(alpha);
    }

    public Experiment(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void start() {
        for (int i = 0; i < totalQuantity; i++) {
            double alpha = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
            for (int j = 0; j < eventsAmount; j++) {
                if (alpha < events[j].getProbability()) {
                    events[j].increaseQuantity();
                    break;
                }
            }
        }
    }

    public double[] getFrequencies() {
        double[] frequencies = new double[eventsAmount];
        for (int i = 0; i < eventsAmount; i++) {
            frequencies[i] = (double) events[i].getQuantity() / (double)this.totalQuantity;
        }
        return frequencies;
    }

    public double[] getProbabilities() {
        double[] probabilities = new double[eventsAmount];
        double previous = 0.0;
        for (int i = 0; i < eventsAmount; i++) {
            probabilities[i] = events[i].getProbability() - previous;
            previous = events[i].getProbability();
        }
        return probabilities;
    }

    public int getEventsAmount() {
        return this.eventsAmount;
    }
}
