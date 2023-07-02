package fx.com;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("点击显示窗口");

        AnchorPane an = new AnchorPane();
        an.setStyle("-fx-background-color:#ffffff;");

        AnchorPane.setTopAnchor(button, 100.0);
        AnchorPane.setLeftAnchor(button, 100.0);

        an.getChildren().add(button);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DialogPane dialogPane = new DialogPane();

                dialogPane.setHeaderText("HeaderText");
                dialogPane.setContentText("ContentText");

                dialogPane.getButtonTypes().add(ButtonType.APPLY);
                dialogPane.getButtonTypes().add(ButtonType.CLOSE);
                dialogPane.getButtonTypes().add(ButtonType.PREVIOUS);

                Button apply = (Button) dialogPane.lookupButton(ButtonType.APPLY);
                Button close = (Button) dialogPane.lookupButton(ButtonType.CLOSE);

                ImageView im = new ImageView("icon/icon.jpg");

                dialogPane.setGraphic(im);

                dialogPane.setExpandableContent(new Text("这是扩展内容"));
                dialogPane.setExpanded(true);

                Scene sc = new Scene(dialogPane);

                Stage stage = new Stage();
                stage.setScene(sc);

                stage.initOwner(primaryStage);

                stage.initStyle(StageStyle.UTILITY);
                stage.initModality(Modality.WINDOW_MODAL);

                stage.setTitle("这是弹出的窗口");
                stage.show();

                apply.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("应用");
                    }
                });

                close.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("关闭");
                    }
                });

                MyScheduledService my = new MyScheduledService(dialogPane, stage);
                my.setDelay(Duration.millis(0));
                my.setPeriod(Duration.millis(1000));

                my.start();
            }
        });

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}

class MyScheduledService extends ScheduledService<Integer> {

    int i = 0;
    private DialogPane di = null;
    private Stage stage = null;

    public MyScheduledService(DialogPane di, Stage stage) {
        this.di = di;
        this.stage = stage;
    }

    @Override
    protected Task<Integer> createTask() {
        return new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                System.out.println("call = " + Thread.currentThread().getName());
                return i = i + 1;
            }

            @Override
            protected void updateValue(Integer value) {
                System.out.println("call = " + Thread.currentThread().getName());
                System.out.println("updateValue的值 = " + value);

                if (value < 11) {
                    MyScheduledService.this.di.setContentText(String.valueOf(value));
                } else {
                    MyScheduledService.this.cancel();
                    MyScheduledService.this.stage.close();
                }
            }
        };
    }
}