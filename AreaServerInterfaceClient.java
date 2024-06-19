/* Matric: 211276

Name: Kerena Natalie

Course code/Group: CSC3104(G7)

Lab 5
*/
package LAB5;	
	import java.rmi.RemoteException;
	import java.rmi.registry.LocateRegistry;
	import java.rmi.registry.Registry;
	import javafx.application.Application;
	import javafx.geometry.Insets;
	import javafx.geometry.Pos;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.GridPane;
	import javafx.scene.layout.HBox;
	import javafx.scene.layout.VBox;
	import javafx.stage.Stage;

	public class AreaServerInterfaceClient extends Application {
		private AreaServerInterface areaServerInterface;
		private TextField tf_radius = new TextField();
		private TextField tf_area = new TextField();

		private Button bt_calculate = new Button("Calculate");
		GridPane gPane = new GridPane();
		HBox hBox = new HBox();
		VBox vBox = new VBox();
		@Override
		public void start(Stage arg0) throws Exception {
			gPane.add(new Label("Radius: "), 0, 0);
			gPane.add(tf_radius, 1, 0);
			gPane.add(new Label("Area: "), 0, 1);
			gPane.add(tf_area, 1, 1);
			
			gPane.add(bt_calculate, 1, 3);
			
			tf_area.setEditable(false);
			
			gPane.setPadding(new Insets(20));
			vBox.getChildren().add(gPane);
			vBox.setPadding(new Insets(20));
			vBox.setAlignment(Pos.CENTER);
			
			arg0.setScene(new Scene(vBox));
			arg0.show();
			
			initializeRMI();
			bt_calculate.setOnAction(e -> setAREA());
		}
		
		public static void main(String[] args) {
		    launch(args);
		  }
		
		public double getRadius() {
			return Double.parseDouble(tf_radius.getText().trim());
		}
		
		
		protected void initializeRMI() {
			String hoString = "";
			try {
				Registry registry = LocateRegistry.getRegistry(hoString);
			    areaServerInterface = (AreaServerInterface) registry.lookup("serverinterface");
				System.out.println("Server object " +areaServerInterface + " found");
				
			} catch (Exception e) {
				System.out.println(e);
				
			}
		}
		
		protected void setAREA(){
			double area = 0;
			try {
				area = areaServerInterface.getAREA(getRadius());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			tf_area.setText(String.valueOf(area));
		}
	}

