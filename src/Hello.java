import java.rmi.*; //Hello.java
import java.rmi.server.*;

public class Hello extends UnicastRemoteObject 
        implements HelloInterface {
        private String name;
        private int x,y,age;

    public Hello (String name, int x, int y, int age) throws RemoteException {
      this.name = name;
      this.x = x;
      this.y = y;
      this.age = age;
    }

    public String add(String name, int x, int y, int age) throws RemoteException {
	    this.name = name;
      this.x = x;
      this.y = y;
      this.age = age;

      return ("Data for this client stored..");
    }

    public String move(String message) throws RemoteException{
        return (message + " Server is moving the client to the new location...");
    }

    public String setLocation(int x, int y){
        this.x = x; this.y = y;
        return ("Tne new location has been updated with the values provided: " + this.x + " and " + this.y);
    }

    public String getLocation(String message){
        return (message + " The current location on an X-Y plane is: " + this.x + " and " + this.y);
    }

    public int getX(){
      return (this.x);
    }

    public int getY(){
      return (this.y);
    }

    public String getNeighbours(int rad){
      return ("Number of neighbours will come from here.");
    }
}