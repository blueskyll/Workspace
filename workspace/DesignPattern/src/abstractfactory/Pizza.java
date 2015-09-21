package abstractfactory;

public abstract class Pizza {
	public Sauce sauce;
	public Cheese cheese;
	
	public abstract void prepare();
}
