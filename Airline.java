package NEW;
public class Airline {
	String flightNum;// 航班号
	String takeOffCity;  //起飞
	String landCity;//目的地
	String startTime;//时间
	String arriveTime;//到低时间
	String ticketPrice;//票价
	String discount;//折扣
	String leftTicket;//余票
	
	public Airline(String flightNum, String takeOffCity, String landCity, String startTime, 
			String arriveTime, String ticketPrice, String discount, String leftTicket) {
		this.flightNum = flightNum;
		this.takeOffCity = takeOffCity;
		this.landCity = landCity;
		this.startTime = startTime;
		this.arriveTime = arriveTime;
		this.ticketPrice = ticketPrice;
		this.discount = discount;
		this.leftTicket = leftTicket;
	}
	
	public String toString() {
		return flightNum + " " + takeOffCity + " " + landCity + " " + startTime 
				+ " " + arriveTime + " " + ticketPrice + " " + discount + " " + leftTicket + "\n";
	}
}

