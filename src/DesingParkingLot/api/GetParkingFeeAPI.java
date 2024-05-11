package DesingParkingLot.api;

import DesingParkingLot.data.Ticket;
import DesingParkingLot.payments.ParkingFeeProcessor;

public class GetParkingFeeAPI {

    public double getParkingFee(Ticket ticket){
        ParkingFeeProcessor parkingFeeProcessor = new ParkingFeeProcessor();
        return parkingFeeProcessor.getParkingFee(ticket);
    }

}
