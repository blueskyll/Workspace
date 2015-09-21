package abstractfactory;

public class NYIngredientFactory implements IngredientFactory{

	@Override
	public Sauce createSauce() {
		// TODO Auto-generated method stub
		return new NYSauce();
	}

	@Override
	public Cheese createCheese() {
		// TODO Auto-generated method stub
		return new NYCheese();
	}

}
