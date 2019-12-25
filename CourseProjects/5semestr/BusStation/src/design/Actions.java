package design;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import busStation.BusStation;
import busStation.DbConnection;
import busStation.Settlements;
import busStation.Staff;
import busStation.Trips;
import busStation.Bus;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Actions extends GUIDesign {
	public static void main(String[] args) {
		try {
			Application.launch(args);
		} catch (RuntimeException ex) {
			System.out.println("Please Run the MySQL Script attached in project folder first");
		}
	}

	public void start(Stage finalStage) throws ClassNotFoundException, SQLException {

		BusStation.readDataFromDB();
		// calling parent method body
		super.start(stage);
		welcomeWindowActions();

	}

	int check = 0;

	public void welcomeWindowActions() {
		welcomeWindow();
		enter.setOnAction(e -> {
			if (chooseEmployee.isSelected()) {
				informationPageActions();
				check = 1;
			} else if (chooseCustomer.isSelected()) {
				BookTicketActions();
				check = 2;
			}
		});
	}

	// employee's account options,either driver or manager
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void informationPageActions() {
		informationPage();
		// logout of employee account
		logout.setOnAction(e -> {
			stage.setScene(scene1);
			welcomeWindowActions();
		});
		// Manager option of showing all trips in station
		showTripsManager.setOnAction(e -> {
			TableView table = new TableView();
			ObservableList<Trips> data = FXCollections.observableArrayList(BusStation.getTrip());
			TableColumn<Trips, String> idTripCol = new TableColumn<Trips, String>("Trip ID");
			tablesDesign(idTripCol, "idTrip");
			TableColumn<Trips, String> departureTimeCol = new TableColumn<Trips, String>("Departure time");
			tablesDesign(departureTimeCol, "departureTime");
			TableColumn<Trips, String> arrivalTimeCol = new TableColumn<Trips, String>("Arrival time");
			tablesDesign(arrivalTimeCol, "arrivalTime");
			TableColumn<Trips, String> distanceCol = new TableColumn<Trips, String>("Distance");
			tablesDesign(distanceCol, "distance");
			TableColumn<Trips, String> scheduleCol = new TableColumn<Trips, String>("Schedule");
			tablesDesign(scheduleCol, "schedule");
			TableColumn<Trips, String> departureStationCol = new TableColumn<Trips, String>("Departure station");
			tablesDesign(departureStationCol, "departureStation");
			TableColumn<Trips, String> idSettlementsCol = new TableColumn<Trips, String>("Settlements ID");
			tablesDesign(idSettlementsCol, "idSettlements");
			table.setItems(data);
			table.getColumns().addAll(idTripCol, departureTimeCol, arrivalTimeCol, distanceCol, scheduleCol,
					departureStationCol, idSettlementsCol);
			completeInfo.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 15));
			emplyeeInfo.setText("Trips");
			employeeBox.getChildren().clear();
			employeeBox.getChildren().addAll(emplyeeInfo, table, managerOption, logout);
		});
		// Manager option of showing all Vehicles in Station
		showVehiclesManager.setOnAction(e -> {
			TableView table = new TableView();
			ObservableList<Bus> data = FXCollections.observableArrayList(BusStation.getBus());
			TableColumn<Bus, String> licensePlateCol = new TableColumn<Bus, String>("License Plate");
			tablesDesign(licensePlateCol, "licensePlate");
			licensePlateCol.setMinWidth(220);
			TableColumn<Bus, String> IdCarrierCol = new TableColumn<Bus, String>("Carrier ID");
			tablesDesign(IdCarrierCol, "idCarrier");
			IdCarrierCol.setMinWidth(220);
			TableColumn<Bus, String> modelCol = new TableColumn<Bus, String>("Model");
			tablesDesign(modelCol, "model");
			modelCol.setMinWidth(220);
			TableColumn<Bus, String> amountOfSitsCol = new TableColumn<Bus, String>("Amount of sits");
			tablesDesign(amountOfSitsCol, "amountOfSits");
			amountOfSitsCol.setMinWidth(220);
			TableColumn<Bus, String> markCol = new TableColumn<Bus, String>("Mark");
			tablesDesign(markCol, "mark");
			markCol.setMinWidth(220);
			TableColumn<Bus, String> registryNumberCol = new TableColumn<Bus, String>("Registry number");
			tablesDesign(registryNumberCol, "registryNumber");
			registryNumberCol.setMinWidth(220);
			table.setItems(data);
			table.getColumns().addAll(licensePlateCol, IdCarrierCol, modelCol, amountOfSitsCol, markCol,
					registryNumberCol);
			completeInfo.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 18));
			emplyeeInfo.setText("Bus");
			employeeBox.getChildren().clear();
			employeeBox.getChildren().addAll(emplyeeInfo, table, managerOption, logout);
		});
		// Manager Option of showing all Employees
		showEmployeesManager.setOnAction(e -> {
			TableView table = new TableView();
			ObservableList<Staff> data = FXCollections.observableArrayList(BusStation.getStaff());
			TableColumn<Staff, String> idStaffCol = new TableColumn<Staff, String>("Staff ID");
			tablesDesign(idStaffCol, "idStaff");
			idStaffCol.setMinWidth(130);
			TableColumn<Staff, String> surnameCol = new TableColumn<Staff, String>("Surname");
			tablesDesign(surnameCol, "surname");
			surnameCol.setMinWidth(130);
			TableColumn<Staff, String> nameCol = new TableColumn<Staff, String>("Name");
			tablesDesign(nameCol, "name");
			nameCol.setMinWidth(130);
			TableColumn<Staff, String> patronymicCol = new TableColumn<Staff, String>("Patronymic");
			tablesDesign(patronymicCol, "patronymic");
			patronymicCol.setMinWidth(130);
			TableColumn<Staff, String> cityCol = new TableColumn<Staff, String>("City");
			tablesDesign(cityCol, "city");
			cityCol.setMinWidth(130);
			TableColumn<Staff, String> streetCol = new TableColumn<Staff, String>("Street");
			tablesDesign(streetCol, "street");
			streetCol.setMinWidth(130);
			TableColumn<Staff, String> houseNumberCol = new TableColumn<Staff, String>("House number");
			tablesDesign(houseNumberCol, "houseNumber");
			houseNumberCol.setMinWidth(130);

			TableColumn<Staff, String> apartmentCol = new TableColumn<Staff, String>("Apartment");
			tablesDesign(apartmentCol, "apartment");
			apartmentCol.setMinWidth(130);

			TableColumn<Staff, String> postCol = new TableColumn<Staff, String>("Post");
			tablesDesign(postCol, "post");
			postCol.setMinWidth(130);

			TableColumn<Staff, String> phoneCol = new TableColumn<Staff, String>("Phone");
			tablesDesign(phoneCol, "phone");
			phoneCol.setMinWidth(130);

			TableColumn<Staff, String> expirienceCol = new TableColumn<Staff, String>("Expirience");
			tablesDesign(expirienceCol, "expirience");
			expirienceCol.setMinWidth(130);
			table.setItems(data);
			table.getColumns().addAll(idStaffCol, surnameCol, nameCol, patronymicCol, cityCol, streetCol,
					houseNumberCol, apartmentCol, postCol, phoneCol, expirienceCol);
			completeInfo.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 16));
			emplyeeInfo.setText("Staff");
			employeeBox.getChildren().clear();
			employeeBox.getChildren().addAll(emplyeeInfo, table, managerOption, logout);
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public void BookTicketActions() {

		customerBookTicket();
		tripStarting.setValue("from");
		tripStarting.getItems().clear();
		tripEnding.getItems().clear();
		tripStarting.getItems().addAll("Sevastopol");
		tripEnding.getItems().addAll("Moscow", "Krasnodar", "Saint-Petersbourg");
		ArrayList<Trips> choosenTrips = new ArrayList<Trips>();
		showAvilableTrips.setOnAction(e -> {
			if (!tripStarting.getValue().equals("from") && !tripEnding.getValue().equals("To")
					&& tripStarting.getValue() != tripEnding.getValue() && !tripStarting.getValue().isEmpty()
					&& !tripEnding.getValue().isEmpty()) {
				try {
					String ss = "select * from trip,settlements where trip.departure_station=? and settlements.city=? and trip.id_settlements=settlements.id_settlements";
					BusStation.con = DbConnection.connectToDB();
					PreparedStatement ps = BusStation.con.prepareStatement(ss);
					ps.setString(1, tripStarting.getValue());
					ps.setString(2, tripEnding.getValue());
					BusStation.rs = ps.executeQuery();

					String trips = "";
					while (BusStation.rs.next()) {
						for (int i = 0; i < BusStation.getTrip().size(); i++) {
							if (BusStation.getTrip().get(i).getIdTrip() == BusStation.rs.getInt(1)) {
								choosenTrips.add(BusStation.getTrip().get(i));
								break;
							}
						}
					}
					if (choosenTrips.size() != 0) {
						TableView table = new TableView();
						table.setMaxHeight(170);
						ObservableList<Trips> data = FXCollections.observableArrayList(choosenTrips);
						TableColumn<Trips, String> idTrip = new TableColumn<Trips, String>("Trip ID");
						bookingTripsTableDesign(idTrip, "idTrip");
						TableColumn<Trips, String> departureTime = new TableColumn<Trips, String>("Time");
						bookingTripsTableDesign(departureTime, "departureTime");
						table.setItems(data);
						table.getColumns().addAll(idTrip, departureTime);
						bookingTicketVBox.getChildren().clear();
						bookingTicketVBox.getChildren().addAll(table, choosecertainTripToBook, backToBockNewTickets,
								logout);

					} else {
						tripStarting.setValue("");
						tripEnding.setValue("");
					}
				} catch (Exception e1) {
				}
			} else {
				tripStarting.setValue("");
				tripEnding.setValue("");
			}
		});
		doneEnterTripCode.setOnAction(e -> {
			for (int i = 0; i < choosenTrips.size(); i++) {
				try {
					if (choosenTrips.get(i).getIdTrip() == Integer.parseInt(enterTripCode.getText())) {
						ArrayList<Settlements> set = new ArrayList<Settlements>();
						set = BusStation.getSettlement();
						String citySetl = null;
						for (Settlements s : set) {
							if(s.getIdSettlements() == choosenTrips.get(i).getIdSettlements()) {
								citySetl = s.getCity();
							}
						}
						
						bookingDone.setText("Done You Booked " + numberOfTickets.getText() + " Tickets " + " From "
								+ choosenTrips.get(i).getDepartureStation() + " To "
								+ citySetl + " at "
								+ choosenTrips.get(i).getDepartureTime());
						enterTripCode.clear();
						numberOfTickets.clear();
						bookingTicketVBox.getChildren().add(bookingDone);
						break;

					} else {
						bookingDone.setText("");
					}
				} catch (Exception ex) {
					enterTripCode.clear();
					numberOfTickets.clear();
				}
			}
			enterTripCode.clear();
			numberOfTickets.clear();
		});
		backToBockNewTickets.setOnAction(e ->

		{
			choosenTrips.clear();
			customerBookTicket();
		});
	}

}
