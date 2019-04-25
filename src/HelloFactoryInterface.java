//HelloFactoryInterface.java
import java.rmi.*;

public interface HelloFactoryInterface extends Remote {

    public HelloInterface create(String name, int x, int y, int age) 
	throws RemoteException;
  
    public void addCallBack(HelloCallbackInterface callbackobj) 
	throws RemoteException;

	public void getNeighbours(int radius)
	throws RemoteException;
}
