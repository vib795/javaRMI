import java.rmi.*; //Hello.java
import java.rmi.server.*;
import java.util.LinkedList;
import java.lang.Math.*;

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
	//synchronized
	public synchronized String getNeighbours(int radius, int x1, int y1, String mainName) throws RemoteException{
		radius = radius;
		x1 = x1; 
		y1 = y1;
		String name = mainName;
		
		String closeNodes = "";
		String message = "";
		int x;
		int y;
		
		for(HelloInterface i: l1){
			x = i.getX();
			y = i.getY();
		
			Double dis=Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));
			if (dis<=radius){
				closeNodes = i.getName();
				message += name + " is closest to " + closeNodes + " distance " + dis + "\n";
			}
			else{
				message = "Search radius not big enough for one of the clients from this client \n";
			}
		}
		return message;
	}
}
