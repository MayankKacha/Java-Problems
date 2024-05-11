package DesingParkingLot.api;

import DesingParkingLot.data.EntryPoint;
import DesingParkingLot.data.ParkingSpot;
import DesingParkingLot.data.SpotSelection;
import DesingParkingLot.data.VehicleType;
import DesingParkingLot.factory.SpotSelectionFactory;
import DesingParkingLot.factory.VehicleTypeManagementFactory;
import DesingParkingLot.finder.ParkingSpotFinder;
import DesingParkingLot.manager.VehicleTypeManager;
import DesingParkingLot.selector.ParkingSpaceSelector;

public class FindParkingSpotAPI {


    public ParkingSpot findParkingSpot(EntryPoint entryPoint, VehicleType vehicleType, SpotSelection spotSelection)
    {
        // below will give us all the available parking slots
        VehicleTypeManager vehicleTypeManager = VehicleTypeManagementFactory.getVehicleTypeManager(vehicleType);
        // parking selector to get us the parking available slot based on chosen strategy
        ParkingSpaceSelector parkingSpaceSelector;
        if (spotSelection.equals(SpotSelection.NEAREST)){
            parkingSpaceSelector = SpotSelectionFactory.getNearestSpot(entryPoint);
        }else if (spotSelection.equals(SpotSelection.RANDOM)){
            parkingSpaceSelector = SpotSelectionFactory.getRandomSpot();
        }else{
            throw new IllegalArgumentException("Illegal parking spot selection strategy chosen!");
        }
        return new ParkingSpotFinder(vehicleTypeManager,parkingSpaceSelector).findParkingSpot();
    }


}
