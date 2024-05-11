package DesingParkingLot.payments;

import DesingParkingLot.data.Ticket;
import DesingParkingLot.factory.VehicleTypeManagementFactory;
import DesingParkingLot.manager.VehicleTypeManager;

public class ParkingFeeProcessor {

    public double getParkingFee(Ticket ticket){
        double duration = 0;
        // duration can be figured out when we created ticket we had inside Vehicle entry time we can fetch that from DB and do the calculations
        return VehicleTypeManagementFactory.getVehicleTypeManager(ticket.getVehicle().getVehicleType()).getParkingFees(duration);
    }

    public boolean processParkingFees(Ticket ticket, PaymentProcessor paymentProcessor){
        if (getParkingFee(ticket) != paymentProcessor.getAmount()){
            throw new IllegalArgumentException("Wrong amount");
        }
        return paymentProcessor.executePayment();
    }

}
