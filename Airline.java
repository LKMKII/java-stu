package NEW;
public class Airline {
	String flightNum;// �����
	String takeOffCity;  //���
	String landCity;//Ŀ�ĵ�
	String startTime;//ʱ��
	String arriveTime;//����ʱ��
	String ticketPrice;//Ʊ��
	String discount;//�ۿ�
	String leftTicket;//��Ʊ
	
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

