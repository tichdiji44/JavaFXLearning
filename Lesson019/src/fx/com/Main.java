package fx.com;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.function.Consumer;

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

        StackPane stack = new StackPane();
        stack.setStyle("-fx-background-color:#ee6aa7;");

        stack.setPadding(new Insets(10));

        stack.setAlignment(Pos.BOTTOM_LEFT);

        StackPane.setMargin(b1, new Insets(100));

        stack.getChildren().addAll(b1, b2, b3, b4, b5);

        stack.getChildren().forEach(new Consumer<Node>() {
            @Override
            public void accept(Node node) {
                Button bu = (Button) node;
                System.out.println(bu.getText());
            }
        });

        Scene scene = new Scene(stack);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
