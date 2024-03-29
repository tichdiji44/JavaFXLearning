package fx.com;

import javafx.application.Application;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.Comparator;

public class Main3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button bu = new Button("排序");

        ObservableList<String> list1 = FXCollections.observableArrayList();
        list1.addAll("数字", "字母");

        ObservableList<String> list2 = FXCollections.observableArrayList();
        list2.addAll("8", "2", "3", "1", "0", "5");

        ObservableList<String> list3 = FXCollections.observableArrayList();
        list3.addAll("A", "B", "C", "D", "E");

        AnchorPane an = new AnchorPane();

        ChoiceBox<String> cb1 = new ChoiceBox<>();
        cb1.setItems(list1);
        ChoiceBox<String> cb2 = new ChoiceBox<>();


        cb1.setPrefWidth(100);
        cb2.setPrefWidth(100);
        AnchorPane.setTopAnchor(cb1, 100.0);
        AnchorPane.setLeftAnchor(cb1, 10.0);
        AnchorPane.setTopAnchor(cb2, 100.0);
        AnchorPane.setLeftAnchor(cb2, 200.0);
        an.getChildren().addAll(cb1, cb2, bu);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        cb1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if ("数字".equals(newValue)) {
                    cb2.setItems(list2);
                } else if ("字母".equals(newValue)) {
                    cb2.setItems(list3);
                }
                cb2.show();
            }
        });

        bu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // list2.stream().sorted(String::compareTo);
                list2.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int i1 = Integer.valueOf(o1);
                        int i2 = Integer.valueOf(o2);
                        return i1 - i2;
                    }
                });
            }
        });
    }
}
