package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();

        ChoiceBox cb = new ChoiceBox<>();
        cb.getItems().addAll("str1", "str2", new Separator(), "str3");

        cb.setValue("str2");
        cb.getSelectionModel().select("str3");
        cb.getSelectionModel().selectPrevious();

        cb.setPrefWidth(100);
        AnchorPane.setTopAnchor(cb, 100.0);
        AnchorPane.setLeftAnchor(cb, 10.0);
        an.getChildren().add(cb);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        cb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });
    }
}
