import java.io.Serializable;
/*
 * this class present the requests of the client
 */
public class Request implements Serializable {

	private double money;
	private double convertedNum;
	private String from;
	private String to;
	
	
	
	public Request(double m, String source, String dest) {
		if ( m >= 0) this.money = m;
		this.from = source;
		this.to = dest;
	}

	public double getMoney(){return money;}
	
	public String getFrom(){return from;}
	
	public String getTo(){return to;}
	
	public double getConvertedNum(){return convertedNum;}
	
	public void setConvertedNum(double val)
	{
		convertedNum = val;
	}
	
	public void setFrom(String s)
	{
		from = s;
	}
	
	public void setTo(String s)
	{
		to = s;
	}

	public void setNum(double d) {
		money = d;
		
	}
	
}
