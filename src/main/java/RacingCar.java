public class RacingCar {
    private static final int MIN_MOVE_NUMBER = 4;
    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public boolean canMove(int number) {
        return number >= MIN_MOVE_NUMBER;
    }

    public void moveForward(int randomNumber) {
        if (canMove(randomNumber)) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }
}
