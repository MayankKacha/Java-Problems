package DesingParkingLot.selector;

import DesingParkingLot.data.ParkingSpot;

import java.util.List;

public interface ParkingSpaceSelector {

    // select spot is used to select one particular spot for a vehicle from list of available parking slots.
    ParkingSpot selectSpot(List<ParkingSpot> parkingSpots);

}
