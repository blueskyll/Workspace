package abstractfactory;

public class CheesePizza extends Pizza{

	private IngredientFactory ingredient;
	
	public CheesePizza(IngredientFactory f){
		ingredient = f;
	}
	
	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		sauce = ingredient.createSauce();
		cheese = ingredient.createCheese();
	}

}
