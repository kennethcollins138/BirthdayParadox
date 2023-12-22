package edu.usd;
import java.util.Random;

class Birthday {
    private int month;
    private int day;
    private static final Random random = new Random(); // one instance shared across all instances

    // Constructor for generating a random bday
    public Birthday() {
        this.month = random.nextInt(12) + 1;
        switch(this.month){
            case 1,3,5,7,8,10,12:
                this.day = random.nextInt(31) + 1;
                break;
            case 2:
                this.day = random.nextInt(28) + 1;
                break;
            case 4,6,9,11:
                this.day = random.nextInt(30) + 1;
                break;
        }
    }
    // simple get methods
    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    // Override java's innate hash functions
    @Override
    // this hashcode makes it impossible to store the same value in the same spot
    public int hashCode() {
        return (month * 100) + day;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // reference check
            return true;
        }
        if (obj == null ) { // null pointer check
            return false;
        }
        Birthday other = (Birthday) obj;
        return month == other.month && day == other.day; // if month and day are equal to object in place, returns true
    }
}