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

    /*public String say( ) throws RemoteException {
	  return message; 
    }*/
}