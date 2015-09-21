package chapter15;

import java.util.ArrayList;
import java.util.Random;

public class Store extends ArrayList<Aisle>{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private ArrayList<CheckoutStand> checkouts = new ArrayList<CheckoutStand>();
	
	public Store(int nAisles, int nShelves, int nProducts){
		for(int i = 0; i < nAisles; i++)
			add(new Aisle(nShelves, nProducts));
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Aisle a : this)
			for(Shelf s : a){
				for(Product p : s)
					sb.append(p.toString());
				sb.append("\n");
			}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Store(14, 5, 10));
	}

}

class Product{
	private String description;
	private final int id;
	private double price;
	
	public Product(int id, String desc, double price){
		this.id = id;
		this.description = desc;
		this.price = price;
		System.out.println(toString());
	}
	
	public String toString(){
		return id + ": " + description + ", price: $" + price;
	}
	
	public void priceChange(double change){
		this.price += change;
	}
	
	public static Generator<Product> generator = 
			new Generator<Product>(){
		private Random rand = new Random(47);
		public Product next(){
			return new Product(rand.nextInt(1000), "Test", Math.round(rand.nextDouble() * 1000) + 0.99);
		}
	};
}

class Shelf extends ArrayList<Product>{
	public Shelf(int nProducts){
		Generators.fill(this, Product.generator, nProducts);
	}
}

class Aisle extends ArrayList<Shelf>{
	public Aisle(int nShelves, int nProducts){
		for(int i = 0; i < nShelves; i++)
			add(new Shelf(nProducts));
	}
	
	
}

class CheckoutStand{}
class Office{}



