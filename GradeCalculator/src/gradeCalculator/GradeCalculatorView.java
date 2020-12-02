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
    private RadioMenuItem nameItem;
    private RadioMenuItem weightItem;
    private RadioMenuItem gradeItem;

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

        // add a menu
        Menu sortMenu = new Menu("_Sort");
        nameItem = new RadioMenuItem("By name");
        gradeItem = new RadioMenuItem("By grade");
        weightItem = new RadioMenuItem("By weight");
        ToggleGroup sortGroup = new ToggleGroup();
        nameItem.setToggleGroup(sortGroup);
        gradeItem.setToggleGroup(sortGroup);
        weightItem.setToggleGroup(sortGroup);
        sortMenu.getItems().addAll(nameItem, gradeItem, weightItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(sortMenu);


        // adding components to grid pane
        add(menuBar, 0, 0, 3, 1);
        add(evaluationLabel, 0, 1);
        add(nList, 0, 2);
        add(gradeLabel, 1, 1);
        add(gList, 1, 2);
        add(weightLabel, 2, 1);
        add(wList, 2, 2);
        add(buttonPane, 0, 3, 2,1);


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
        //setPadding(new Insets(0, 0, 20 ,0));
        Insets insetsL = new Insets(0, 0, 0, 20);
        Insets insetsR = new Insets(0, 20, 0, 0);

        GridPane.setMargin(evaluationLabel,insetsL);
        GridPane.setMargin(nList,insetsL);
        GridPane.setMargin(buttonPane, new Insets(0, 0, 20, 20));
        GridPane.setMargin(weightLabel,insetsR);
        GridPane.setMargin(wList, insetsR);

        setHgap(20);
        setVgap(20);


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

        int size = model.getEvaluationsList().size();

        // lists to go in ListViews
        String[] names = new String[size];
        Double[] grades = new Double[size];
        Double[] weights = new Double[size];

        // change this later to make it shorter
        for(int i = 0; i < size; i++){
            names[i] = model.getEvaluationsList().get(i).getName();
            grades[i] = model.getEvaluationsList().get(i).getGrade();
            weights[i] = model.getEvaluationsList().get(i).getWeight();
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
    public RadioMenuItem getNameItem(){return nameItem;}
    public RadioMenuItem getGradeItem(){return gradeItem;}
    public RadioMenuItem getWeightItem(){return weightItem;}



}
