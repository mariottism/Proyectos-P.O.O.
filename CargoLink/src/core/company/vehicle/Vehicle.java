import java.util.ArrayList;

public abstract class Vehicle {

    protected float cargoCapacity;
    protected ArrayList<Shipping> shippings; // Para relación bidireccional

    public Vehicle(float cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
        this.shippings = new ArrayList<>();
    }

    //  IMPORTANTE: para relación bidireccional
    public void addShipping(Shipping s) {
        shippings.add(s);
    }

    public ArrayList<Shipping> getShippings() {
        return shippings;
    }

    public float getCargoCapacity() {
        return cargoCapacity;
    }
}
