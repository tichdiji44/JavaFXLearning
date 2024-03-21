package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();

        TabPane tabPane = new TabPane();
        tabPane.setPrefWidth(300);
        tabPane.setPrefHeight(300);
        tabPane.setStyle("-fx-background-color:#FFA07A;");

        Background bg = new Background(new BackgroundFill(Paint.valueOf("#B7CEEB"), new CornerRadii(10), new Insets(10)));
        tabPane.setBackground(bg);

        Border bor = new Border(new BorderStroke(Paint.valueOf("#EE2C2C"), BorderStrokeStyle.DOTTED, new CornerRadii(10), new BorderWidths(5)));
        tabPane.setBorder(bor);

        Tab tab1 = new Tab("tab1");
        Tab tab2 = new Tab("tab2");
        Tab tab3 = new Tab("tab3");

        HBox hBox = new HBox(10);
        hBox.setStyle("-fx-background-color:#ff69b4;");
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(new Button("button1"), new Button("button2"));
        tab1.setContent(hBox);

        VBox vBox = new VBox(10);
        vBox.setStyle("-fx-background-color:#89d3ee;");
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(new Button("button1"), new Button("button2"));
        tab2.setContent(vBox);

        tabPane.getTabs().addAll(tab1, tab2, tab3);

        AnchorPane.setTopAnchor(tabPane, 100.0);
        AnchorPane.setLeftAnchor(tabPane, 100.0);

        an.getChildren().add(tabPane);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        ImageView img = new ImageView("icon/icon.jpg");
        img.setFitWidth(25);
        img.setFitWidth(25);

        tab1.setGraphic(img);
        // tab1.setClosable(false);
        tabPane.setRotateGraphic(false);
        // tabPane.setSide(Side.RIGHT);
        // tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        // tab2.setDisable(true);
        // tabPane.getSelectionModel().select(tab2);
        // tabPane.getSelectionModel().selectLast();
        // tabPane.getSelectionModel().selectPrevious();
        tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
                System.out.println(newValue.getText());
            }
        });

        tab1.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Tab t = (Tab) event.getSource();
                System.out.println("tab1的选择状态是 + " + t.isSelected());
            }
        });

        an.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tabPane.getTabs().add(new Tab("hello"));
            }
        });

        tab1.setOnClosed(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("tab1.setOnClosed");
            }
        });

        tab1.setOnCloseRequest(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("tab1.setOnCloseRequest");
                event.consume();
            }
        });
    }
}
