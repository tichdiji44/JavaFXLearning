package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();

        ButtonBar buttonBar = new ButtonBar();
        Button b1 = new Button("Button1");
        Button b2 = new Button("Button2");
        Button b3 = new Button("Button3");

        // b1.setPrefWidth(200);

        ButtonBar.setButtonData(b1, ButtonBar.ButtonData.APPLY);
        ButtonBar.setButtonData(b2, ButtonBar.ButtonData.FINISH);
        ButtonBar.setButtonData(b3, ButtonBar.ButtonData.NO);

        buttonBar.getButtons().addAll(b1, b2, b3);

        buttonBar.setButtonOrder(ButtonBar.BUTTON_ORDER_NONE);

        // ButtonBar.setButtonUniformSize(b1, false);

        an.getChildren().add(buttonBar);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        b1.setOnAction(this);
        b2.setOnAction(this);
        b3.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        Button bu = (Button) event.getSource();

        if (ButtonBar.getButtonData(bu) == ButtonBar.ButtonData.APPLY) {
            System.out.println("标签是APPLY " + bu.getText());
        } else if (ButtonBar.getButtonData(bu) == ButtonBar.ButtonData.FINISH) {
            System.out.println("标签是FINISH " + bu.getText());
        } else if (ButtonBar.getButtonData(bu) == ButtonBar.ButtonData.NO) {
            System.out.println("标签是NO " + bu.getText());
        }
    }
}
