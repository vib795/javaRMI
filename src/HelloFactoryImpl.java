import java.rmi.*; //Hello.java
import java.rmi.server.*;
import java.util.LinkedList;

public class HelloFactoryImpl extends UnicastRemoteObject 
			 implements HelloFactoryInterface {
    
	private LinkedList<HelloInterface> l1;
	private LinkedList<HelloCallbackInterface> l2;
	
	public HelloFactoryImpl () throws RemoteException {
	  l1 = new LinkedList<HelloInterface>();
	  l2 = new LinkedList<HelloCallbackInterface>();
	  
	}
	
    public synchronized HelloInterface create(String name, int x, int y, int age) throws RemoteException {
	  HelloInterface h = new Hello(name,x,y,age);
	  l1.add(h);
	     
	  if(l1.size()%2 == 0) {
	    System.out.println("number of clients = " + l1.size());
      }	  
	  return h;
    }
	
	public synchronized void addCallBack(HelloCallbackInterface callbackobj) throws RemoteException {
	  l2.add(callbackobj); 
	  if(l2.size()%2 == 0) {
	    for (int i = 0; i < l2.size(); i++)  {
		  HelloCallbackInterface client = (HelloCallbackInterface) l2.get(i);
          client.callMe("Server calling back -> number of clients =" + l2.size());
	    }
	  }
	}  
}
