package main.java.com.example.simulationlab9;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Listener {

    public static void main(String[] args) {
        System.out.println("Hello. Please enter the amount of events.");
        Scanner input = new Scanner(System.in);
        int quantity = input.nextInt();
        Simulation simulation = new Simulation(quantity);
        simulation.simulate();
        Listener.printExperimentsData(simulation);
    }

    private static void printExperimentsData(Simulation simulation) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        double[] probabilities = simulation.getProbabilities();
        double[] frequencies = simulation.getFrequencies();

        System.out.println("Here are theoretical probabilities:");
        for (int i = 0; i < simulation.getExperimentsAmount(); i++) {
            System.out.print(decimalFormat.format(probabilities[i]) + " ");
        }
        System.out.println();

        System.out.println("Here are empirical frequencies:");
        for (int i = 0; i < simulation.getExperimentsAmount(); i++) {
            System.out.print(decimalFormat.format(frequencies[i]) + " ");
        }
    }
}
