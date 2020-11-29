package gradeCalculator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class CalculateDialog extends Dialog {
    public CalculateDialog(Stage owner, AllEvaluations e){

        setTitle("Results");
        getDialogPane().setStyle("-fx-background-color: #92a8d1;");

        // add another button to set goal!
        ButtonType okButtonType = new ButtonType("Done", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(okButtonType);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(20);
        grid.setStyle("-fx-font: 16 arial;");

        // labels
        Label currentLabel = new Label("Current Grade(%):");
        currentLabel.setStyle("-fx-text-fill:#034f84; -fx-font-weight:bold;");

        Label goalLabel = new Label("Goal(%):");
        goalLabel.setStyle("-fx-text-fill:#034f84; -fx-font-weight:bold;");

        Label examLabel = new Label("Grade needed on Exam(%):");
        examLabel.setStyle("-fx-text-fill:#034f84; -fx-font-weight:bold;");

        Label message = new Label("");


        // TextFields
        TextField cField = new TextField("" + e.getCurrentGrade());
        cField.setDisable(true);

        TextField gField = new TextField();
        gField.setPromptText("The grade that you want");

        TextField eField = new TextField();
        eField.setDisable(true);

        Button goalButton = new Button("Enter");
        goalButton.setDisable(true); // default


        // adds components to grid pane
        grid.add(currentLabel, 0, 0);
        grid.add(cField, 1, 0);
        grid.add(goalLabel, 0, 1);
        grid.add(gField, 1, 1);
        grid.add(goalButton, 1, 2);
        grid.add(examLabel, 0, 3);
        grid.add(eField, 1, 3);
        grid.add(message, 1, 4);

        getDialogPane().setContent(grid); // adds grid pane to dialog

        // listens to TextField to see if user enters a valid double
        gField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    // tries to convert input to double to validate input
                    double num = Double.parseDouble(gField.getText().trim());
                    goalButton.setDisable(false);

                } catch (final NumberFormatException e) {
                    goalButton.setDisable(true); // did not enter a valid double
                }
            }
        });

        goalButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double grade = e.getGoal(Double.parseDouble(gField.getText().trim()));

                if(grade > 100){
                    message.setText("Sorry bro");
                }else if(grade > 90) {
                    message.setText("You can do it!");
                }else if(grade <= 0) {
                    message.setText("You can skip the exam!");
                }else if(grade > 0 && grade < 25){
                    message.setText("You don't even have to try!");
                }else{
                    message.setText("You got this!");
                }

                eField.setText("" + grade);
            }
        });
    }
}
