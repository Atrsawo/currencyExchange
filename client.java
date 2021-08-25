import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
/*
 * this class is the client class 
 */
public class client extends Thread {
	
	private ClientGui cg;
	private String ip;
	private Request rq;
	public client(ClientGui cleintgui, String ip, Request reqeust)
	{
		this.cg = cleintgui;
		this.ip = ip;
		this.rq =  reqeust;
	}
	@Override
	public void run() {
		super.run();
		try {
			readAndWrite(cg, ip, rq);
		} catch (Exception e) {}
		
	}
	//writing into the output stream
	private void readAndWrite(ClientGui CG, String ipp, Request rqst) throws Exception 
	{
		Socket s = new Socket(ipp,8888);
		OutputStream out = s.getOutputStream();
		ObjectOutputStream objOut = new  ObjectOutputStream(out);
		
		InputStream intput = s.getInputStream();
		ObjectInputStream objInput = new ObjectInputStream(intput);
		objOut.writeObject(rqst);
		Request r = (Request) (objInput.readObject());
		ExchangeRate ecRt = new ExchangeRate();
		CG.setConvertedNum(r.getMoney()*ecRt.rate(r.getFrom(),r.getTo()));
		
		objInput.close();
		intput.close();
		objOut.close();
		out.close();
		s.close();
	}
}
