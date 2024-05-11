package DesingParkingLot.api;

import DesingParkingLot.data.ParkingSpot;
import DesingParkingLot.vacator.ParkingSpaceVacator;

public class VacateParkingSpotAPI {

    public void vacateParkingSpotAPI(ParkingSpot parkingSpot){
        ParkingSpaceVacator parkingSpaceVacator = new ParkingSpaceVacator();
        parkingSpaceVacator.vacateParkingSpot(parkingSpot);
    }


}
