package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

        MenuBar menuBar = new MenuBar();

        Menu menu1 = new Menu("menu1");
        Menu menu2 = new Menu("menu2");
        Menu menu3 = new Menu("menu3");

        MenuItem item1 = new MenuItem("MenuItem1");
        MenuItem item2 = new MenuItem("MenuItem2");
        MenuItem item3 = new MenuItem("MenuItem3");

        CustomMenuItem cmi1 = new CustomMenuItem();
        Button button = new Button("button");
        cmi1.setContent(button);

        CustomMenuItem cmi2 = new CustomMenuItem();
        ProgressBar bar = new ProgressBar(0.5);
        cmi2.setContent(bar);

        CustomMenuItem cmi3 = new CustomMenuItem();
        HBox box = new HBox();
        box.setPrefWidth(200);
        box.setPrefHeight(200);
        box.setStyle("-fx-background-color:#ff3e96;");
        box.getChildren().addAll(new Button("b1"), new Button("b2"), new Button("b3"));
        cmi3.setContent(box);

        menuBar.getMenus().addAll(menu1, menu2, menu3);

        menu1.getItems().addAll(item1, item2, item3, cmi1, cmi2, cmi3);

        an.getChildren().add(menuBar);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        menuBar.setPrefWidth(an.getWidth());

        an.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                menuBar.setPrefWidth(newValue.doubleValue());
            }
        });
    }
}
