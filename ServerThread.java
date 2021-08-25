import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {

	private Socket s;
	public ServerThread(Socket socket)
	{
		this.s = socket;
	}
	 @Override
	public void run() {
		 super.run();
		 try {
			readAndWrite();
		} catch (Exception e) {}
	}
	private void readAndWrite() throws Exception  {
		OutputStream out = s.getOutputStream();
		ObjectOutputStream objOut = new  ObjectOutputStream(out);
		
		InputStream intput = s.getInputStream();
		ObjectInputStream objInput = new ObjectInputStream(intput);
		
		Request r = (Request)objInput.readObject();
		ExchangeRate ecRt = new ExchangeRate();
		r.setConvertedNum(r.getMoney()*ecRt.rate(r.getFrom(),r.getTo()));
		objOut.writeObject(r);
		objInput.close();
		intput.close();
		objOut.close();
		out.close();
		s.close();
	}
}
