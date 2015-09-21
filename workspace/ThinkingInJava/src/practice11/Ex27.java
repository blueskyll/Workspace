package practice11;

import java.util.*;

class Command{
	private String expression;
	
	public Command(String expression){
		this.expression = expression;
	}
	public void operation(){
		System.out.println(expression);
	}
}

class CommandQueue{
	public Queue<Command> insertQueue(Command command){
		Queue<Command> q = new LinkedList<Command>();
		q.offer(command);
		return q;
	}
}
public class Ex27 {

	public void useQueue(Queue<Command> queue){
		Command c = queue.poll();
		c.operation();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Command> queue = new CommandQueue().insertQueue(new Command("command1"));
		new Ex27().useQueue(queue);
	}

}
