import javax.swing.JOptionPane;

public class ParkingSystem {
    private static ParkingLot parkingLot = new ParkingLot();

    public static void main(String[] args) {
        int choice;
        do {
            choice = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción:\n"
                    + "1. Ingresar vehículo\n"
                    + "2. Sacar vehículo\n"
                    + "3. Mostrar registro de parqueo\n"
                    + "4. Salir"));

            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    removeVehicle();
                    break;
                case 3:
                    parkingLot.showParkingRegister();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (choice != 4);
    }

    // Método para agregar un vehículo al parqueadero
    private static void addVehicle() {
        String plateNumber;
        do {
            plateNumber = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
            if (parkingLot.isPlateNumberRegistered(plateNumber)) {
                JOptionPane.showMessageDialog(null, "La placa ingresada ya está registrada en el parqueadero. Por favor, ingrese una placa diferente.");
            }
        } while (parkingLot.isPlateNumberRegistered(plateNumber));

        String ownerName = JOptionPane.showInputDialog("Ingrese el nombre del propietario:");
        String phoneNumber;
        do {
            phoneNumber = JOptionPane.showInputDialog("Ingrese el número de teléfono del propietario:");
            if (parkingLot.isPhoneNumberRegistered(phoneNumber)) {
                JOptionPane.showMessageDialog(null, "El número de teléfono ingresado ya está registrado en el parqueadero. Por favor, ingrese un número de teléfono diferente.");
            }
        } while (parkingLot.isPhoneNumberRegistered(phoneNumber));

        Owner owner = new Owner(ownerName, phoneNumber);
        Vehicle vehicle = new Vehicle(plateNumber, owner);

        parkingLot.addVehicle(vehicle);
    }

    // Método para remover un vehículo del parqueadero
    private static void removeVehicle() {
        String plateNumber = JOptionPane.showInputDialog("Ingrese la placa del vehículo a sacar:");
        parkingLot.removeVehicle(plateNumber);
    }
}