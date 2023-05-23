package fx.com;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HostServices host = getHostServices();
        host.showDocument("www.baidu.com"); // 使用默认浏览器打开

        URL url = getClass().getClassLoader().getResource("icon/icon.jpg");
        String path = url.toExternalForm();

        Button button = new Button("按钮");
        button.setCursor(Cursor.MOVE); // 移动光标
        button.setPrefWidth(200);
        button.setPrefHeight(200);

        Group group = new Group();
        group.getChildren().add(button);

        Scene scene = new Scene(group);
        // scene.setCursor(Cursor.HAND); // 手
        // scene.setCursor(Cursor.E_RESIZE); // 横向箭头
        // scene.setCursor(Cursor.CLOSED_HAND); // 合上的手
        scene.setCursor(Cursor.cursor(path)); // 自定义图片光标

        primaryStage.setScene(scene);

        primaryStage.setTitle("javafx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
