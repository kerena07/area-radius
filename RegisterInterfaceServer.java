/* Matric: 211276

Name: Kerena Natalie

Course code/Group: CSC3104(G7)

Lab 5
*/
package LAB5;
import java.rmi.Remote;

import java.rmi.RemoteException;
import java.rmi.registry.*;

public class RegisterInterfaceServer implements Remote {
	public static void main(String[] args) {
		try {
			AreaServerInterface area = new AreaServerInterfaceIMPL() ;
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("serverinterface",  area);
			System.out.println(" SERVER " + area + " CONNECTED");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

}
