package fx.com;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                System.out.println("run方法里面的线程名字 = " + Thread.currentThread().getName());
                ;
                int i = 1;
                while (i <= 10) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("i = " + i);

                    i = i + 1;
                }
            }
        });

        System.out.println("runLater下面");
    }
}
