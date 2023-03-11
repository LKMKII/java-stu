package NEW;
public class Client {
	String name, id, flightNum, ticketNum, bookId;
	public Client(String name, String id, String flightNum, String ticketNum, String bookId)
	{
		this.name = name;
		this.id = id;
		this.flightNum = flightNum;
		this.ticketNum = ticketNum;
		this.bookId = bookId;
	}
	public String toString() {
        return name + " " + id + " " + flightNum + " " + ticketNum + " " + bookId + "\n";
	}
}
