package DesingParkingLot.finder;

import DesingParkingLot.data.ParkingSpot;
import DesingParkingLot.manager.VehicleTypeManager;
import DesingParkingLot.selector.ParkingSpaceSelector;

import java.util.List;

public class ParkingSpotFinder {

    private final VehicleTypeManager vehicleTypeManager;

    private final ParkingSpaceSelector parkingSpaceSelector;

    public ParkingSpotFinder(VehicleTypeManager vehicleTypeManager, ParkingSpaceSelector parkingSpaceSelector) {
        this.vehicleTypeManager = vehicleTypeManager;
        this.parkingSpaceSelector = parkingSpaceSelector;
    }

    public ParkingSpot findParkingSpot(){
        List<ParkingSpot> parkingSpots = this.vehicleTypeManager.getParkingSpots();
        return parkingSpaceSelector.selectSpot(parkingSpots);
    }

}
