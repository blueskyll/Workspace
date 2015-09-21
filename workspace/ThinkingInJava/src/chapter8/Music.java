package chapter8;



enum Note{
	MIDDLE_C, C_SHARP;
}
class Instrument{
	public void play(Note n){
		System.out.println("Instrument play");
	}
	
	public void play1(){
		test();
	}
	
	public void test(){
		System.out.println("testInstrument");
	}
}

class Stringed extends Instrument{
	public void play(Note n){
		System.out.println("Stringed play");
	}
}

class Brass extends Instrument{
	
}

class Wind extends Instrument{
	public void play(Note n){
		System.out.println("Wind play");
	}
	
	public void test(){
		System.out.println("test Wind");
	}
}
public class Music {

	/**
	 * @param args
	 */
	
	
	public static void tune(Wind i){
		i.play(Note.MIDDLE_C);
	}
	
	public static void tune(Stringed i){
		i.play(Note.MIDDLE_C);
	}
	
	public static void tune(Brass i){
		i.play(Note.MIDDLE_C);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wind flute = new Wind();
		Stringed violin = new Stringed();
		Brass f = new Brass();
		tune(flute);
		tune(violin);
		tune(f);
		
		Instrument i = new Wind();
		i.play1();
	}

}
