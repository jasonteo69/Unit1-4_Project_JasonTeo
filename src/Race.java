import java.util.concurrent.TimeUnit;

public class Race {
    private int score, lower, upper, incorrect;
    private int random1, random2;
    private String sign;

    /**
     * Race represents the statistics and game stats
     */
    public Race(int answer, int lower, int upper, int incorrect) {
        this.lower = lower;
        this.upper = upper;
        this.score = answer;
        this.incorrect = incorrect;
    }

    /**
     * pickCar represents the choices of cars the user has
     * @param randomNumber represents a car choice
     * @return a string of car descriptions
     */
    public String pickCar(int randomNumber) {

        if (randomNumber == 1) {
            return "You're given a blue Mclaren\nThis supercar has a devastating 0 horsepower\nYou need to help it win the race coming up\nAre you ready? (y for yes // n for no)";
        } else if (randomNumber == 2) {
            return "You're given a golf cart\nThis small little vehicle has a whopping 700 horsepower\nYou need to help it win the race coming up\nAre you ready? (y for yes // n for no)";
        } else if (randomNumber == 3) {
            return "You're given a Jeep truck\nThis monster of a machine has a decent 100 horsepower\nYou need to help it win the race coming up\nAre you ready? (y for yes // n for no)";
        } else {
            return "You're given a Tesla (let's go Elon Musk)\nThis electric powered vehicle has a whopping 483 horsepower???\nYou need to help it win the race coming up\nAre you ready? (y for yes // n for no)";
        }
    }

    /**
     * randomCar represents car descriptions from car 1 to car 4
     * @return either car 1, car 2, car 3, or car 4's description
     */

    public String randomCar() {
        int randomCar = (int) (Math.random() * 4) + 1;
        if (randomCar == 4) {
            return pickCar(randomCar);
        } else if (randomCar == 3) {
            return pickCar(randomCar);
        } else if (randomCar == 2) {
            return pickCar(randomCar);
        } else {
            return pickCar(randomCar);
        }
    }

    /**
     * countdown represents a 3-second countdown
     */

    public void countdown() {
        try {
            for (int i = 3; i > 0; i--) {
                TimeUnit.SECONDS.sleep(1); //waits one second before running again
                System.out.println(i);
            }
        } catch (InterruptedException e) { //is neccessary because it's thrown whenever a thread is waiting, sleeping, or otherwise occupied and is interrupted
            throw new RuntimeException(e); //allows for the code to be uninterrupted
        }
    }

    /**
     * finished is the condition met when the game is over
     * @return true if score is greater than or equal to ten, false otherwise
     */

    public boolean finished() {
        return score >= 10;
    }

    /**
     * youSmart is called when answering a question correctly
     */

    public void youSmart() {
        score++;
    }

    /**
     * getUpper gets the upper limits of the user based on their input
     *
     * @param upperLimit changes the private variable upper to upperLimit
     */
    public void getUpper(int upperLimit) {
        upper = upperLimit;
    }

    /**
     * getLower gets the lower limits of the user based on their input
     *
     * @param lowerLimit changes the private variable to lowerLimit
     */

    public void getLower(int lowerLimit) {
        lower = lowerLimit;
    }

    /**
     * String beginGame are more rules to be presented when the user reaches the point before they start the game
     *
     * @return a string of what's going on during the race and some more rules
     */
    public String beginGame() {
        return "You are competing against 3 other cars\nAnswer all the questions correctly until you are unable to\nIt will be math based questions on simple addition, subtraction, and multiplication\nYou're score will be given to you at the end of the race\nGet a question right, your score increases // Answer incorrectly score goes down\n";
    }

    /**
     * keeps track of number of incorrect answers
     *
     * @param subtracted represents a number based the math problem depending on difficulty of problem
     * @return score - int subtracted
     */

    public int retreat(int subtracted) {
        incorrect++;
        return score - subtracted;
    }

    /**
     * String equation will determine an equation for the user to solve
     *
     * @return a string with 2 numbers and a random operator between multiplication, division, and addition signs
     */

    public String equation() {

        int operator = (int) (Math.random() * 3 + 1);

        if (operator == 1) {
            sign = " - ";
            return "What is " + firstNumber() + sign + secondNumber() + ": ";
        } else if (operator == 2) {
            sign = " x ";
            return "What is " + firstNumber() + sign + secondNumber() + ": ";
        } else {
            sign = " + ";
            return "What is " + firstNumber() + sign + secondNumber() + ": ";
        }

    }

    /**
     * firstNumber and secondNumber represents numbers within the upper and lower limits
     *
     * @return a random number in the range of limits provided by user
     */

    private int firstNumber() {
        random1 = (int) (Math.random() * (upper - lower)) + lower;
        return random1;
    }

    private int secondNumber() {
        random2 = (int) (Math.random() * (upper - lower)) + lower;
        return random2;
    }

    /**
     * checks if your answer to the question is correct
     *
     * @param answer is an integer representing the answer of the user to the equation provided to them
     * @return if answer matches with the equation given to them
     */

    public boolean correct(int answer) {
        if (sign.equals(" - ")) {
            return answer == random1 - random2;
        } else if (sign.equals(" x ")) {
            return answer == random1 * random2;
        } else {
            return answer == random1 + random2;
        }
    }

    /**
     * toString will determine if you survive or not based on your answers to the questions
     *
     * @return a string where you survive if answered 3 or more of the questions right, if not then a string where you're dead
     */

    public String toString() {
        if (incorrect >= 3) {
            return "\nGood job! You reached the end of the race with " + score + " questions correctly answered\nHowever, since you got 3 or more questions wrong, You were killed for not finishing first.\nYour position: 2nd\nstatus: dead";
        } else {
            return "\nGood job! You reached the end of the race with " + score + " questions correctly answered\nYour position: 1st\nstatus: on top of the world";
        }
    }
}
