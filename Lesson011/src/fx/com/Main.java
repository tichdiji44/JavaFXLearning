package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.*;
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
        b1.setPrefWidth(200);
        b1.setPrefHeight(200);
        b1.setFont(Font.font(20));

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("setOnAction");
            }
        });

        Group root = new Group();
        root.getChildren().add(b1);
        Scene scene = new Scene(root);

        // 第一种
        KeyCodeCombination kc1 = new KeyCodeCombination(KeyCode.C, KeyCombination.ALT_DOWN, KeyCombination.CONTROL_DOWN);
        Mnemonic mnemonic1 = new Mnemonic(b1, kc1);
        scene.addMnemonic(mnemonic1);

        // 第二种
        KeyCodeCombination kc2 = new KeyCodeCombination(KeyCode.valueOf("D"), KeyCombination.ALT_DOWN);
        Mnemonic mnemonic2 = new Mnemonic(b1, kc2);
        scene.addMnemonic(mnemonic2);

        // 第三种
        KeyCodeCombination kc3 = new KeyCodeCombination(KeyCode.K, KeyCombination.SHIFT_DOWN, KeyCombination.CONTROL_ANY, KeyCombination.META_DOWN, KeyCombination.SHORTCUT_DOWN);
        Mnemonic mnemonic3 = new Mnemonic(b1, kc3);
        scene.addMnemonic(mnemonic3);

        // 第四种
        KeyCodeCombination kccb = new KeyCodeCombination(KeyCode.Y, KeyCombination.SHORTCUT_DOWN);
        scene.getAccelerators().put(kccb, new Runnable() {
            @Override
            public void run() {
                System.out.println("run()方法");

                b1.fire();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }

    public static void play() {
        System.out.println("play()");
    }

}
