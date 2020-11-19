package gradeCalculator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AddDialog extends Dialog {
    public AddDialog(Stage owner, Evaluation e){
        setTitle("Add Evaluation");

        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        Label nLabel = new Label("Name:");
        Label gLabel = new Label("Grade (%):");
        Label wLabel = new Label("Weight (%):");

        TextField nField = new TextField();
        nField.setPromptText("Name of evaluation");
        nField.setMinWidth(300);

        TextField gField = new TextField();
        gField.setPromptText("Grade on evaluation (%)");
        gField.setMinWidth(300);

        TextField wField = new TextField();
        wField.setPromptText("Weight of evaluation");
        wField.setMinWidth(300);

        // add components to grid pane
        grid.add(nLabel, 0, 0);
        grid.add(nField, 1, 0);
        grid.add(gLabel, 0, 1);
        grid.add(gField, 1, 1);
        grid.add(wLabel, 0, 2);
        grid.add(wField, 1, 2);


        getDialogPane().setContent(grid); // Puts the stuff on the window
        getDialogPane().setPrefSize(400, 150);

        Node okButton = getDialogPane().lookupButton(okButtonType);

        setResultConverter(new Callback<ButtonType, Evaluation>()  {
            @Override
            public Evaluation call(ButtonType b) {

                if(b == okButtonType){
                    e.setName(nField.getText());

                    // will be valid, when I add a check that only enables ok button when
                    // user enters valid double for grade and weight
                    double grade = Double.parseDouble(gField.getText());
                    double weight = Double.parseDouble(wField.getText());

                    e.setGrade(grade);
                    e.setWeight(weight);

                    return e;
                }
                return null;
            }
        });



    }
}
