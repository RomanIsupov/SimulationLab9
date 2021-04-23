package main.java.com.example.simulationlab9;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Listener {

    public static void main(String[] args) {
        System.out.println("Hello. Please enter the amount of events.");
        Scanner input = new Scanner(System.in);
        int quantity = input.nextInt();
        Experiment experiment = new Experiment(quantity);
        experiment.start();
        Listener.printExperimentsData(experiment);
    }

    private static void printExperimentsData(Experiment experiment) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        double[] probabilities = experiment.getProbabilities();
        double[] frequencies = experiment.getFrequencies();

        System.out.println("Here are theoretical probabilities:");
        for (int i = 0; i < experiment.getEventsAmount(); i++) {
            System.out.print(decimalFormat.format(probabilities[i]) + " ");
        }
        System.out.println();

        System.out.println("Here are empirical frequencies:");
        for (int i = 0; i < experiment.getEventsAmount(); i++) {
            System.out.print(decimalFormat.format(frequencies[i]) + " ");
        }
    }
}
