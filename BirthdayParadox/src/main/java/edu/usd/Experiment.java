package edu.usd;
import java.util.HashSet;

public class Experiment {
    private int numberOfPeople;
    private int numberOfTrials;

    public Experiment(int numberOfPeople, int numberOfTrials) {
        this.numberOfPeople = numberOfPeople;
        this.numberOfTrials = numberOfTrials;
    }
    // runs the trials per total people
    public double run() {
        int totalTrialsWithCollisions = 0;
        
        // takes total number of trials per people and runs the trials x amount of times return its value. It will increment if returned true.
        for (int i = 0; i < numberOfTrials; i++) {
            boolean hasCollision = runSingleTrial();
            if (hasCollision) {
                totalTrialsWithCollisions++;
            }
        }
            double percentage = (double) totalTrialsWithCollisions / numberOfTrials * 100.0;
            return Math.round(percentage * 1000) / 1000;   
    }
    private boolean runSingleTrial() {
        HashSet<Birthday> birthdaySet = new HashSet<>();

        for (int i = 0; i < numberOfPeople; i++) {
            Birthday birthday = new Birthday();
            // a lot of behind the scenes utilizing the overrides for equals and hashkey
            if (!birthdaySet.add(birthday)) {
                return true; // Collision occurred in this trial
            }
        }
        return false; // No collision occurred in this trial
    }
}
