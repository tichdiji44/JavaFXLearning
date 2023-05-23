package fx.com;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    int i = 10;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");

        b1.setLayoutX(0);
        b1.setLayoutY(10);
        b1.setPrefWidth(50);
        b1.setPrefHeight(50);

        b2.setLayoutX(200);
        b2.setLayoutY(10);
        b2.setPrefWidth(50);
        b2.setPrefHeight(50);

        b3.setLayoutX(400);
        b3.setLayoutY(10);
        b3.setPrefWidth(50);
        b3.setPrefHeight(50);

        Group group = new Group();
        // group.getChildren().add(b1);
        // group.getChildren().add(b2);
        // group.getChildren().add(b3);
        // group.getChildren().addAll(b3, b1, b2);
        group.getChildren().addAll(b1, b2, b3);
        // group.getChildren().remove(0);
        // group.getChildren().clear();
        // group.setAutoSizeChildren(false);
        // group.setOpacity(0.5);
        // System.out.println(group.contains(0, 0)); // 只能扫描左上角的点
        // System.out.println(group.contains(0, 10));
        // System.out.println(group.contains(0, 20));

        group.getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> c) {
                System.out.println("当前子组件的数量 = " + c.getList().size());
            }
        });

        Object[] objs = group.getChildren().toArray();

        System.out.println(objs.length);

        for (Object o : objs) {
            Button bu = (Button) o;

            bu.setPrefWidth(100);
            bu.setPrefHeight(100);
        }


        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                i += 10;
                Button b4 = new Button("b4");
                b4.setLayoutX(600);
                b4.setLayoutY(i);
                group.getChildren().add(b4);
            }
        });

        Scene scene = new Scene(group);

        primaryStage.setScene(scene);

        primaryStage.setTitle("javafx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
