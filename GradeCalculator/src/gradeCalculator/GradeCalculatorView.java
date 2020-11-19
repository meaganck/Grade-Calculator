package gradeCalculator;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class GradeCalculatorView extends GridPane {
    public GradeCalculatorView(AllEvaluations model){

        // components
        Label evaluationLabel = new Label("Evaluations");


        // adding components
        add(evaluationLabel, 0, 0);

        // for making it look better
        setPadding(new Insets(10));

    }

}
