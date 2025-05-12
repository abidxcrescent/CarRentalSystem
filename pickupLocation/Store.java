package pickupLocation;

import reservation.Reservation;
import user.User;
import vehicle.Vehicle;
import vehicle.VehicleType;

import java.util.List;

public class Store {
    private int storeID;
    VehicleInventoryManagement inventoryManagement;
    Location storeLocation;
    List<Reservation> reservations;

    /*
      This method is for filtering.
      Since vehicle can be of type Car, Bike which is an enum VehicleType
      If we want list of vehicles which are car then pass vehicleType as VehicleType.CAR
     */
    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return  inventoryManagement.getVehicles();
    }

    /*
        This method takes a list of vehicles and add it to the inventory.
        If you want to add just one vehicle pass only one vehicle object in the list.
     */
    public void setVehicles(List<Vehicle> vehicles) {
        inventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    /*
        This method creates a reservation which return a reservation id
     */
    public Reservation createReservation(Vehicle vehicle, User user) {
        Reservation reservation = new Reservation();
        reservation.createReservation(user,vehicle);
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationID) {
        //todo take out the reservation from the list and call complete reservation method
        return true;
    }

    //todo update reservation


    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }
}
