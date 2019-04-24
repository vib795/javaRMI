//HelloServer.java
import java.rmi.*;
public class HelloServer{

  public static void main(String args[]){

    try {
	 Naming.rebind("HelloFactory", 
			new HelloFactoryImpl() );

	 System.out.println ("Server is ready");
    } catch (Exception e) {
	 System.out.println ("Server failed: "+e);
    }
	
  }
}
