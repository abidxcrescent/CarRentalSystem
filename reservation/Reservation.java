package reservation;

import pickupLocation.Location;
import user.User;
import vehicle.Vehicle;

import java.util.Date;
import java.util.Timer;

public class Reservation {

    int reservationID = 0;
    User user;
    Vehicle vehicle;
    Date booklingDate;
    Date returnDate;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickupLocation;
    Location dropOffLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;
    Location storeLocation;

    public int createReservation(User user, Vehicle vehicle) {
        reservationID = reservationID + 1;
        this.user = user;
        this.vehicle = vehicle;
        reservationType = ReservationType.DAILY;
        reservationStatus = ReservationStatus.SCHEDULED;


        return reservationID;

    }

    // More crud operations can be implemented


}
