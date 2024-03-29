package fx.com;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main extends Application {
    public Student changeStudent;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField tf = new TextField();
        Button bu = new Button("修改名称");

        Student s1 = new Student("小A", 18, 90);
        Student s2 = new Student("小B", 12, 100);
        Student s3 = new Student("小C", 40, 50);
        Student s4 = new Student("小D", 20, 60.5);
        Student s5 = new Student("小E", 90, 250);

        AnchorPane an = new AnchorPane();

        ChoiceBox<Student> cb = new ChoiceBox<>();
        cb.getItems().addAll(s1, s2, s3, s4, s5);

        cb.setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {
                System.out.println("toString");
                String value = object.getName() + " - " + object.getAge() + " - " + object.getScore();
                return value;
            }

            @Override
            public Student fromString(String string) {
                return null;
            }
        });

        cb.setPrefWidth(150);
        AnchorPane.setTopAnchor(cb, 100.0);
        AnchorPane.setLeftAnchor(cb, 10.0);
        AnchorPane.setTopAnchor(tf, 50.0);
        AnchorPane.setLeftAnchor(tf, 10.0);
        AnchorPane.setTopAnchor(bu, 50.0);
        AnchorPane.setLeftAnchor(bu, 180.0);
        an.getChildren().addAll(cb, tf, bu);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        cb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                changeStudent = newValue;

                changeStudent.getNameSimpleStringProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        int i = cb.getItems().indexOf(changeStudent);
                        cb.getItems().remove(changeStudent);
                        cb.getItems().add(i, changeStudent);
                        System.out.println("这是 = " + newValue);
                    }
                });
            }
        });

        bu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // String name_value = tf.getText();
                // int i = cb.getItems().indexOf(changeStudent);
                // cb.getItems().remove(changeStudent);
                // changeStudent.setName(name_value);
                // cb.getItems().add(i, changeStudent);
                // System.out.println(changeStudent.getName());

                String name_value = tf.getText();
                changeStudent.setName(name_value);

                System.out.println("setOnAction");

                cb.getItems().add(s1);
            }
        });
    }
}

class Student {
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleIntegerProperty age = new SimpleIntegerProperty();
    private SimpleDoubleProperty score = new SimpleDoubleProperty();

    public Student(String name, int age, double score) {
        this.name.setValue(name);
        this.age.setValue(age);
        this.score.setValue(score);
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public int getAge() {
        return age.getValue();
    }

    public void setAge(int age) {
        this.age.setValue(age);
    }

    public double getScore() {
        return score.getValue();
    }

    public void setScore(double score) {
        this.score.setValue(score);
    }

    public SimpleStringProperty getNameSimpleStringProperty() {
        return name;
    }
}