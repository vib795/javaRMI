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
	  }
	  
	  //while(true) {;}
    } catch (Exception e) {
	  System.out.println ("HelloClient exception:"+e);
    }  
 }
}
