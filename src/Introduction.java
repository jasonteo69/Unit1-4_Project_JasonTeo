public class Introduction {
    private int point;
    public Introduction (int point) {
        this.point = point;
    }
    public String car1 () {
        return ("You're given a blue Mclaren\nThis supercar has a devastating 0 horses\nYou need to help it win the race coming up\nAre you ready? (y for yes // n for no)");
    }
    public String car2 () {
        return ("You're given a golf cart\nThis small little vehicle has a whopping 700 horsepower\nYou need to help it win the race coming up\nAre you ready? (y for yes // n for no)");
    }
    public String car3() {
        return "You're given a Jeep truck\nThis monster of a machine has a decent 100 horses\nYou need to help it win the race coming up\nAre you ready? (y for yes // n for no)");
    }
    public String car4() {
        return ("You're given a Tesla (let's go Elon Musk)\nThis small little vehicle has a whopping 700 horsepower\nYou need to help it win the race coming up\nAre you ready? (y for yes // n for no)");
    }
    public void unluckyThen() {
        int randomCar = (int) (Math.random() * 4) + 1;
        if (randomCar == 4) {
            car4();
        } else if (randomCar == 3) {
            car3();
        } else if (randomCar == 2) {
            car2();
        } else {
            car1();
        }
    }

    public boolean correct(int answer) {
        return answer == point;
    }
    public void beginGame() {

    }
    public double retreat (int subtracted) {
        return point - subtracted;
    }
}
