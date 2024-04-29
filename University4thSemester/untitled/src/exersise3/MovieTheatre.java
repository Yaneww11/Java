package exersise3;

public class MovieTheatre extends TradeCenter{
    protected double price_for_ticket;
    protected int count_ticket;

    public MovieTheatre() {
    }

    public MovieTheatre(String name, String address, double price_for_ticket, int count_ticket) {
        super(name, address);
        this.price_for_ticket = price_for_ticket;
        this.count_ticket = count_ticket;
    }

    @Override
    public String toString() {
        return "MovieTheatre{" +
                "price_for_ticket=" + price_for_ticket +
                ", count_ticket=" + count_ticket +
                "} " + super.toString();
    }
}
