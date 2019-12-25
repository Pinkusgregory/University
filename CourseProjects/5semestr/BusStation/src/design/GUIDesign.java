package design;

import java.sql.SQLException;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class GUIDesign extends PanesAndNodes {
	Scene scene1 = null;
	VBox firstWindowPane = new VBox();
	Stage stage = new Stage();

	public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {
		scene1 = null;
		scene1 = new Scene(firstWindowPane, 500, 270);
		primaryStage.setTitle("Bus Station");
		primaryStage.setScene(scene1);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	public void welcomeWindow() {
		buttons.setSpacing(30);
		welcomeWindowDesign();
		buttons.getChildren().clear();
		buttons.getChildren().addAll(chooseEmployee, chooseCustomer, enter);
		firstWindowPane.getChildren().clear();
		firstWindowPane.getChildren().addAll(welcome, buttons);
	}

	// Employee Account design
	HBox managerOption = new HBox();

	public void informationPage() {
		informationPageNodesDesign();
		managerOption.setSpacing(10);
		managerOption.getChildren().clear();
		managerOption.getChildren().addAll(showTripsManager, showVehiclesManager, showEmployeesManager);
		managerOption.setAlignment(Pos.CENTER);
		employeeBox.getChildren().clear();
		employeeBox.getChildren().addAll(welcomeEmployee, emplyeeInfo, completeInfo, managerOption, logout);
		if (employeeBox.getScene() == null) {
			Scene scene2 = new Scene(employeeBox, 650, 400);
			stage.setScene(scene2);
		} else
			stage.setScene(employeeBox.getScene());
	}

	int checkTripType = 0;
	Text bookingDone = new Text();
	Button backToBockNewTickets = new Button("Back");

	public void customerBookTicket() {
		bookingDone.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 16));
		bookTicketDesign();
		bookingTicketVBox.getChildren().clear();
		bookingTicketVBox.getChildren().addAll(chooseTripType, destinationHBox, showAvilableTrips,
				logout);
		choosecertainTripToBook.getChildren().clear();
		choosecertainTripToBook.getChildren().addAll(enterTripCode, numberOfTickets, doneEnterTripCode);
		choosecertainTripToBook.setSpacing(20);
		destinationHBox.setAlignment(Pos.CENTER);
		destinationHBox.getChildren().clear();
		destinationHBox.getChildren().addAll(from, to);
		if (bookingTicketVBox.getScene() == null) {
			Scene scene2 = new Scene(bookingTicketVBox, 650, 400);
			stage.setScene(scene2);
		} else
			stage.setScene(bookingTicketVBox.getScene());
	}
}