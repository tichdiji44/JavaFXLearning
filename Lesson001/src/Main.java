import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("hello world");

        primaryStage.setTitle("这是第一个javafx程序");
        primaryStage.show();
    }
}
