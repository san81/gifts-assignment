
import java.util.*;

public class Laptop implements Product {

	public static void main(String args[]) {

		List laptoplist = new ArrayList();
		LaptopBean lb = new LaptopBean();
		//lb.setProductid(
		laptoplist.add(1,lb);
		lb.setPrice(25000.00);
		lb.setQuantity(25);
		lb.setProductname("compaq");

		laptoplist.add(2,lb);
		lb.setPrice(30000.00);
		lb.setQuantity(5);
		lb.setProductname("HCL");

		laptoplist.add("L003",lb);
		lb.setPrice(40000.00);
		lb.setQuantity(50);
		lb.setProductname("Lanovo");

		Iterator it = lb.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

		/*
		System.out.println("Do u want to Add / Show / Sell ??? \nPlease Enter ur choice ::");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = br.readLine();
		while(choice<4)
		{
			System.out.println(" 1. ---- Add /n 2. ---- Show /n 3. ---- Sell");
			switch(choice)
			{
				case 1:
					System.out.println("Enter Product Id	Quantity");
					String productid = br.readLine();
					

					
	}*/
	}
}