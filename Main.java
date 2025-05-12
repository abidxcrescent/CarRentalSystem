import payment.Bill;
import payment.Payment;
import pickupLocation.Location;
import pickupLocation.Store;
import reservation.Reservation;
import reservation.VehicleRentalSystem;
import user.User;
import vehicle.Car;
import vehicle.Vehicle;
import vehicle.VehicleType;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        /*
            Behind the scene for orchestration before  user make any interaction with system
            1. Add stores,
            2. Add vehicles for the stores added,
            3. Add Users who want to book vehicles.
         */

        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);

        /*
            From the list of users which user would like to book the car.
            In our example we will take first user.
         */

        //1. User logs in
        User user = users.get(0);

        //2. USer search store based on location
        Location location = new Location("1216 E Vista Del Cerro Dr", 85281, "Tempe","AZ","US");
        /*
            Depending on the location rentalSystem gives us the best store.
         */
        Store store = rentalSystem.getStore(location);

        //2. Get all the vehicles depending on the filters.
        /*
            Right now we only have one filter, they type of vehicle: car or bike.
         */
        List<Vehicle> vehiclesInStore = store.getVehicles(VehicleType.CAR);

        //3. Reserving a particular vehicle
        /*
            store is maintaining a list of reservations we are adding another reservation for
            a specific user and car.
         */
        Reservation reservation = store.createReservation(vehiclesInStore.get(0),users.get(0));

        //4. generate bill for the reservation
        Bill bill = new Bill(reservation);

        //5. Make payment
        Payment payment = new Payment();
        payment.payBill(bill);

        //6. Trip completed, submit the vehicle and close the reservation
        store.completeReservation(1);










    }


    public static List<Vehicle> addVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle v1 = new Car();
        v1.setVehicleID(1);
        v1.setVehicleType(VehicleType.CAR);

        Vehicle v2 = new Car();
        v2.setVehicleID(2);
        v2.setVehicleType(VehicleType.CAR);

        vehicles.add(v1);
        vehicles.add(v2);

        return vehicles;
    }

    public static List<User> addUsers() {
        List<User> users = new ArrayList<>();
        User u1 = new User();
        u1.setUserID(1);
        u1.setFirstName("John");
        u1.setLastName("Doe");
        u1.setEmail("john@doe.com");
        users.add(u1);

        User u2 = new User();
        u2.setUserID(2);
        u2.setFirstName("Jane");
        u2.setLastName("Doe");
        u2.setEmail("jane@doe.com");
        users.add(u2);

        return users;
    }


    public static List<Store> addStores(List<Vehicle> vehicles) {
        List<Store> stores = new ArrayList<>();
        Store s1 = new Store();
        s1.setStoreID(1);
        s1.setVehicles(vehicles);

        stores.add(s1);

        return stores;
    }


}
