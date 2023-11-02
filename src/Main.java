import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Which car do you want to be? (1 for 1, 2 for 2, 3 for 3, 4 for 4)");
        String car = s.nextLine();
        Introduction player = new Introduction(0);
        int carChoice = Integer.parseInt(car);
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
                System.out.println("You can't escape it\nA car will be given to you now randomly\n");
                player.unluckyThen();
            }
        } catch (NumberFormatException e) {
            System.out.println("You can't escape it\nA car will be given to you now randomly\n");
            player.unluckyThen();
        } car = s.nextLine();
        if (car.equals("y")) {
            player.beginGame();
        } else {
            System.out.println("There is no escape\n");
            player.beginGame();
        }

    }
}