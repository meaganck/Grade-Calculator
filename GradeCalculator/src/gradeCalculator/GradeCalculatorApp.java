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

import java.util.Optional;


public class GradeCalculatorApp extends Application{
    private AllEvaluations model;
    private  GradeCalculatorView view;

    public void start(Stage primaryStage) {
        model = new AllEvaluations();
        view = new GradeCalculatorView(model);

        // event handlers
        view.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Evaluation e = new Evaluation();
                AddDialog addDialog = new AddDialog(primaryStage, e);
                Optional<Evaluation> result = addDialog.showAndWait();

                if (result.isPresent()){
                    model.add(e);
                    view.update(model);
                }
            }
        });

        primaryStage.setTitle("Grade Calculator");
        primaryStage.setScene(new Scene(view, 650, 300));
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
