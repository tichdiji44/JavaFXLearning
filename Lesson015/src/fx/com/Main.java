package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
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
        Button b1 = new Button("Button1");
        Button b2 = new Button("Button2");
        Button b3 = new Button("Button3");
        Button b4 = new Button("Button4");

        Button b5 = new Button("b3.setManaged(false)");
        Button b6 = new Button("b3.setVisible(false)");
        Button b7 = new Button("b3.setOpacity(0)");

        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color:#ffffff;");
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(b1, b2, b3, b4);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(b5, b6, b7);

        AnchorPane.setTopAnchor(vBox, 100.0);
        AnchorPane.setLeftAnchor(vBox, 20.0);

        ap.getChildren().addAll(hBox, vBox);

        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

        b5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                b3.setManaged(isManaged);
                new Print(hBox);
                isManaged = !isManaged;
                b5.setText("b3.setManaged(" + isManaged + ")");
            }
        });

        b6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                b3.setVisible(isVisible);
                new Print(hBox);
                isVisible = !isVisible;
                b6.setText("b3.setVisible(" + isVisible + ")");
            }
        });

        b7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                b3.setOpacity(opacityValue);
                new Print(hBox);
                if (opacityValue == 0) {
                    opacityValue = 100;
                    b7.setText("b3.setOpacity(" + opacityValue + ")");
                } else {
                    opacityValue = 0;
                    b7.setText("b3.setOpacity(" + opacityValue + ")");
                }
            }
        });
    }
}

class Print {
    Print(HBox hBox) {
        System.out.println("当前HBox里子组件的数量 = " + hBox.getChildren().size());
    }
}
