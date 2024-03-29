package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.function.UnaryOperator;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox box = new VBox(20);

        TextField tf = new TextField();

        TextArea ta = new TextArea();

        // tf.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
        //     @Override
        //     public TextFormatter.Change apply(TextFormatter.Change t) {
        //         System.out.println(t.getText());
        //
        //         String value = t.getText();
        //
        //         if (value.matches("[a-z]")) {
        //             return t;
        //         }
        //         return null;
        //     }
        // }));

        box.getChildren().addAll(tf, ta);

        box.setAlignment(Pos.CENTER);

        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

            }
        });

        ta.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ta.setTextFormatter(new TextFormatter<String>(new StringConverter<String>() {
                    @Override
                    public String toString(String object) {
                        System.out.println("obj = " + object);
                        return object;
                    }

                    @Override
                    public String fromString(String string) {
                        System.out.println("str = " + string);
                        if (string.contains("5")) {
                            String value = string.replace("5", "五");
                            return value;
                        }
                        return string;
                    }
                }));

                ta.commitValue();
            }
        });

        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                tf.setTextFormatter(new TextFormatter<>(new StringConverter<Integer>() {
                    @Override
                    public String toString(Integer object) {
                        return String.valueOf(object);
                    }

                    @Override
                    public Integer fromString(String string) {
                        return Integer.valueOf(string);
                    }
                }));
                tf.commitValue();
            }
        });
    }
}
