package fx.com;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("button1");
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");
        Button b5 = new Button("button5");
        Button b6 = new Button("button6");
        Button b7 = new Button("button7");

        FlowPane flow = new FlowPane();
        flow.setStyle("-fx-background-color:#ee6aa7;");

        flow.setPadding(new Insets(10));

        // FlowPane.setMargin(b1, new Insets(10));

        flow.setAlignment(Pos.CENTER);

        flow.setHgap(10);
        flow.setVgap(10);

        flow.setOrientation(Orientation.VERTICAL);

        flow.getChildren().addAll(b1, b2, b3, b4, b5, b6, b7);

        Scene scene = new Scene(flow);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
