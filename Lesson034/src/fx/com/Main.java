package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main extends Application {
    String substr = "";
    int index = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TextField find_tf = new TextField();
        Button find_bu = new Button("查找");
        Button sort_bu = new Button("排序");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(find_tf, find_bu, sort_bu);

        TextArea find_ta = new TextArea();
        find_ta.setWrapText(true);
        find_ta.setFont(Font.font(16));
        find_ta.setText("adgflkadfjgalnklzxngvaekjgishkfdasngaj");
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox, find_ta);

        AnchorPane an = new AnchorPane();
        an.setStyle("-fx-background-color: #ffffff");
        an.getChildren().add(vBox);

        AnchorPane.setTopAnchor(vBox, 10.0);
        AnchorPane.setLeftAnchor(vBox, 10.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        find_bu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                find_ta.getParagraphs().forEach(new Consumer<CharSequence>() {
                    @Override
                    public void accept(CharSequence charSequence) {
                        String value = charSequence.toString();
                        String find_value = find_tf.getText();
                        substr = value.substring(index);
                        if (substr.contains(find_value)) {
                            primaryStage.setTitle("查找成功");
                            find_ta.requestFocus();
                            int i = substr.indexOf(find_value);
                            int temp = i + index;
                            index = temp + find_value.length();
                            System.out.println(index);
                            find_ta.selectRange(temp, index);
                            return;
                        }
                        primaryStage.setTitle("已经查找完成");
                        substr = value;
                        index = 0;
                    }
                });
            }
        });

        sort_bu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                char[] charArray = find_ta.getText().toCharArray();
                ArrayList<String> list = new ArrayList<>();
                for (char c : charArray) {
                    list.add(String.valueOf(c));
                }
                find_ta.clear();
                // list.stream().sorted((item1, item2) -> item1.compareTo(item2)).forEach(item -> find_ta.appendText(item));
                Stream<String> stream = list.stream().sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
                stream.forEach(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        find_ta.appendText(s);
                    }
                });
            }
        });
    }
}
