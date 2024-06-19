/* Matric: 211276

Name: Kerena Natalie

Course code/Group: CSC3104(G7)

Lab 5
*/
package LAB5;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AreaServerInterface extends Remote {
	public double getAREA(double radius) throws RemoteException;
	
}
