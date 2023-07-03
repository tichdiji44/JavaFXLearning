package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        an.setStyle("-fx-background-color:#fff;");

        MenuBar menuBar = new MenuBar();

        Menu menu1 = new Menu("menu1", new Button("sdfsd"));
        Menu menu2 = new Menu("menu2");
        Menu menu3 = new Menu("menu3");
        Menu menu4 = new Menu("menu4");

        MenuItem item1 = new MenuItem("item1");

        item1.setAccelerator(KeyCombination.valueOf("ctrl+i"));

        MenuItem item2 = new MenuItem("item2");
        MenuItem item3 = new MenuItem("item3");
        MenuItem item4 = new MenuItem("item4");
        MenuItem item5 = new MenuItem("item5");

        menu1.getItems().addAll(item1, item2, item3);
        menu2.getItems().addAll(item4, item5);

        menuBar.getMenus().addAll(menu1, menu2, menu3, menu4);

        menu1.setOnShowing(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("menu1.setOnShowing");
            }
        });

        menu1.setOnHidden(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("menu1.setOnHidden");
            }
        });

        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("item1.setOnAction");
            }
        });

        item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("item2.setOnAction");
            }
        });

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
