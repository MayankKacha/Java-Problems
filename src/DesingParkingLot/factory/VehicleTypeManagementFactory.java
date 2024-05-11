package DesingParkingLot.factory;

import DesingParkingLot.data.VehicleType;
import DesingParkingLot.manager.FourWheelerManager;
import DesingParkingLot.manager.HeavyVehicleManager;
import DesingParkingLot.manager.TwoWheelerManager;
import DesingParkingLot.manager.VehicleTypeManager;

public class VehicleTypeManagementFactory {

    private VehicleTypeManagementFactory(){}

    public static VehicleTypeManager getVehicleTypeManager(VehicleType vehicleType){
        VehicleTypeManager vehicleTypeManager;
        if (vehicleType.equals(VehicleType.TWO_WHEELER)){
            vehicleTypeManager = new TwoWheelerManager();
        }
        else if (vehicleType.equals(VehicleType.FOUR_WHEELER)){
            vehicleTypeManager = new FourWheelerManager();
        }else{
            vehicleTypeManager = new HeavyVehicleManager();
        }
        return vehicleTypeManager;
    }

}
