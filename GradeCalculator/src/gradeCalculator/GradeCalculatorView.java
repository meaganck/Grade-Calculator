package gradeCalculator;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class GradeCalculatorView extends GridPane {
    private AllEvaluations model;
    private ListView<String> nList;
    private ListView<Double> gList;
    private ListView<Double> wList;
    private Button addButton;
    private Button removeButton;
    private Button calcButton;

    public GradeCalculatorView(AllEvaluations model){

        setStyle("-fx-font: 16 arial;  -fx-font-weight:bold; -fx-background-color: #92a8d1;");

        // components
        Label evaluationLabel = new Label("Evaluations");
        Label gradeLabel = new Label("Grade %");
        Label weightLabel = new Label("Weight %");

        // ListViews are originally empty
        nList = new ListView<String>();
        gList = new ListView<Double>();
        wList = new ListView<Double>();

        // button pane in HBox
        HBox buttonPane = new HBox();
        addButton = new Button("Add");
        removeButton = new Button("Remove");
        calcButton = new Button("Calculate");
        buttonPane.getChildren().add(addButton);
        buttonPane.getChildren().add(removeButton);
        buttonPane.getChildren().add(calcButton);

        // styling button pane
        buttonPane.setSpacing(10);
        addButton.setStyle("-fx-font: 14 arial; -fx-base: rgb(0,100,0); -fx-text-fill: rgb(255,255,255);");
        removeButton.setStyle("-fx-font: 14 arial; -fx-base: rgb(200,0,0); -fx-text-fill: rgb(255,255,255);");
        calcButton.setStyle("-fx-font: 14 arial;");


        // adding components to grid pane
        add(evaluationLabel, 0, 0);
        add(nList, 0, 1);
        add(gradeLabel, 1, 0);
        add(gList, 1, 1);
        add(weightLabel, 2, 0);
        add(wList, 2, 1);
        add(buttonPane, 0, 2, 2,1);


        // makes ListViews resizeable
        final int PREF_WIDTH = 500;
        final int PREF_HEIGHT = Integer.MAX_VALUE;
        final int MIN_WIDTH = 50;
        final int MIN_HEIGHT = 100;


        nList.setPrefSize(PREF_WIDTH, PREF_HEIGHT);
        gList.setPrefSize(PREF_WIDTH, PREF_HEIGHT);
        wList.setPrefSize(PREF_WIDTH, PREF_HEIGHT);

        nList.setMinSize(MIN_WIDTH, MIN_HEIGHT);
        gList.setMinSize(MIN_WIDTH, MIN_HEIGHT);
        wList.setMinSize(MIN_WIDTH, MIN_HEIGHT);

        // for making it look better
        setPadding(new Insets(20));
        setHgap(10);
        setVgap(10);



        // these event handlers check which item in ListView is selected
        // so the whole row can be selected when it updates the view
        nList.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.setSelectedEvaluation(nList.getSelectionModel().getSelectedIndex());
                update(model, nList.getSelectionModel().getSelectedIndex());
            }
        });

        gList.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.setSelectedEvaluation(gList.getSelectionModel().getSelectedIndex());
                update(model, gList.getSelectionModel().getSelectedIndex());
            }
        });

        wList.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.setSelectedEvaluation(wList.getSelectionModel().getSelectedIndex());
                update(model, wList.getSelectionModel().getSelectedIndex());
            }
        });

    }


    public void update(AllEvaluations model, int selectedIndex){

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


        //updates selected items in ListView
        nList.getSelectionModel().select(selectedIndex);
        gList.getSelectionModel().select(selectedIndex);
        wList.getSelectionModel().select(selectedIndex);


    }

    //  getters
    public Button getAddButton(){return addButton;}
    public Button getRemoveButton(){return removeButton;}
    public Button getCalcButton(){return calcButton;}
    public ListView getnList(){return nList;}
    public ListView getgList(){return gList;}
    public ListView getwList(){return wList;}


}
