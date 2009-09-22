package giftsmaker.listeners;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MyClient {

	public static void sendProductMakingOrder(int productId) throws IOException{
		Socket s=new Socket(InetAddress.getLocalHost(),8888);
		PrintWriter out = new PrintWriter
		  (s.getOutputStream(), true /* autoFlush */);
		System.out.println("Sending an order for to manufacturing Server >>>>>>>>");
		//put logic for product manufacturing
		out.println("Manufacture "+productId);
		out.println("BYE");
		s.close();

	}
}
