package chapter10;

public class Ex26 {

	/**
	 * @param args
	 */
	class Inner2 extends WithInner.Inner{
		public Inner2(WithInner wi, int i){
			wi.super(i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex26 ex = new Ex26();
		WithInner wi = new WithInner();
		Inner2 inner2 = ex.new Inner2(wi, 1);
	}

}

class WithInner{
	class Inner{
		private int i;
		public Inner(int i){
			this.i = i;
			System.out.println(i);
		}
	}
}