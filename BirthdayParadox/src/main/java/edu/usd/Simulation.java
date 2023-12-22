package edu.usd;

public class Simulation {
    public static void main(String[] args) {
        if (args.length == 2) {
            //takes arguments in terminal if given
            int people = Integer.parseInt(args[0]);
            int experiments = Integer.parseInt(args[1]);
            double probability = runExperiment(people, experiments);
            System.out.println("Number of people\tPercentage");
            System.out.println(people + "\t\t\t" + probability);
        } else if (args.length == 0) {
            System.out.println("Number of people\tPercentage");
            // Loop through the range of people from 5 to 100 at increments of 5 and print the values at each run
            for (int people = 5; people <= 100; people += 5) {
                double probability = runExperiment(people, 20);
                System.out.println(people + "\t\t\t" + probability);
            }
        } else {
            System.out.println("Invalid number of arguments.");
            // won't run if you give 1 or 3+ args
        }
    }

    private static double runExperiment(int people, int trials) {
        // Create an instance of the Experiment class and run the experiment
        Experiment experiment = new Experiment(people, trials);
        return experiment.run();
    }
}
