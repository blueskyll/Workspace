package chapter10;

interface Game{
	boolean move();
}

interface GameFactory{
	Game getGame();
}

class Checkers implements Game{
	private Checkers(){}
	private int moves = 0;
	private static final int MOVES = 3;
	public boolean move(){
		System.out.printf("Checkers move" + moves);
		return ++moves != MOVES; 
	}
	
	public static GameFactory factory = new GameFactory(){
		public Game getGame(){
			return new Checkers();
		}
	};
}

class Chess implements Game{
	private Chess(){}
	private int moves = 0;
	private static final int MOVES = 4;
	public boolean move(){
		System.out.println("Chess move" + moves);
		return ++moves != MOVES;
	}
	
	public static GameFactory factory = new GameFactory(){
		public Game getGame(){
			return new Chess();
		}
	};
}


public class Games {

	public static void playGame(GameFactory factory){
		Game s = factory.getGame();
		while(s.move())
			;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Checkers.factory.getGame());
		System.out.println(Checkers.factory.getGame());
		System.out.println(Checkers.factory.getGame());
		System.out.println(Checkers.factory.getGame());
	}

}
