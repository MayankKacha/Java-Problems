package DesingParkingLot.data;

public class Ticket {

    private final String refNum;
    private final Vehicle vehicle;

    public Ticket(String refNum, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.refNum = refNum;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public String getRefNum() {
        return refNum;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    private final ParkingSpot parkingSpot;

}
