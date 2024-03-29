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
import javafx.util.StringConverter;

public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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
                String value = object.getName() + " - " + object.getAge() + " - " + object.getScore();
                return value;
            }

            @Override
            public Student fromString(String string) {
                return null;
            }
        });

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

        cb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                System.out.println(newValue.getAge());
            }
        });
    }
}

class Student {
    private String name;
    private int age;
    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}