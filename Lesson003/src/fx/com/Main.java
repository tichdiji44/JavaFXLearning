package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX");

        primaryStage.getIcons().add(new Image("/icon/icon.jpg"));

        // primaryStage.setIconified(true); // 设置最小化

        // primaryStage.setMaximized(true); // 设置最大化

        // primaryStage.close(); // 关闭窗口

        // primaryStage.setResizable(false); // 设置不可改变窗口大小

        primaryStage.setWidth(600);
        primaryStage.setHeight(600);

        // primaryStage.setMaxHeight(800);
        // primaryStage.setMaxWidth(800);

        // primaryStage.setMinHeight(300);
        // primaryStage.setMinWidth(300);

        // 未设置宽和高，如果想要获取宽度和高度，需要在primaryStage.show()方法之后
        // System.out.println("宽度 = " + primaryStage.getWidth());
        // System.out.println("高度 = " + primaryStage.getHeight());

        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("当前高度 = " + newValue.doubleValue());
            }
        });

        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("当前宽度 = " + newValue.doubleValue());
            }
        });

        // primaryStage.setFullScreen(true); // 设置全屏，必须设置Scene

        primaryStage.setScene(new Scene(new Group()));

        primaryStage.show();


    }

}
