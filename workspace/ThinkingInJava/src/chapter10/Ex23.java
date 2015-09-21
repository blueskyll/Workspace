package chapter10;

interface U {
	void print();

	void save();

	void quit();
}

public class Ex23 {
	public U useU() {
		return new U() {

			@Override
			public void print() {
				// TODO Auto-generated method stub

			}

			@Override
			public void save() {
				// TODO Auto-generated method stub

			}

			@Override
			public void quit() {
				// TODO Auto-generated method stub

			}
		};
	}
}

class B{
	U[] u;
	
	public void firstMethod(U u){
		this.u[0] = u;
	}
	
	public void secondMethod(){
		u = null;
	}
	
	public void thirdMethod(){
		for(int i = 0; i < u.length; i++)
			System.out.println(i);
	}
}
