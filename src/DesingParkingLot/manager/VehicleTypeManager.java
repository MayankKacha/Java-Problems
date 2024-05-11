package DesingParkingLot.manager;

import DesingParkingLot.data.ParkingSpot;

import java.util.List;

public interface VehicleTypeManager {

    List<ParkingSpot> getParkingSpots();

    double getParkingFees(double durationInHours);

}
