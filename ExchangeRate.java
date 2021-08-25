import java.io.Serializable;
/*
 * this class is for the exchange rates
 */
public class ExchangeRate implements Serializable{
	final double dolr = 3.214;
	final double nis = 1;
	final double euro = 3.96;
	final double pndStrlg = 4.60;
	final double bir = 0.075;
	public ExchangeRate()
		{}
	
	public double rate(String from, String to) 
	{	
			if(from.equals("NIS") && to.equals("$")) return nis/dolr;
			if(from.equals("NIS") && to.equals("Euro")){return nis/euro;}
			if(from.equals("NIS") && to.equals("Bir")) return  nis/bir;
			if(from.equals("NIS") && to.equals("pound sterling")) return nis/pndStrlg ;
			
			if(from.equals("$") && to.equals("NIS")) return dolr;
			if(from.equals("$") && to.equals("Euro")) return dolr/euro;
			if(from.equals("$") && to.equals("pound sterling")) 	return  dolr/pndStrlg;
			if(from.equals("$") && to.equals("Bir")) return  dolr/bir;
			
			if(from.equals("Euro") && to.equals("$") ) return euro/dolr;
			if(from.equals("Euro")  && to.equals("NIS")) return  euro;
			if(from.equals("Euro") && to.equals("pound sterling")) return  euro/pndStrlg;
			if(from.equals("Euro") && to.equals("Bir")) return  euro/bir;
			
			if(from.equals("Bir") && to.equals("Euro")) return  bir/euro;
			if(from.equals("Bir") && to.equals("NIS")) return bir/nis;
			if(from.equals("Bir") && to.equals("pound sterling")) return  bir/pndStrlg;
			if(from.equals("Bir") && to.equals("$")) return  bir/dolr;
				
			if(from.equals("pound sterling") && to.equals("NIS")) {return  (pndStrlg/nis);}
			if(from.equals("pound sterling") && to.equals("Bir")) return  pndStrlg/bir;
			if(from.equals("pound sterling") && to.equals("$")) 	return   pndStrlg/dolr;
			if(from.equals("pound sterling") && to.equals("Euro")) {return   pndStrlg/euro;}
			if(from.equals("pound sterling") && to.equals("pound sterling") || from.equals("Bir") && to.equals("Bir") || 
					from.equals("Euro") && to.equals("Euro") || from.equals("$") && to.equals("$") || from.equals("NIS") && to.equals("NIS")) return  1;
		
		
	return 0.0;
	}
}
