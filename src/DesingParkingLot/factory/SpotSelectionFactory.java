package DesingParkingLot.factory;

import DesingParkingLot.data.EntryPoint;
import DesingParkingLot.selector.NearestParkingSelector;
import DesingParkingLot.selector.ParkingSpaceSelector;
import DesingParkingLot.selector.RandomParkingSelector;

public class SpotSelectionFactory {

    private SpotSelectionFactory(){}

    public static ParkingSpaceSelector getNearestSpot(EntryPoint entryPoint){
        return new NearestParkingSelector(entryPoint);
    }

    public static ParkingSpaceSelector getRandomSpot(){
        return new RandomParkingSelector();
    }

}
