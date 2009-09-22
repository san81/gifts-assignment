package giftsmaker.listeners;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class MyServer {

	/**
	 * @param args
	 */
	public static boolean serverStarted=false;
	public static void startServer() throws IOException {
		
		ServerSocket server = new ServerSocket(8888, 5, InetAddress.getLocalHost() );
		System.out.println("Server Started....");
		System.out.println("Started Listening to product manufacturing requests....");
		Socket incoming = server.accept();
	    BufferedReader in = new BufferedReader
	      (new InputStreamReader(incoming.getInputStream()));
	    boolean done = false;
	      while (!done)
	        {
	          String line = in.readLine();
	          if (line == null) done = true;
	          else
	          {
	            System.out.println("<<<<< Manufacturing order received for the product - " + line); 

	            if (line.trim().equals("BYE")){
	            	incoming = server.accept();/* wait for the next request */
	            	in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
	            }
	          }
	        }
	    incoming.close();
	    System.out.println("Server End");
	}

}
