public class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
    }
    public void move(int randomValue){
        if(randomValue >= 4){
            position++;
        }
    }
}
