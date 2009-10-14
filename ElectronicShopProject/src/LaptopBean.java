
public class LaptopBean implements Product {

	String id;
	String make;
	double price;
	int quantity;

	public void setProductid(String productid)
	{
		id = productid;
	}

	public String getProductid()
	{
		return id;
	}

	public void setProductmake(String productmake)
	{
		make = productmake;
	}

	public String getProductmake()
	{
		return make;
	}

	public void setProductprice(double productprice)
	{
		price=productprice  ;
	}

	public double getProductprice()
	{
		return price;
	}

	public void setProductquantity(int quantity)
	{
		this.quantity = quantity;
	}

	public int getProductquantity()
	{
		return quantity;
	}

	public String toString()
	{
		return "id = "+id+"\n make = "+make+"\n price = "+price+" \n quantity = "+quantity;
	}
}
