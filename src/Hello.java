import java.rmi.*; //Hello.java
import java.rmi.server.*;

public class Hello extends UnicastRemoteObject 
			 implements HelloInterface {
    //private String message;

    private String name;
    private int x,y,age;

    //ArrayList<Hello> dt = new ArrayList(); 

    //public Hello (String msg) throws RemoteException {
    public Hello (String name, int x, int y, int age) throws RemoteException {
	  name = name;
      x = x;
      y = y;
      age = age;
     // message = msg; 
    }

    public String add(String name, int x, int y, int age) throws RemoteException {
	  name = name;
      x = x;
      y = y;
      age = age;

      return ("Data for this client stored..");
      //message = new String (message + s); 
	  //return message;  
    }

    public String move(String message) throws RemoteException{
        return (message + " \n Server is moving the client to the new location...");
    }

    public String setLocation(int x, int y){
        this.x = x; this.y = y;
        return ("Tne new location has been updated with the values provided: " + x + " and " + y);
    }

    public String getLocation(String message){
        return (message + " The current location on an X-Y plane is: " + this.x + " and " + this.y);
    }

    /*public String say( ) throws RemoteException {
	  return message; 
    }*/
}