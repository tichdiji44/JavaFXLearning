package fx.com;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label l_name = new Label("账号：");
        l_name.setFont(Font.font(14));
        Label l_password = new Label("密码：");
        l_password.setFont(Font.font(14));

        TextField t_name = new TextField();
        t_name.setTooltip(new Tooltip("请输入用户名"));

        PasswordField p_password = new PasswordField();
        p_password.setTooltip(new Tooltip("请输入密码"));

        t_name.setUserData("hello");
        p_password.setUserData(12345);

        System.out.println();

        Button login = new Button("登录");
        Button clear = new Button("清除");

        GridPane gr = new GridPane();
        gr.setStyle("-fx-background-color:#fff0f5;");

        gr.add(l_name, 0, 0);
        gr.add(t_name, 1, 0);
        gr.add(l_password, 0, 1);
        gr.add(p_password, 1, 1);

        gr.add(clear, 0, 2);
        gr.add(login, 1, 2);

        gr.setHgap(5);
        gr.setVgap(15);

        GridPane.setMargin(login, new Insets(0, 0, 0, 120));
        gr.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gr);
        primaryStage.setScene(scene);
        primaryStage.setTitle("登录");
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setResizable(false);
        primaryStage.show();

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t_name.setText("");
                p_password.setText("");
            }
        });

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = (String) t_name.getUserData();
                int password = (int) p_password.getUserData();

                if (name.equals(t_name.getText()) && password == Integer.parseInt(p_password.getText())) {
                    System.out.println("登陆成功");
                    MyWindow window = new MyWindow(name, String.valueOf(password));
                } else {
                    System.out.println("登录失败");
                    l_name.setTextFill(Color.RED);
                    l_password.setTextFill(Color.RED);
                    primaryStage.setTitle("账号或者密码错误");
                    FadeTransition fade = new FadeTransition();
                    fade.setDuration(Duration.seconds(0.1));
                    fade.setNode(gr);
                    fade.setFromValue(0);
                    fade.setToValue(1);
                    fade.play();
                }
            }
        });
    }
}

class MyWindow {
    private final Stage stage = new Stage();

    public MyWindow(String name, String password) {
        Text text = new Text("账号：" + name + " " + "密码：" + password);


        BorderPane bor = new BorderPane();
        bor.setStyle("-fx-background-color:#ffc0cb;");
        bor.setCenter(text);

        Scene scene = new Scene(bor);
        stage.setScene(scene);
        stage.setTitle("登陆成功");
        stage.setHeight(500);
        stage.setWidth(500);
        stage.show();
    }
}