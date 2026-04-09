public class CargoLink {
 private ArrayList<Client> clients;
 private ArrayList<LogisticsCenter> centers;
 private ArrayList<Vehicle> vehicles;

 //Inicializar ArrayLists en Constructor IMPORTANTISIMO
 public CargoLink() {
  this.clients = new ArrayList<>();
  this.centers = new ArrayList<>();
  this.vehicles = new ArrayList<>();
 }

 // Añadir clientes: Main -> link.addClient(new Client(2000501, "John Doe", "123 Main St", "john.doe@example.com"));
 public void addClient(Client client) {
    this.clients.add(client);
 }
 // Add centros: Main ->  link.addLogisticsCenter("Central Hub", "New York", "USA", 40.7128, -74.0060);
 public void addLogisticsCenter(LogisticsCenter center) { 
    this.centers.add(center);
 }

 // Add Vehicles: Main -> link.addVehicle(new Truck(10000.0, "ABC-1234"));
 public void addVehicle(Vehicle vehicle ) { //Polimosfirmo
   this.vehicles.add(vehicle);
  // Vehicle es ABSTRACTA - Error Grave -> Vehicle vehicle = new Vehicle;
 }

 // Para realizar los Shippings: Main -> link.getClient(2000501)
 public Client getClient(int id) {
    for (Client c : this.clients) {
        if (c.getId() == (id)) {
            return c;
        }
    }
    return null; 
 }

 // Metodos
 public void packageSummary() {
    System.out.println("Package summary:");
    // Iteramos sobre cada opción del Enum Content (DOCUMENTS, ELECTRONICS, etc.)
    for (Content categoria : Content.values()) {
        int totalPackages = 0;
        float totalWeight = 0;
        float totalValue = 0;

        for (Client c : clients) {
            for (Shipping s : c.getShippings()) {
                for (Package p : s.getPackages()) {
                    if (p.getContent() == categoria) {
                        totalPackages++;
                        totalWeight += p.getWeight();
                        totalValue += p.getValue();
                    }
                }
            }
        }

        System.out.println("- " + categoria);
        System.out.println("  - Number of packages: " + totalPackages);
        System.out.println("  - Total weight of packages: " + String.format("%.3f", totalWeight) + " kg");
        System.out.println("  - Total value of packages: $" + String.format("%.2f", totalValue));
    }
}

 public void vehicleSummary() {
  System.out.println("Vehicle summary:");
  // Necesitamos acumuladores para cada tipo de vehículo
    // TRUCK
    int truckQty = 0, truckShippings = 0, truckPackages = 0;
    // PLANE
    int planeQty = 0, planeShippings = 0, planePackages = 0;
    // SHIP
    int shipQty = 0, shipShippings = 0, shipPackages = 0;
  for (Vehicle vehicle : this.vehicles) { 
   if (vehicle instanceof Truck) {
       truckQty++;
       truckShippings += vehicle.getShippings().size(); // Cuántos envíos tiene este camión
       for (Shipping s : vehicle.getShippings()) {
            truckPackages += s.getPackages().size(); // Cuántos paquetes hay en esos envíos
       }
   }
   else if (vehicle instanceof Plane) {
            planeQty++;
            planeShippings += vehicle.getShippings().size();
            for (Shipping s : vehicle.getShippings()) {
                planePackages += s.getPackages().size();
            }
        } 
        else if (vehicle instanceof Ship) {
            shipQty++;
            shipShippings += vehicle.getShippings().size();
            for (Shipping s : vehicle.getShippings()) {
                shipPackages += s.getPackages().size();
            }
        }
   }
   imprimirSeccionVehiculo("TRUCK", truckQty, truckShippings, truckPackages);
   imprimirSeccionVehiculo("PLANE", planeQty, planeShippings, planePackages);
   imprimirSeccionVehiculo("SHIP", shipQty, shipShippings, shipPackages);
  }
 //Para limpieza metodo auxiliar para escribir
 private void imprimirSeccionVehiculo(String tipo, int qty, int ships, int packs) {
    System.out.println("- " + tipo);
    System.out.println("  - Quantity: " + qty);
    System.out.println("  - Number of shippings: " + ships);
    System.out.println("  - Number of packages: " + packs);
}
 
 public Client getClientHighestDeclaredValue() {
    float max = 0;
    Client best = null;
    for (Client c : clients) {
        float total = 0;
        for (Shipping s : c.getShippings()) {
            for (Package p : s.getPackages()) {
                total += p.getValue();
            }
        }
        if (total > max) {
            max = total;
            best = c;
        }
    }
    return best;
}
 
 public float getHighestDeclaredValue() {
    float max = 0;
    for (Client c : clients) {
        float total = 0;
        for (Shipping s : c.getShippings()) {
            for (Package p : s.getPackages()) {
                total += p.getValue();
            }
        }
        if (total > max) {
            max = total;
        }
    }
    return max;
}
 
 public float getHighestDeclaredValue() {
    float max = 0;
    for (Client c : clients) {
        float total = 0;
        for (Shipping s : c.getShippings()) {
            for (Package p : s.getPackages()) {
                total += p.getValue();
            }
        }
        if (total > max) {
            max = total;
        }
    }
    return max;
}
 
 public Client getClientMaxPackages(LocalDate start, LocalDate end) {
    int max = 0;
    Client best = null;
    for (Client c : clients) {
        int count = 0;
        for (Shipping s : c.getShippings()) {
            if ((s.getRegistrationDate().isAfter(start) || s.getRegistrationDate().isEqual(start)) &&
                (s.getRegistrationDate().isBefore(end) || s.getRegistrationDate().isEqual(end))) {

                count += s.getPackages().size();
            }
        }
        if (count >= max) { // último
            max = count;
            best = c;
        }
    }
    return best;
}
 
}
  

  
