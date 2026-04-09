public class Client {
  private int id;
  private String name;
  private String address;
  private String email;
  private ArrayList<Shipping> shippings;

  //Constructor 
  public Client(int id, String name, String address, String email) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.email = email;
    this.shippings = new ArrayList<>();
  }

  // Método makeShipping: crear un Shipping y guardarlo en Cliente
  public void makeShipping(String code, LogisticsCenter originCenter, LogisticsCenter destinationCenter, LocalDate registrationDate, LocalDate deliveryDate, Status status, Vehicle vehicle) {
    // Cuando el cliente hace un envío, se crea un objeto Shipping y se guarda en su lista
    // this: el cliente esta creando el envío
    Shipping shipping = new Shipping(code, this, originCenter, destinationCenter, registrationDate, deliveryDate, status, vehicle);
    this.shippings.add(shipping); 
    vehicle.addShipping(shipping); // Para que el metodo en CargoLink sea completamente correcto SI NO estara vacio en vehicle
  }

  //Getter busca en la lista shippings con un codigo especifico. Sin recorrer toda la lista retorna al encontrar
  public Shipping getShipping(String code) {
    for (Shipping s : this.shippings) {
        if (s.getCode().equals(code)) {
            return s;
        }
    }
    return null; // ó System.out.println("Shipping not found");
}
  //Getters necesarios
public ArrayList<Shipping> getShippings() {
    return shippings;
}

public int getId() {
    return id;
}

public String getName() {
    return name;
}

}
