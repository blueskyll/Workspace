package chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

class NullRobotProxyHandler implements InvocationHandler{

	private String nullName;
	private Robot proxied = new NRobot();
	
	public NullRobotProxyHandler(Class<? extends Robot> type){
		nullName = type.getSimpleName() + " NullRobot";
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return method.invoke(proxied, args);
	}
	
	private class NRobot implements Robot, Null{

		@Override
		public String name() {
			// TODO Auto-generated method stub
			return nullName;
		}

		@Override
		public String model() {
			// TODO Auto-generated method stub
			return nullName;
		}

		@Override
		public List<Operation> operations() {
			// TODO Auto-generated method stub
			return Collections.emptyList();
		}
		
	}
	
}

public class NullRobot {

	public static Robot newNullRobot(Class<? extends Robot> type){
		return (Robot)Proxy.newProxyInstance(type.getClassLoader(), new Class[]{Robot.class, Null.class}, new NullRobotProxyHandler(type));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot[] r = {
				new SnowRemovalRobot("SnowBee"),
				newNullRobot(SnowRemovalRobot.class)
		};
		for(Robot robot : r)
			Robot.Test.test(robot);
	}

}
