package fx.com;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("Button1");
        Button b2 = new Button("Button2");
        Button b3 = new Button("Button3");
        Button b4 = new Button("Button4");
        Button b5 = new Button("Button5");
        Button b6 = new Button("Button6");
        Button b7 = new Button("Button7");

        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color:#aeeeee;");
        HBox box = new HBox();
        box.setPrefWidth(400);
        box.setPrefHeight(400);

        box.setPadding(new Insets(10));

        box.setSpacing(10);

        HBox.setMargin(b1, new Insets(10));

        // box.setAlignment(Pos.BOTTOM_CENTER);
        box.setAlignment(Pos.CENTER);

        box.getChildren().addAll(b1, b2, b3);

        box.setStyle("-fx-background-color:#e066ff;");

        ap.getChildren().add(box);

        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

}
