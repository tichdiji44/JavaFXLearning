package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
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

        Accordion acc = new Accordion();

        TitledPane tp1 = new TitledPane("TitledPane", new Button("Button1"));

        TitledPane tp2 = new TitledPane();
        tp2.setText("TitledPane2");
        tp2.setContent(new Button("Button2"));

        TitledPane tp3 = new TitledPane();

        tp3.setText("TitledPane3");
        HBox box = new HBox();
        box.setStyle("-fx-background-color:#ffb5c5;");
        box.getChildren().addAll(new Button("button3"), new Button("button4"), new Button("button5"));

        tp3.setContent(box);

        tp3.setGraphic(new Button("sdfad"));

        tp3.setNodeOrientation(NodeOrientation.INHERIT);

        AnchorPane.setTopAnchor(tp2, 200.0);
        AnchorPane.setTopAnchor(tp3, 100.0);

        an.getChildren().addAll(tp1, tp2, tp3);

        // tp1.setAnimated(false);

        // tp1.setCollapsible(false);

        tp1.setExpanded(false);

        acc.getPanes().addAll(tp1, tp2, tp3);

        Scene scene = new Scene(acc);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        tp1.expandedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        acc.expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {
            @Override
            public void changed(ObservableValue<? extends TitledPane> observable, TitledPane oldValue, TitledPane newValue) {
                if (newValue == null) {
                    System.out.println(oldValue.getText() + "折叠");
                    return;
                }
                System.out.println(newValue.getText() + "展开");
            }
        });
    }
}
