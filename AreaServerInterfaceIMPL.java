/* Matric: 211276

Name: Kerena Natalie

Course code/Group: CSC3104(G7)

Lab 5
*/
package LAB5;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.KeyStore.TrustedCertificateEntry;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public	class AreaServerInterfaceIMPL extends UnicastRemoteObject implements AreaServerInterface{
		public	AreaServerInterfaceIMPL() throws RemoteException {
		super();
		}

		@Override
		public double getAREA(double radius) throws RemoteException {
			double	area = Math.PI*radius*radius;
			System.out.println("Area is:" + area);
			return area;
		}
		
	}
