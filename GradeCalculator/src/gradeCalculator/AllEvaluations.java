package gradeCalculator;

import java.util.ArrayList;
import java.util.Collections;

public class AllEvaluations {
    private ArrayList<Evaluation> evaluations;
    private int selectedEvaluation;
    private double goal;

    public AllEvaluations(){
        evaluations = new ArrayList<Evaluation>();
        selectedEvaluation = -1;
    }

    // getters
    public ArrayList<Evaluation> getEvaluationsList(){ return evaluations;}

    public void setSelectedEvaluation(int i){selectedEvaluation = i;}

    public double getTotalWeight(){
        double sum = 0;


        for(Evaluation e: evaluations){
            sum += e.getWeight();
        }
        return sum;
    }

    public double getCurrentGrade(){
        double sum = 0;

        for(Evaluation e: evaluations){
            sum += ((e.getGrade()/100) * e.getWeight());
        }
        return (sum/getTotalWeight())*100;
    }

    public double getGoal(double goal){
        double finalWeight = (100 - getTotalWeight())/100;
        return (double)((goal - (getCurrentGrade() * (1 -finalWeight)))/finalWeight);
    }


    // methods
    public void add(Evaluation e){
        evaluations.add(e);
        Collections.sort(evaluations); // sorts when new evaluation is added
    }

    public void remove(String name){
        for(int i = 0; i <evaluations.size(); i++){
            Evaluation e = evaluations.get(i);
            if(e.getName().equals(name)){
                evaluations.remove(e);
                i--;
            }
        }
    }

    public void sortByName(){
        Evaluation.sortStrategy = Evaluation.SORT_BY_NAME;
        Collections.sort(evaluations);
    }

    public void sortByGrade(){
        Evaluation.sortStrategy = Evaluation.SORT_BY_GRADE;
        Collections.sort(evaluations);
    }

    public void sortByWeight(){
        Evaluation.sortStrategy = Evaluation.SORT_BY_WEIGHT;
        Collections.sort(evaluations);
    }


}
