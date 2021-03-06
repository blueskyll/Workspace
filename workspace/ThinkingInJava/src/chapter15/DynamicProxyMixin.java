package chapter15;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
public class DynamicProxyMixin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}

class MixinProxy implements InvocationHandler{

	Map<String, Object> delegateByMethod;
	
	public MixinProxy(TwoTuple<Object, Class<?>>... pairs){
		delegateByMethod = new HashMap<String, Object>();
		for(TwoTuple<Object, Class<?>> pair : pairs){
			for(Method m : pair.second.getMethods()){
				String name = m.getName();
				if(!delegateByMethod.containsKey(name))
					delegateByMethod.put(name, pair.first);
			}//end for m
		}//end for pair
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		String methodName = method.getName();
		Object delegate = delegateByMethod.get(methodName);
		return method.invoke(delegate, args);
	}
	
	public static Object newInstance(TwoTuple<Object, Class<?>>... pairs){
		Class[] interfaces = new Class[pairs.length];
		
		for(int i = 0; i < pairs.length; i++){
			interfaces[i] = (Class) pairs[i].second;
		}
		
		ClassLoader cl = interfaces[0].getClassLoader();
		
		return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
	}
}



class TwoTuple<A, B>{
	public final A first;
	public final B second;
	
	public TwoTuple(A a, B b){
		first = a;
		second = b;
	}
	
	public String toString(){
		return "(" + first + ", " + second + ")";
	}
}