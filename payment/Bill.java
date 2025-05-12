package payment;

import reservation.Reservation;

public class Bill {

    Reservation reservation;
    double totalBillAmount;
    boolean isPaid;

    public Bill(Reservation reservation){
        this.reservation = reservation;
        this.totalBillAmount = computeBill();
        isPaid = false;
    }

    /*
        A dummy method returns a static bill of 100.0.
        //todo make it dynamic so it takes more things into consideration for generating bill.
     */
    private double computeBill(){
        return 100.0;
    }

}
