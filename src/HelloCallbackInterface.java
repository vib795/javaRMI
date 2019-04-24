//HelloCallbackInterface.java
import java.rmi.*;

public interface HelloCallbackInterface extends Remote {

    public void callMe (String message) 
	throws RemoteException;
}
