package abstractfactory;

public class NYPizzaStore extends PizzaStore{

	private IngredientFactory ingredient = new NYIngredientFactory();
	
	@Override
	public Pizza createPizza(String type) {
		// TODO Auto-generated method stub
		if(type.equals("cheese"))
			return new CheesePizza(ingredient);
		return null;
	}

}
