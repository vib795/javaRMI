//HelloClient.java
import java.rmi.*; 
import java.rmi.server.*;
import java.util.*;
public class HelloClient{
  public static void main (String[] argv) {
    try {
			Scanner sc = new Scanner(System.in);
			  System.out.println("Enter name:");
			  String name = sc.next();

			  System.out.println("Enter x and y:");
			  int x = sc.nextInt();
			  int y = sc.nextInt();

			  System.out.println("Enter age");
			  int age = sc.nextInt();

			  //HelloInterface hello = (HelloInterface) Naming.lookup("//localhost/Hello"); 
			  HelloFactoryInterface hellofactory = (HelloFactoryInterface) Naming.lookup("//localhost/HelloFactory"); 
			  HelloInterface hello = hellofactory.create(name,x,y,age);
			  HelloCallbackInterface callbackobj = new HelloCallbackImpl();
			  hellofactory.addCallBack(callbackobj); 
			  System.out.println(hello.add(name, x, y, age));
			  //Take in commands like go, list, etc. now
			  while (true){
			  		System.out.println("\n");
			  	  	System.out.println("List of commands you can use:.");
			  		System.out.println("1. go (X, Y) without the brackets and the comma. - This moves the location of the client you're on, to the X,Y coordinates in an XY plane.");
			  		System.out.println("2. get location - This gives the current location of your client in terms of X,Y. ");
			  		System.out.println("3. list 30 - Lists the number of clients in 30m radius of your client.");
			  		System.out.println("4. send user-id msg - Sends a message to a client of your choice.");
			  		System.out.println("5. quit - Will exit the system.");
			  		System.out.println("\n");

			  		String message;
			  		Scanner scan = new Scanner(System.in);

				  	message = scan.nextLine();

				  	String [] a = 	message.split(" ");
				  	System.out.println(a[0]);
				  	if (a[0].equalsIgnoreCase("go")){
				  		System.out.println(hello.move("Connecting to server now..."));
						System.out.println(hello.setLocation(Integer.parseInt(a[1]),Integer.parseInt(a[2])));
				  	}
				  	else if(a[0].equalsIgnoreCase("get") && a[1].equalsIgnoreCase("location")){
				  		System.out.println(hello.getLocation("Fetching location now..."));
				  	}
				  	else if(a[0].equalsIgnoreCase("quit")){
				  		System.exit(0);
				  	}
				  	/*else if(a[0].equalsIgnoreCase("list")){
				  		System.out.println(hello.listNeighbours(int radius));
				  	}*/
				  	else{ break;}
			  	} 
    } catch (Exception e) {
	  System.out.println ("HelloClient exception:"+e);
    }  
 }
}