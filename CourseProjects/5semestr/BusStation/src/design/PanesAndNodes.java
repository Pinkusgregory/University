package design;

import javafx.scene.control.TableColumn;
import busStation.Staff;
import busStation.Trips;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PanesAndNodes extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {

	}

	// welcome Window
	VBox buttons = new VBox();
	Text welcome = new Text("Welcome to the Bus Station");
	ToggleGroup group = new ToggleGroup();
	RadioButton chooseEmployee = new RadioButton("Information");
	RadioButton chooseCustomer = new RadioButton("Ticket");
	Button enter = new Button("ENTER");

	public void welcomeWindowDesign() {
		// welcome text designing
		welcome.setFont(Font.font("Curlz MT", FontWeight.BOLD, FontPosture.REGULAR, 40));
		welcome.setTranslateX(40);
		welcome.setTranslateY(20);
		// radio buttons designing
		chooseEmployee.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20));
		chooseEmployee.setToggleGroup(group);
		chooseCustomer.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20));
		chooseCustomer.setToggleGroup(group);
		// enter button desining
		enter.setScaleX(1.3);
		enter.setScaleY(1.3);
		buttons.setTranslateX(180);
		buttons.setTranslateY(60);
		enter.setTranslateX(50);
	}

	// Employee's Account
	Scene scene2 = null;
	VBox employeeBox = new VBox();
	Text welcomeEmployee = new Text();
	Text emplyeeInfo = new Text();
	Text completeInfo = new Text();
	Button logout = new Button("Log Out");
	Button showTripsManager = new Button("Show Trips");
	Button showVehiclesManager = new Button("Show Bus");
	Button showEmployeesManager = new Button("Show Staff");

	public void informationPageNodesDesign() {
		emplyeeInfo.setText("Your Info");
		emplyeeInfo.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 19));
		welcomeEmployee.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20));
		welcomeEmployee.setTranslateY(7);
		completeInfo.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 20));
		employeeBox.setAlignment(Pos.CENTER);
		employeeBox.setSpacing(8);
		employeeBox.getChildren().clear();
	}

	// table design
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void tablesDesign(TableColumn t, String s) {
		t.setMinWidth(110);
		t.setStyle("-fx-alignment:CENTER");
		t.setCellValueFactory(new PropertyValueFactory<Staff, String>(s));
	}

	VBox bookingTicketVBox = new VBox();
	HBox tripTypeChoosingHBox = new HBox();
	Text searchTrip = new Text("Search for you bus trip");
	HBox destinationHBox = new HBox();
	Label from = new Label("From");
	Label to = new Label("To");
	ComboBox<String> tripStarting = new ComboBox<String>();
	ComboBox<String> tripEnding = new ComboBox<String>();
	Text chooseTripType = new Text("Choose Trip");
	Button showAvilableTrips = new Button("Show Trips");
	HBox choosecertainTripToBook = new HBox();
	TextField enterTripCode = new TextField();
	TextField numberOfTickets = new TextField();
	Text avilableTripsText = new Text("All Avilable Trips");
	Button doneEnterTripCode = new Button("Book");

	public void bookTicketDesign() {
		bookingTicketVBox.setSpacing(15);
		from.setGraphic(tripStarting);
		from.setContentDisplay(ContentDisplay.BOTTOM);
		to.setGraphic(tripEnding);
		to.setContentDisplay(ContentDisplay.BOTTOM);
		destinationHBox.setSpacing(30);
		tripStarting.setMinWidth(170);
		tripStarting.setMinHeight(30);
		tripEnding.setMinWidth(170);
		tripEnding.setMinHeight(30);
		showAvilableTrips.setMinHeight(30);

		bookingTicketVBox.setAlignment(Pos.CENTER);
		chooseTripType.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20));
		choosecertainTripToBook.setAlignment(Pos.CENTER);
		enterTripCode.setPromptText("Enter trip id");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void bookingTripsTableDesign(TableColumn t, String s) {
		t.setStyle("-fx-alignment:CENTER");
		t.setCellValueFactory(new PropertyValueFactory<Trips, String>(s));
		t.setMinWidth(160);
	}
}
