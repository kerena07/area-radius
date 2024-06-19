/* Matric: 211276

Name: Kerena Natalie

Course code/Group: CSC3104(G7)

Lab 5
*/
package LAB5;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class rmiServer {
	public static void main(String[] args) throws RemoteException {
		LocateRegistry.createRegistry(1099);
		while(true);
	}
}
