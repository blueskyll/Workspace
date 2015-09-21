package abstractfactory;

public abstract class PizzaStore {
	public Pizza orderPizza(String type){
		Pizza pizza = createPizza(type);
		pizza.prepare();
		return pizza;
	}
	
	public abstract Pizza createPizza(String type);
}
