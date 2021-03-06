package gradeCalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

                // pop up dialog to get new evaluation, if the user decides to add it,
                // adds to model and updates view
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
                // deletes selected evaluation and pops up a confirmation alert to make sure they want to delete it
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

        view.getCalcButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // shows calculate dialog
                CalculateDialog calculateDialog = new CalculateDialog(primaryStage, model);
                calculateDialog.showAndWait();
            }
        });


        view.getNameItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.sortByName();
                view.update(model, view.getnList().getSelectionModel().getSelectedIndex());
            }
        });

        view.getGradeItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.sortByGrade();
                view.update(model, view.getnList().getSelectionModel().getSelectedIndex());
            }
        });

        view.getWeightItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.sortByWeight();
                view.update(model, view.getnList().getSelectionModel().getSelectedIndex());
            }
        });



        primaryStage.setTitle("Grade Calculator");
        primaryStage.setScene(new Scene(view, 650, 300));
        primaryStage.show();

        // Bind the ListView scroll property
        ScrollBar bar1 = (ScrollBar)view.getnList().lookup(".scroll-bar");
        ScrollBar bar2 = (ScrollBar)view.getgList().lookup(".scroll-bar");
        ScrollBar bar3 = (ScrollBar)view.getwList().lookup(".scroll-bar");
        bar1.valueProperty().bindBidirectional(bar2.valueProperty());
        bar2.valueProperty().bindBidirectional(bar3.valueProperty());

        // sometimes gets this error from scroll bar
        // sun.javafx.scene.control.skin.VirtualFlow addTrailingCells
        //INFO: index exceeds maxCellCount. Check size calculations for class com.sun.javafx.scene.control.skin.ListViewSkin$2

    }

    public static void main(String[] args) {
        launch(args);
    }
}
