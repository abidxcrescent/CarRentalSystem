package reservation;

import pickupLocation.Location;
import pickupLocation.Store;
import user.User;

import java.util.List;

public class VehicleRentalSystem {
    List<Store> storeList;
    List<User> userList;

    public VehicleRentalSystem(List<Store> stores, List<User> users) {

        this.storeList = stores;
        this.userList = users;
    }

    /*
        this method as of now is returning a store(pick up location).
        the idea is to return a list of stores to the requested user
        and user should have ability to choose a pickup location.
     */
    public Store getStore(Location location){

        // todo based on location, we will filter out the Store from storeList.
        return storeList.get(0);
    }
    
    // todo add users, remove users, add stores, remove stores

}
