package fx.com;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();

        Button button = new Button("button");
        an.getChildren().addAll(button);

        ContextMenu cm = new ContextMenu();

        MenuItem item1 = new MenuItem("MenuItem1");
        MenuItem item2 = new MenuItem("MenuItem2");
        MenuItem item3 = new MenuItem("MenuItem3");

        cm.getItems().addAll(item1, item2, item3);

        button.setContextMenu(cm);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        button.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                Button bu = (Button) event.getSource();
                System.out.println(bu.getText());
            }
        });
    }
}
