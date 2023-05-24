package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    static boolean isManaged = false;
    static boolean isVisible = false;
    static double opacityValue = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b = new Button("Button");

        AnchorPane a1 = new AnchorPane();
        a1.setPrefHeight(100);
        a1.setPrefWidth(100);
        a1.setStyle("-fx-background-color:#ee6aa7;");
        AnchorPane a2 = new AnchorPane();
        a2.setPrefHeight(100);
        a2.setPrefWidth(100);
        a2.setStyle("-fx-background-color:#98fb98;");
        AnchorPane a3 = new AnchorPane();
        a3.setPrefHeight(100);
        a3.setPrefWidth(100);
        a3.setStyle("-fx-background-color:#a0522d;");
        AnchorPane a4 = new AnchorPane();
        a4.setPrefHeight(100);
        a4.setPrefWidth(100);
        a4.setStyle("-fx-background-color:#1e90ff;");
        AnchorPane a5 = new AnchorPane();
        a5.setPrefHeight(100);
        a5.setPrefWidth(100);
        a5.setStyle("-fx-background-color:#eeee00;");


        BorderPane bor = new BorderPane();
        bor.setStyle("-fx-background-color:#b23aef;");

        bor.setTop(a1);
        bor.setBottom(a2);
        bor.setLeft(a3);
        bor.setRight(a4);
        bor.setCenter(a5);

        // bor.setPadding(new Insets(10));

        // BorderPane.setMargin(a1, new Insets(10));

        // BorderPane.setAlignment(b, Pos.BOTTOM_LEFT);

        // Button bu = (Button) bor.getTop();

        // System.out.println(bu.getText());

        Scene scene = new Scene(bor);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}

class Print {
    Print(HBox hBox) {
        System.out.println("当前HBox里子组件的数量 = " + hBox.getChildren().size());
    }
}
