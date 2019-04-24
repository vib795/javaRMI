import java.rmi.*; 
import java.rmi.server.*;

public class HelloCallbackImpl extends UnicastRemoteObject
                         implements HelloCallbackInterface {
	public HelloCallbackImpl () throws RemoteException {}
	
	public void callMe (String message) throws RemoteException {
	  System.out.println(message);
	}
	
	
}