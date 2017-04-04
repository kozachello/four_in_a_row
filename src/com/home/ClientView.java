package com.home;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Козак on 04.04.2017.
 */

public class ClientView extends Application {

    // programmet skifter ikke automatisk mellem server og client på nuværende tidspunkt......
    private boolean isClient = true;
    private ConnectionControl connection = isClient ? createClient() : null;
    private GamePlayer player;
    //private ConnectionControl connection;

    private Parent createContent() {

        //MainChat mainChat = new MainChat();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        Text scenetitle = new Text("Type Your Nickname & Start The Game");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 20));
        grid.add(scenetitle, 0, 0, 3, 1);

        Label userName = new Label("Nickname:");
        grid.add(userName, 0, 1);

        TextField userBox = new TextField();
        grid.add(userBox, 1, 1);

        Button button = new Button("Start");
        button.setAlignment(Pos.BASELINE_CENTER);
        button.setOnAction(event -> {
            // some action here...
            //Client client = ClientView.createClient();
            //user = new ChatUser(userBox.getText());
            System.out.println(player);
            if(player.usernameIsNotNull()) {
                //Thread t = connection.getConnThread();
                //connection = isClient ? createClient() : null;
                //mainChat.setUserName(userBox.getText(), false);
                try {
                    //t.interrupt();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    //mainChat.start(new Stage());
                    // must connect to the socket..
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.getChildren().add(button);
        grid.add(hbox, 1, 4);

        //Scene scene = new Scene(grid, 400, 300);
        return grid;
    }

    @Override
    public void init() throws Exception {
        connection.startConnection();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Thread t = connection.getConnThread();
        primaryStage.setTitle("StartWindow");
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        connection.closeConnection();
    }

    private Client createClient() {
        return new Client("localhost", 19000, data -> {
            Platform.runLater(() -> {
                player.getUsername();
            });
        });

    }

    private boolean clientIsCreated() {
        return true;
    }

    public static void main(String args[]) {
        //Locale locale = Locale.getDefault(); // не уверен что понадобится
        launch(args);
    }
}