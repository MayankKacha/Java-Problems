package DesingParkingLot.api;

import DesingParkingLot.data.ParkingSpot;
import DesingParkingLot.data.Ticket;
import DesingParkingLot.data.Vehicle;

public class GetTicketAPI {

    // we have made below method as synchronized as we need to check if the parking spot is free or not and if free we need to allocate that space to this
    // vehicle but here race situation can happen to avoid either we can have this keyword or we can have a db update which ensures thread safety.
    public synchronized Ticket getTicket(Vehicle vehicle, ParkingSpot parkingSpot){
        String ticketNumber = getUniqueTicketNumber();
        // logic to allocate parking spot resides here
        if (parkingSpot.isFree()){
            // change the flag here
        }
        return new Ticket(ticketNumber, vehicle, parkingSpot);
    }

    private String getUniqueTicketNumber(){
        return "";
    }

}
