package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    int i = 10;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        an.setStyle("-fx-background-color: #ffffff");

        TextArea ta = new TextArea();
        // ta.setText("ABCDEFGHIJKLMN");
        ta.setFont(Font.font(16));
        // ta.setWrapText(true);
        // ta.setPrefRowCount(2);
        // ta.setPrefColumnCount(3);
        ta.setPrefWidth(200);
        ta.setPrefHeight(200);
        // ta.appendText("asdfasd");
        // ta.deleteText(0, 3);
        // ta.insertText(2, "0");
        // ta.replaceText(0, 1, "asdfaadsg");
        // ta.selectAll();
        // ta.selectForward();
        // ta.selectPositionCaret(4);
        // ta.getLength();
        // ta.selectRange(3, 5);
        // ta.positionCaret(3);
        // ta.home();
        // ta.selectEnd();
        // ta.selectHome();
        // ta.setEditable(false);
        // ta.clear();
        // ta.copy();

        an.getChildren().add(ta);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        an.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ta.setScrollLeft(i = i + 10);
            }
        });

        // ta.textProperty().addListener(new ChangeListener<String>() {
        //     @Override
        //     public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        //         if (newValue.length() > 10) {
        //             ta.setText(oldValue);
        //         }
        //     }
        // });

        // ta.selectedTextProperty().addListener(new ChangeListener<String>() {
        //     @Override
        //     public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        //         System.out.println(newValue);
        //     }
        // });

        ta.scrollLeftProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue);
            }
        });
    }

}
