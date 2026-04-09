public class Shipping{
  private String code;
  private Client client;
  private LogisticsCenter originCenter;
  private LogisticsCenter destinationCenter;
  private LocalDate registrationDate;
  private LocalDate deliveryDate;
  private Status status;
  private ArrayList<Package> packages;
  private Vehicle vehicle;

  //Constructor
  public Shipping(String code, Client client, LogisticsCenter originCenter, LogisticsCenter destinationCenter, LocalDate registrationDate, LocalDate deliveryDate, Status status, Vehicle vehicle) {
        
        this.code = code;
        this.client = client;
        this.originCenter = originCenter;
        this.destinationCenter = destinationCenter;
        this.registrationDate = registrationDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
        this.vehicle = vehicle;
        this.packages = new ArrayList<>(); // Inicializar lista en el constructor CRUCIAL
    }
  
//método addPackage
  public void addPackage(float weight, Content content, float value) { 
    Package p = new Package(weight, content, value);
    this.packages.add(p);
  }
//GETTERS
  // Getter para que shipping conozca el peso total del paquete
  public float getTotalWeight() {
    float total = 0;
    for (Package p : packages) {
        total += p.getWeight();
    }
    return total;
}
  
  public int getPackages() {
      return this.packages.size(); 
  }
  
  public float getTotalValue() {
    float total = 0;
    for (Package p : this.packages) {
        total += p.getValue();
    }
    return total;
}

  //Getters necesarios
public Vehicle getVehicle() {
    return vehicle;
}

public ArrayList<Package> getPackages() {
    return packages;
}

public LogisticsCenter getOriginCenter() {
    return originCenter;
}

public LogisticsCenter getDestinationCenter() {
    return destinationCenter;
}

public LocalDate getRegistrationDate() {
    return registrationDate;
}
}

