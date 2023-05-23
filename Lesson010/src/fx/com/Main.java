package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("b1");
        b1.setLayoutX(100);
        b1.setLayoutY(100);
        b1.setPrefWidth(400);
        b1.setPrefHeight(200);
        b1.setFont(Font.font(40));

        /*b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("b1的单击事件");
            }
        });*/

        b1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("当前鼠标按键 = " + event.getButton().name());
                if (event.getClickCount() == 2 && event.getButton().name().equals(MouseButton.PRIMARY.name())) {
                    System.out.println("多击事件");
                }
            }
        });

        b1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // System.out.println("按下 = " + event.getCode());
                // System.out.println("按下 = " + event.getCode().name());
                // System.out.println("按下 = " + event.getCode().getName());
                if (event.getCode().getName() == KeyCode.A.getName()) {
                    System.out.println("按下 = " + event.getCode().getName());
                }
            }
        });

        // b1.setOnKeyReleased(new EventHandler<KeyEvent>() {
        //     @Override
        //     public void handle(KeyEvent event) {
        //         System.out.println("释放 = " + event.getCode());
        //         System.out.println("释放 = " + event.getCode().name());
        //         System.out.println("释放 = " + event.getCode().getName());
        //     }
        // });

        Group root = new Group();
        root.getChildren().add(b1);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
