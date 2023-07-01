package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import javafx.stage.Stage;
import sun.dc.pr.PRError;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();

        Text t1 = new Text("这里依旧是B站没人看系列");
        Text t2 = new Text("javafx视频教程");
        Text t3 = new Text("hello world");

        t1.setFont(Font.font(20));
        t1.setFill(Paint.valueOf("#ff82a8"));

        t2.setFont(Font.font("Helvetica", FontPosture.REGULAR, 40));
        t3.setFont(Font.font("Helvetica", FontWeight.SEMI_BOLD, 20));

        TextFlow textFlow = new TextFlow();
        // textFlow.setStyle("-fx-background-color:#eecfa1;");
        // textFlow.setEffect();

        // textFlow.setPadding(new Insets(10));
        textFlow.setTextAlignment(TextAlignment.LEFT);
        textFlow.setLineSpacing(30);

        textFlow.getChildren().addAll(t1, t2, t3);

        Text t4 = new Text("adfadsgaasd");
        TextFlow textFlow2 = new TextFlow();

        textFlow2.getChildren().add(t4);

        AnchorPane.setTopAnchor(textFlow, 100.0);
        AnchorPane.setLeftAnchor(textFlow, 100.0);

        an.getChildren().addAll(textFlow, textFlow2);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("这是AnchorPane宽度 = " + an.getWidth());

                System.out.println("这是textflow的宽度 = " + textFlow.getWidth());
            }
        });

        an.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                textFlow.setPrefWidth(newValue.doubleValue() - 100);
            }
        });
    }
}
