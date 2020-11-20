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
                    view.update(model, -1);
                }
            }
        });

        view.getRemoveButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (view.getnList().getSelectionModel().getSelectedItem() != null) {

                    // makes an alert to make sure user wants to delete item
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Please Confirm");
                    alert.setHeaderText("Please Confirm");
                    alert.setContentText("Are you sure that you want to remove this evaluation?");

                    Optional result = alert.showAndWait();

                    // once the alert is closed
                    if (result.isPresent()){
                        // checks if the ok button was clicked
                        if(result.get() == ButtonType.OK){
                            // since they verified that they wanted to remove the evaluation, removes it from model
                            model.remove((String)view.getnList().getSelectionModel().getSelectedItem());
                            view.update(model, -1);
                        }
                    }
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
