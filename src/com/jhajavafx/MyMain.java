package com.jhajavafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class MyMain extends Application {
	public static void main(String[] args){
		launch(args);

	}

	@Override
	public void init() throws Exception {
		super.init();
		System.out.println("init");//initialize the app
	}

	@Override
	public void start(Stage primaryStage) throws Exception {//mandatory step
		System.out.println("start the app");
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));/*app_layout.fxml--
				 we connect main java to layout java that is creating link between logical
				 code and fxml file*/
		VBox rootNode = loader.load();// is a method that loads the root node present in layout// (pane)
      MenuBar menuBar= createMenu();
      rootNode.getChildren().add(0,menuBar);//adds menubar within vBox
		Scene scene = new Scene(rootNode);//sets scene

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");//giving title to the stage
		primaryStage.show();//very imp as it shows the display


	}
		private MenuBar createMenu() {
			//file menu
			Menu fileMenu = new Menu("File");
			MenuItem newMenuItem=new MenuItem("New");
			newMenuItem.setOnAction(event -> System.out.println("New File added"));


			SeparatorMenuItem separator=new SeparatorMenuItem();

			MenuItem quitMenuItem=new MenuItem("Quit");


			quitMenuItem.setOnAction(event -> {
				Platform.exit();
				System.exit(0);
			});
					fileMenu.getItems().addAll(newMenuItem, separator, quitMenuItem);


			Menu helpMenu = new Menu("Help");
			MenuItem aboutApp=new MenuItem("About App");

			aboutApp.setOnAction(event -> {
				aboutApp();
			});

			MenuItem aboutDeveloper=new MenuItem("About Developer");

			aboutDeveloper.setOnAction(event -> {
				aboutDeveloper();
					});

			helpMenu.getItems().addAll(aboutApp,aboutDeveloper);
			MenuBar menuBar = new MenuBar();
			menuBar.getMenus().addAll(fileMenu, helpMenu);
			return menuBar;
		}

	public void aboutApp() {

    Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
    alertDialog.setTitle("About");
    alertDialog.setHeaderText("App created using javaFx");
    alertDialog.setContentText("This is my first java game");

    ButtonType yesbtn=new ButtonType("Yes");
    ButtonType nobtn=new ButtonType("No");

    alertDialog.getButtonTypes().setAll(yesbtn,nobtn);

    Optional<ButtonType> clickedBtn=alertDialog.showAndWait();

    if(clickedBtn.isPresent() && clickedBtn.get() == yesbtn) {
	    System.out.println("Yes button Clicked !!");
    }

    else    {
			System.out.println("No Button clicked !!");
		}

	}

	public void aboutDeveloper() {

	Alert alertBox=new Alert(Alert.AlertType.INFORMATION);
	alertBox.setTitle("Developer");
	alertBox.setHeaderText("Name");
	alertBox.setContentText(" Nitu Jha, Pune");

		ButtonType yesbot=new ButtonType("Cool");
		ButtonType nobot=new ButtonType("Not Cool");

		alertBox.getButtonTypes().setAll(yesbot,nobot);

	 Optional<ButtonType>clickedbot =alertBox.showAndWait();

		if(clickedbot.isPresent() && clickedbot.get() == yesbot) {
			System.out.println("Okay :( !!");
		}

		else {
			System.out.println("Sad:( !!");
		}




	}

	@Override
	public void stop() throws Exception {
		super.stop();
		System.out.println("stop");//called when app is closed
	}
}

