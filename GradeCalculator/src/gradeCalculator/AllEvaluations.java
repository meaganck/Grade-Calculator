package gradeCalculator;

public class AllEvaluations {
    private static final int MAX_EVALUATIONS = 150;
    private Evaluation[] evaluations;
    private int evaluationCount;
    private int selectedEvaluation;
    private double goal;

    public AllEvaluations(){
        evaluations = new Evaluation[MAX_EVALUATIONS];
        evaluationCount = 0;
        selectedEvaluation = -1;
    }

    // getters
    public Evaluation[] getEvaluationsList(){
        Evaluation[] list = new Evaluation[evaluationCount];
        for(int i = 0; i < evaluationCount; i++){
            list[i] = evaluations[i];
        }
        return list;
    }

    public void add(Evaluation e){
        if(evaluationCount < MAX_EVALUATIONS){
            evaluations[evaluationCount] = e;
            evaluationCount++;
        }
    }

    public void remove(String name){
        for (int i = 0; i < evaluationCount; i++) {
            Evaluation e = evaluations[i];
            if (evaluations[i].getName().equals(name)) {
                evaluations[i] = evaluations[evaluationCount-1];
                evaluationCount--;
            }
        }
    }

    public void setSelectedEvaluation(int i){selectedEvaluation = i;}

}
