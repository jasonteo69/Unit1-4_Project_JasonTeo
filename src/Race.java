import java.util.concurrent.TimeUnit;

public class Race {
    private int score, lower, upper, incorrect;
    private int random1, random2;
    private String sign;

    /**
     * Race represents the numbers used to calculate a problem
     */
    public Race(int answer, int lower, int upper, int incorrect) {
        this.lower = lower;
        this.upper = upper;
        this.score = answer;
        this.incorrect = incorrect;
    }

    /**
     *car1 - car4 represents descriptions of cars
     */
    public String car1() {
        return ("You're given a blue Mclaren\nThis supercar has a devastating 0 horses\nYou need to help it win the race coming up\nAre you ready? (y for yes // n for no)");
    }

    public String car2() {
        return ("You're given a golf cart\nThis small little vehicle has a whopping 700 horsepower\nYou need to help it win the race coming up\nAre you ready? (y for yes // n for no)");
    }

    public String car3() {
        return "You're given a Jeep truck\nThis monster of a machine has a decent 100 horses\nYou need to help it win the race coming up\nAre you ready? (y for yes // n for no)";
    }

    public String car4() {
        return ("You're given a Tesla (let's go Elon Musk)\nThis electric powered vehicle has a whopping 483 horsepower???\nYou need to help it win the race coming up\nAre you ready? (y for yes // n for no)");
    }

    /**
     * randomCar returns a random car description
     */

    public String randomCar() {
        int randomCar = (int) (Math.random() * 4) + 1;
        if (randomCar == 4) {
            return car4();
        } else if (randomCar == 3) {
            return car3();
        } else if (randomCar == 2) {
            return car2();
        } else {
            return car1();
        }
    }

    /**
     * countdown represents a 3-second countdown
     */

    public void countdown() {
        try {
            for (int i = 3; i > 0; i--) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * finished is the condition met when the game is over
     */

    public boolean finished() {
        return score == 9;
    }

    /**
     * youSmart is to be called when answering a question correctly
     */

    public void youSmart() {
        score++;
    }

    /**
     * getUpper gets the upper limits of the user based on their input
     * @param upperLimit changes the private variable upper to upperLimit
     */
    public void getUpper(int upperLimit) {
        upper = upperLimit;
    }

    /**
     * getLower gets the lower limits of the user based on their input
     * @param lowerLimit changes the private variable to lowerLimit
     */

    public void getLower(int lowerLimit) {
        lower = lowerLimit;
    }

    /**
     * String beginGame are more rules to be presented when the user reaches the point before they start the game
     * @return a string of what's going on during the race and some more rules
     */
    public String beginGame() {
        return "You are competing against 3 other cars\nWithin a minute, try to answer all the questions correctly\nIt will be math based questions on simple addition, subtraction, and multiplication\nYou're score will be given to you at the end of the race\nGet a question right, your score increases // Answer incorrectly score goes down\n";
    }

    /**
     * keeps track of number of incorrect answers
     * @param subtracted represents a number based the math problem depending on difficulty of problem
     * @return score - int subtracted
     */

    public double retreat (int subtracted) {
        incorrect++;
        return score - subtracted;
    }

    /**
     * String equation will determine an equation for the user to solve
     * @return a string with 2 numbers and a random operator to be solved
     */

    public String equation() {

        int operator = (int) (Math.random() * 3 + 1);

        if (operator == 1) {
            sign = " - ";
            return "What is " + firstNumber() + sign + secondNumber() + ": ";
        } else if (operator == 2) {
            sign = " - ";
            return "What is " + firstNumber() + sign + secondNumber() + ": ";
        } else {
            sign = " x ";
            return "What is " + firstNumber() + sign + secondNumber() + ": ";
        }

    }

    /**
     * firstNumber and secondNumber represents numbers within the upper and lower limits
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
     * @param answer is an integer representing the answer of the user to the equation provided to them
     * @return if answer matches with the equation given to them
     */

    public boolean correct(int answer) {
        if (sign.equals(" - ")) {
            return answer == random1 - random2;
        } else if (sign.equals(" x ")) {
            return answer == random1 * random2;
        } else return answer == random1 + random2;
    }

    /**
     * toString will determine if you survive or not based on your answers to the questions
     * @return a string where you survive if answered more than half the questions right, if not then a string where you're dead
     */

    public String toString() {
        score++;
        if (incorrect > (score / 2)) {
            return "\nGood job! You reached the end of the race with " + score + " questions correctly answered\nHowever, since you got 5 or more questions wrong, You were killed for not finishing first.\nYour position: 2\nYour status: dead";
        }
        else {
            return "\nGood job! You reached the end of the race with " + score + " questions correctly answered\nYour position: 1\nYour status: high";
        }
    }
}
