package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        an.setStyle("-fx-background-color: #ffffff");

        HBox box = new HBox();

        ToggleGroup tg = new ToggleGroup();
        RadioButton r1 = new RadioButton("r1");
        RadioButton r2 = new RadioButton("r2");
        RadioButton r3 = new RadioButton("r3");
        RadioButton r4 = new RadioButton("r4");

        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);
        r3.setToggleGroup(tg);
        r4.setToggleGroup(tg);

        // r2.setSelected(true);

        tg.selectToggle(r3);

        box.getChildren().addAll(r1, r2, r3, r4);

        AnchorPane.setTopAnchor(box, 100.0);
        AnchorPane.setLeftAnchor(box, 100.0);

        an.getChildren().add(box);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        r1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // System.out.println(newValue);
            }
        });

        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton r = (RadioButton) newValue;
                System.out.println(r.getText() + " - " + r.isSelected());
            }
        });
    }
}
