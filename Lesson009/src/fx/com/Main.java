package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button();
        b1.setText("这是按钮");
        b1.setLayoutX(100);
        b1.setLayoutY(100);
        b1.setPrefWidth(400);
        b1.setPrefHeight(200);
        b1.setFont(Font.font(40));
        b1.setTextFill(Paint.valueOf("#CD0000"));

        Button b2 = new Button("b2");
        b2.setLayoutX(100);
        b2.setLayoutY(100);
        b2.setPrefHeight(100);
        b2.setPrefWidth(100);

        // BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#8FBC8F55"), new CornerRadii(20), new Insets(10, 5, 20, 5));
        // Background bg = new Background(bgf);
        // b1.setBackground(bg);
        //
        // BorderStroke bos = new BorderStroke(Paint.valueOf("#8A2BE2"), BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(5), Insets.EMPTY);
        // Border bo = new Border(bos);
        // b1.setBorder(bo);

        b1.setStyle("-fx-background-color: #7CCD7C;" +
                "-fx-background-radius: 20;" +
                "-fx-text-fill: #5cacee;");

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button bu = (Button) event.getSource();
                System.out.println("b1的文本是 = " + bu.getText());
            }
        });

        Group root = new Group();
        // root.getChildren().add(b2);
        root.getChildren().add(b1);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
