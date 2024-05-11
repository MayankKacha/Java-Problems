package DesingParkingLot.selector;

import DesingParkingLot.data.EntryPoint;
import DesingParkingLot.data.ParkingSpot;

import java.util.List;

public class NearestParkingSelector implements ParkingSpaceSelector{
    private final EntryPoint entryPoint;
    public NearestParkingSelector(EntryPoint entryPoint) {
        this.entryPoint = entryPoint;
    }

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> parkingSpots) {
        return null;
    }
}
