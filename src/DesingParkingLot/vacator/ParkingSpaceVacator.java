package DesingParkingLot.vacator;

import DesingParkingLot.data.ParkingSpot;

public class ParkingSpaceVacator {

    public void vacateParkingSpot(ParkingSpot parkingSpot){
        // logic to free spot
        if (parkingSpot.isFree()){
            throw new IllegalArgumentException("Its already vacated!");
        }
        // set here as free

    }


}
