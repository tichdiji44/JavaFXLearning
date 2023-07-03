package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main3 extends Application {

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

        SplitMenuButton smb = new SplitMenuButton();
        smb.setText("SplitMenuButton");

        AnchorPane.setTopAnchor(smb, 200.0);

        MenuItem item4 = new MenuItem("MenuItem4");
        MenuItem item5 = new MenuItem("MenuItem5");
        MenuItem item6 = new MenuItem("MenuItem6");

        item4.setAccelerator(KeyCombination.valueOf("ctrl+k"));

        CustomMenuItem cmi3 = new CustomMenuItem();
        HBox box = new HBox();
        box.setPrefWidth(200);
        box.setPrefHeight(200);
        box.setStyle("-fx-background-color:#ff3e96;");
        box.getChildren().addAll(new Button("b1"), new Button("b2"), new Button("b3"));
        cmi3.setContent(box);

        smb.setMinWidth(200);
        smb.setMaxWidth(200);

        smb.getItems().addAll(item4, item5, item6, cmi3);

        menuBar.getMenus().addAll(menu1, menu2, menu3);

        menu1.getItems().addAll(item1, item2, item3);

        an.getChildren().addAll(menuBar, smb);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        menuBar.setPrefWidth(an.getWidth());

        item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                smb.setText("你好");
            }
        });

        item4.setOnMenuValidation(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("item4.setOnMenuValidation");
            }
        });
    }
}
