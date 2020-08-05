package com.jhajavafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import sun.font.TextLabel;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public javafx.scene.control.Label welcomeLabel;

	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public javafx.scene.control.TextField textField;

	@FXML
	public Button convertButton;

	private static final String C_TO_F_TEXT= "Celsius to Fahrenheit";
	private static final String F_TO_C_TEXT= "Fahrenheit to CeLcius";

	private boolean isC_TO_F= true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choiceBox.getItems().add(C_TO_F_TEXT);
		choiceBox.getItems().add(F_TO_C_TEXT);
		choiceBox.setValue(C_TO_F_TEXT);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			System.out.println(newValue);

			if(newValue.equals(C_TO_F_TEXT)) {
				isC_TO_F=true;

			}else {
				isC_TO_F=false;
			}

		   });

		convertButton.setOnAction(event -> {
			convert();
		});


	}

	private void convert() {

		String input = textField.getText();

		try {
			float enteredTemperature = Float.parseFloat(input);
		} catch (Exception exception) {
			warnUser();
			return;
		}

		float enteredTemperature = Float.parseFloat(input);

		float newtemperature=0.0f;
		if(isC_TO_F) {    //if user has selcted C TO F do this
			newtemperature= (enteredTemperature * 9/5) + 32;
		} else {          //is user selects f to c
			newtemperature= (enteredTemperature-32) * 5/9;
		}

		display(newtemperature);
	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setHeaderText("Invalid temperature entered");
		alert.setContentText("Please enter a valid temperature");
		alert.show();


	}

	private void display(float newtemperature) {

		String unit = isC_TO_F? "F":"C";

		System.out.println("The new Temperature is "+newtemperature+ unit);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The converted Temperarture is "+newtemperature+ unit);
		alert.show();

	}
}
