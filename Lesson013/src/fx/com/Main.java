package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("Button1");
        b1.setLayoutX(10);
        b1.setLayoutY(10);
        Button b2 = new Button("Button2");
        Button b3 = new Button("Button3");
        Button b4 = new Button("Button4");

        AnchorPane ap = new AnchorPane();
        Group g1 = new Group();
        Group g2 = new Group();
        g1.getChildren().addAll(b1, b2);
        g2.getChildren().addAll(b3, b4);

        // ap.setPadding(new Insets(10));
        // AnchorPane.setTopAnchor(b1, 0.0);
        // AnchorPane.setLeftAnchor(b1, 0.0);
        // AnchorPane.setRightAnchor(b1, 10.0);
        // AnchorPane.setBottomAnchor(b1, 10.0);

        // AnchorPane.setTopAnchor(b2, 100.0);
        // AnchorPane.setLeftAnchor(b2, 100.0);

        AnchorPane.setTopAnchor(g1, 100.0);
        AnchorPane.setLeftAnchor(g1, 100.0);
        AnchorPane.setTopAnchor(g2, 200.0);
        AnchorPane.setLeftAnchor(g2, 200.0);

        ap.getChildren().addAll(g1, g2);

        ap.setStyle("-fx-background-color: #ff3e96;");

        // Group root = new Group();
        // root.setStyle("-fx-background-color:#FF3E96;");
        // root.setOnMouseClicked(new EventHandler<MouseEvent>() {
        //     @Override
        //     public void handle(MouseEvent event) {
        //         System.out.println("setOnMouseClicked()");
        //     }
        // });
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

}