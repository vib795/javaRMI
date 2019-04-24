//HelloInterface.java
import java.rmi.*;

public interface HelloInterface extends Remote {

    public String add(String name, int x, int y, int age) 
	throws RemoteException;

   /* public String say() 
	throws RemoteException;
*/
}
