package DesingParkingLot.data;

public class CardDetails {

    private final String nameOnCard;

    public String getNameOnCard() {
        return nameOnCard;
    }

    public int getPin() {
        return pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    private final int pin;

    public CardDetails(String nameOnCard, int pin, String cardNumber) {
        this.nameOnCard = nameOnCard;
        this.pin = pin;
        this.cardNumber = cardNumber;
    }

    private final String cardNumber;

}
