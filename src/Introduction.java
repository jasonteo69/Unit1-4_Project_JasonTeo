import java.util.concurrent.TimeUnit;

public class Introduction {
    private int answer, lower, upper;
    private int random1, random2;
    private String sign;

    public Introduction(int answer, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        this.answer = answer;
    }

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
        return ("You're given a Tesla (let's go Elon Musk)\nThis small little vehicle has a whopping 700 horsepower\nYou need to help it win the race coming up\nAre you ready? (y for yes // n for no)");
    }

    public String unluckyThen() {
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

    public boolean finished() {
        return answer == 5;
    }

    public void youSmart() {
        answer++;
    }

    public void getUpper(int upperLimit) {
        upper = upperLimit;
    }

    public void getLower(int lowerLimit) {
        lower = lowerLimit;
    }


    public String beginGame() {
        return "You are competing against 3 other cars\nWithin a minute, try to answer all the questions correctly\nIt will be math based questions on simple addition, subtraction, and multiplication\nYou're score will be given to you at the end of the race\nGet a question right, your score increases // Answer incorrectly score goes down\n";
    }

    public int expression() {
        return (int) (Math.random() * 5) + 1;
    }

    public double retreat (int subtracted) {
        return answer - subtracted;
    }

    private String operator() {

        int operator = (int) (Math.random() * 3 + 1);

        if (operator == 1) {
            sign = " - ";
            return " - ";
        } else if (operator == 2) {
            sign = " - ";
            return " + ";
        } else {
            sign = " x ";
            return " x ";
        }

    }

    public String equation() {

        return firstNumber() + operator() + secondNumber();
    }

    private int firstNumber() {
        random1 = (int) (Math.random() * (upper - lower)) + lower;
        return random1;
    }

    private int secondNumber() {
        random2 = (int) (Math.random() * (upper - lower)) + lower;
        return random2;
    }


    public boolean correct(int answer) {
        if (sign.equals(" - ")) {
            return answer == random1 - random2;
        } else if (sign.equals(" x ")) {
            return answer == random1 * random2;
        } else return answer == random1 + random2;
    }

    public String finalStats() {
        return "After a minute, you answered " + answer + "questions correctly";
    }
}
