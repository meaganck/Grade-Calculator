package gradeCalculator;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class GradeCalculatorApp extends Application{
    private AllEvaluations model;
    private  GradeCalculatorView view;


    public void start(Stage primaryStage) {
        model = new AllEvaluations();
        view = new GradeCalculatorView(model);

        primaryStage.setTitle("Grade Calculator");
        primaryStage.setScene(new Scene(view, 650, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
