public class Plane extends Vehicle {

    private String code;

    public Plane(float cargoCapacity, String code) {
        super(cargoCapacity);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
