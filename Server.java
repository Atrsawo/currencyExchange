import java.io.IOException;
import java.net.*;
/*
 * this class is the server class which based on TCP protocol
 */
public class Server {

	public Server()
	{
		ServerSocket sc = null;
		Socket s = null;
		try {
			sc = new ServerSocket(8888);
			while(true) {
				s = sc.accept();
				new ServerThread(s).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
				try {
					sc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}	
	}

	
	public static void main(String[] args) {
		new Server();
	}
}
