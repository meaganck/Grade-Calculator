package gradeCalculator;

import javafx.geometry.Pos;
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
    private AllEvaluations model;
    private ListView<String> nList;
    private ListView<Double> gList;
    private ListView<Double> wList;
    private Button addButton;

    public GradeCalculatorView(AllEvaluations model){

        // components
        Label evaluationLabel = new Label("Evaluations");
        Label gradeLabel = new Label("Grade %");
        Label weightLabel = new Label("Weight %");

        // ListViews are originally empty
        nList = new ListView<String>();
        gList = new ListView<Double>();
        wList = new ListView<Double>();

        HBox buttonPane = new HBox();
        addButton = new Button("Add");
        Button removeButton = new Button("Remove");
        Button calcButton = new Button("Calculate");
        buttonPane.getChildren().add(addButton);
        buttonPane.getChildren().add(removeButton);
        buttonPane.getChildren().add(calcButton);

        // styling
        buttonPane.setSpacing(10);
        addButton.setStyle("-fx-font: 14 arial; -fx-base: rgb(0,100,0); -fx-text-fill: rgb(255,255,255);");
        removeButton.setStyle("-fx-font: 14 arial; -fx-base: rgb(200,0,0); -fx-text-fill: rgb(255,255,255);");
        calcButton.setStyle("-fx-font: 14 arial;");


        // adding components
        add(evaluationLabel, 0, 0);
        add(nList, 0, 1);
        add(gradeLabel, 1, 0);
        add(gList, 1, 1);
        add(weightLabel, 2, 0);
        add(wList, 2, 1);
        add(buttonPane, 0, 2, 2,1);

        // for making it look better
        setPadding(new Insets(20));
        setHgap(10);
        setVgap(10);

    }


    public void update(AllEvaluations model){

        Evaluation[] list = model.getEvaluationsList();

        // lists to go in ListViews
        String[] names = new String[list.length];
        Double[] grades = new Double[list.length];
        Double[] weights = new Double[list.length];

        for(int i = 0; i < list.length; i++){
            names[i] = list[i].getName();
            grades[i] = list[i].getGrade();
            weights[i] = list[i].getWeight();
        }

        nList.setItems(FXCollections.observableArrayList(names));
        gList.setItems(FXCollections.observableArrayList(grades));
        wList.setItems(FXCollections.observableArrayList(weights));


    }

    //  getters
    public Button getAddButton(){return addButton;}



}
