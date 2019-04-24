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
 	 // System.out.println(hello.say());
	  System.out.println(hello.add(name, x, y, age));
	  //Take in commands like go, list, etc. now
	  while (true){
	  	  	System.out.println("You can enter commands like 'go -50 30: to move the clinet on an XY plane.");
	  		System.out.println("You can also exit this application by typing 'quit'");
	  		String message;
	  		Scanner scan = new Scanner(System.in);

		  	message = scan.nextLine();

		  	String [] a = 	message.split(" ");
		  	System.out.println(a[0]);

		  	if (a[0] == "go"){
		  		System.out.println(hello.move("Connecting to server now..."));
				System.out.println(hello.setLocation(Integer.parseInt(a[1]),Integer.parseInt(a[2])));
		  	}
		  	else{continue;}

//		  	System.out.println(hello.move("This client has been moved."));
	  }
	  
	  //while(true) {;}
    } catch (Exception e) {
	  System.out.println ("HelloClient exception:"+e);
    }  
 }
}