public class Ship extends Vehicle {

    private String name;

    public Ship(float cargoCapacity, String name) {
        super(cargoCapacity);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
