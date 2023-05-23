package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("Button1");
        Button b2 = new Button("Button2");
        Button b3 = new Button("Button3");
        Button b4 = new Button("Button4");

        AnchorPane ap = new AnchorPane();
        AnchorPane ap2 = new AnchorPane();
        ap2.setStyle("-fx-background-color:#9bcd9b;");
        ap.setStyle("-fx-background-color:#ff3e96;");

        // b1.setManaged(false);
        // b1.setVisible();
        // b1.setOpacity();

        ap2.getChildren().add(b1);
        AnchorPane.setRightAnchor(b1, 0.0);
        AnchorPane.setBottomAnchor(b1, 0.0);

        ap.getChildren().add(ap2);
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        AnchorPane.setTopAnchor(ap2, 0.0);
        AnchorPane.setLeftAnchor(ap2, 0.0);
        AnchorPane.setRightAnchor(ap2, ap.getWidth() / 2);
        AnchorPane.setBottomAnchor(ap2, ap.getHeight() / 2);
        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                AnchorPane.setBottomAnchor(ap2, ap.getHeight() / 2);
            }
        });

        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                AnchorPane.setRightAnchor(ap2, ap.getWidth() / 2);
            }
        });
    }
}
