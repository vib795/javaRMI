//HelloInterface.java
import java.rmi.*;

public interface HelloInterface extends Remote {

    public String add(String name, int x, int y, int age) 
	throws RemoteException;

	public String move(String message) throws RemoteException;

	public String setLocation(int x, int y) throws RemoteException;

	public String getLocation(String radius) throws RemoteException;

	public String getNeighbours(int rad) throws RemoteException;

	public int getX() throws RemoteException;

	public int getY() throws RemoteException;

	public String getName() throws RemoteException;

}
