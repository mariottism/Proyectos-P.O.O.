public class Truck extends Vehicle {

    private String plate;

    public Truck( float cargoCapacity, String plate) {
        super(cargoCapacity);
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }
}
