import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("\nYou've been kidnapped and forced to choose a car\nThere is no information other than you'll face consequences if you don't choose\nYou have four choices:\n(1 for car 1, 2 for car 2, 3 for car 3, 4 for car 4)\nWhich car will you pick?");
        String car = s.nextLine();
        Race player = new Race(0, 0, 10, 0);
        int carChoice = 0;
        try {
            carChoice = Integer.parseInt(car);

            if (carChoice == 1) {
                System.out.println(player.car1());
            } else if (carChoice == 2) {
                System.out.println(player.car2());
            } else if (carChoice == 3) {
                System.out.println(player.car3());
            } else if (carChoice == 4) {
                System.out.println(player.car4());
            } else {
                System.out.println("That is not a car choice\nBecause you cannot pick between 4 numbers, a car will be given to you now randomly\n");
                System.out.println(player.randomCar());
            }
        } catch (NumberFormatException e) {
            System.out.println("You can't escape it\nSince you don't know what a number is, a car will be given to you now randomly\n");
            System.out.println(player.randomCar());
        }

        car = s.nextLine();

        if (car.equals("y")) {
            System.out.println("The rules will be presented to you after this line\n");
            System.out.println(player.beginGame());
        } else {
            System.out.println("You cannot flee from this event LOL try harder next time\nYour instructions will be presented to you now\n");
            System.out.println(player.beginGame());
        }
            System.out.print("What is the upper and lower limit of the integer numbers you want to be working with?\nUpper: ");

        try {
            int upperLimit = Integer.parseInt(s.nextLine());
            player.getUpper(upperLimit);
            System.out.print("Lower Limit: ");
            int lowerLimit = Integer.parseInt(s.nextLine());
            player.getLower(lowerLimit);
        } catch (NumberFormatException e) {
            System.out.println("You're no fun huh? Your limits will be set to 10 and 0 now.");
        }

        System.out.println("We will begin after the three second countdown");
        player.countdown();


        System.out.print(player.equation());
        int answer = Integer.parseInt(s.nextLine());

        while (!player.finished()) {
            if (player.correct(answer)) {
                System.out.print(player.equation());
                answer = Integer.parseInt(s.nextLine());
                player.youSmart();
            } else {
                System.out.println("try again");
                player.retreat(1);
                answer = Integer.parseInt(s.nextLine());
            }
        }

        System.out.println(player.toString());

    }
}