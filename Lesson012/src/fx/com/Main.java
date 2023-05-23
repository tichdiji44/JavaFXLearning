package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
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
        Group root = new Group();

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);

        Label label = new Label("我是标签：");
        label.setLayoutX(10);
        label.setLayoutY(100);
        label.setFont(Font.font(14));

        PasswordField ptext = new PasswordField();
        ptext.setLayoutX(300);
        ptext.setLayoutY(100);
        ptext.setFont(Font.font(14));

        TextField text = new TextField();
        // text.setText("这是文本");
        text.setLayoutX(100);
        text.setLayoutY(100);
        // text.setPrefWidth(100);
        // text.setPrefHeight(100);
        text.setFont(Font.font(14));

        Tooltip tip = new Tooltip("这是提示");
        tip.setFont(Font.font(40));
        text.setTooltip(tip);
        text.setPromptText("请输入7个字以下");
        text.setFocusTraversable(false);

        ptext.setVisible(true);

        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 7) {
                    text.setText(oldValue);
                }
            }
        });

        text.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });

        // 不可用
        // text.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override
        //     public void handle(ActionEvent event) {
        //         System.out.println("setOnAction()");
        //     }
        // });

        text.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("setOnMouseClicked()");
            }
        });

        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2 && event.getButton().name().equals(MouseButton.PRIMARY.name())) {
                    System.out.println("if里面当前鼠标按键 = " + event.getButton().name());
                    System.out.println("双击事件");
                }
            }
        });

        // text.focusedProperty().addListener(new ChangeListener<Boolean>() {
        //     @Override
        //     public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        //         System.out.println("focus()");
        //     }
        // });

        root.getChildren().add(text);
        root.getChildren().add(ptext);
        root.getChildren().add(label);

        primaryStage.show();
    }

}