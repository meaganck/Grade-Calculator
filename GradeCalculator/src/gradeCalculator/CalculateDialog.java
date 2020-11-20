package gradeCalculator;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CalculateDialog extends Dialog {
    public CalculateDialog(Stage owner, AllEvaluations e){
        setTitle("Results");
        setHeaderText("Results");


        // add another button to set goal!
        ButtonType okButtonType = new ButtonType("Done", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(okButtonType);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(20);
        grid.setStyle("-fx-font: 16 arial;");

        // labels
        Label currentLabel = new Label("Current Grade:");
        currentLabel.setStyle("-fx-text-fill:#034f84; -fx-font-weight:bold;");

        Label goalLabel = new Label("Goal:");
        goalLabel.setStyle("-fx-text-fill:#034f84; -fx-font-weight:bold;");

        Label examLabel = new Label("Grade needed on Exam:");
        examLabel.setStyle("-fx-text-fill:#034f84; -fx-font-weight:bold;");


        // TextFields
        TextField cField = new TextField("" + e.getCurrentGrade());
        cField.setDisable(true);

        TextField gField = new TextField();
        gField.setPromptText("The grade that you want");

        TextField eField = new TextField();
        eField.setDisable(true);


        grid.add(currentLabel, 0, 0);
        grid.add(cField, 1, 0);
        grid.add(goalLabel, 0, 1);
        grid.add(gField, 1, 1);
        grid.add(examLabel, 0, 2);
        grid.add(eField, 1, 2);

        getDialogPane().setContent(grid);
    }
}
