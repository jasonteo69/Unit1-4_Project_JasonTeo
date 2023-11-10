import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("\nYou've been kidnapped and forced to choose a car\nThere is no information other than you'll face consequences if you don't choose\nYou have four choices:\n(1 for car 1, 2 for car 2, 3 for car 3, 4 for car 4)\nWhich car will you pick?");
        String car = s.nextLine();
        Race player = new Race(0, 0, 10, 0);
        int carChoice;
        try {
            carChoice = Integer.parseInt(car);
            if (carChoice == 1 || carChoice == 2 || carChoice == 3 || carChoice == 4) {
                System.out.println(player.pickCar(carChoice));
            } else {
                System.out.println("That is not a car choice\nBecause you cannot pick between 4 numbers, a car will be given to you now randomly\n");
                System.out.println(player.randomCar());
            }
        } catch (NumberFormatException e) {
            System.out.println("You can't escape it\nSince you don't know what a number is, a car will be given to you now randomly\n");
            System.out.println(player.randomCar());
        }

        String ready = s.nextLine();

        if (ready.equals("y")) {
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


        try {
            System.out.print(player.equation());
            int answer;

            while (!player.finished()) {
                answer = Integer.parseInt(s.nextLine());
                if (player.correct(answer)) {
                    player.youSmart();
                    System.out.print(player.equation());
                } else {
                    System.out.println("try again");
                    player.retreat(1);
                }
            }

            s.close();
            System.out.println(player.toString());
        }
        catch (NumberFormatException e) {
            s.close();
            System.out.println("\nTHAT IS NOT A NUMBER\nyou have been killed and ripped apart limb by limb, then eaten by your mates.\nstatus: dead");
        }
    }
}