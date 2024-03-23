package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Iterator;
import java.util.function.Consumer;

public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        an.setStyle("-fx-background-color: #ffffff");

        HBox box = new HBox();

        CheckBox c1 = new CheckBox("c1");
        CheckBox c2 = new CheckBox("c2");
        CheckBox c3 = new CheckBox("c3");
        CheckBox c4 = new CheckBox("c4");

        c1.setSelected(true);

        c2.setIndeterminate(true);

        c3.setAllowIndeterminate(true);

        box.getChildren().addAll(c1, c2, c3, c4);

        AnchorPane.setTopAnchor(box, 100.0);
        AnchorPane.setLeftAnchor(box, 100.0);

        an.getChildren().add(box);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        c1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        an.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Object[] obj = box.getChildren().toArray();
                // for (Object o : obj) {
                //     CheckBox c = (CheckBox) o;
                //     System.out.println(c.getText() + "的选择状态是 = " + c.isSelected() + " 不确定状态是 = " + c.isIndeterminate());
                // }

                // Iterator<Node> it = box.getChildren().iterator();
                // while (it.hasNext()) {
                //     CheckBox c = (CheckBox) it.next();
                //     System.out.println(c.getText() + "的选择状态是 = " + c.isSelected() + " 不确定状态是 = " + c.isIndeterminate());
                // }

                // box.getChildren().forEach(new Consumer<Node>() {
                //     @Override
                //     public void accept(Node node) {
                //         CheckBox c = (CheckBox) node;
                //         System.out.println(c.getText() + "的选择状态是 = " + c.isSelected() + " 不确定状态是 = " + c.isIndeterminate());
                //     }
                // });
            }
        });
    }
}
