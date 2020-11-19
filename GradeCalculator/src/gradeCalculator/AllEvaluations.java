package gradeCalculator;

public class AllEvaluations {
    private static final int MAX_EVALUATIONS = 150;
    private Evaluation[] evaluations;
    private int evaluationCount;
    private double goal;

    public AllEvaluations(){
        evaluations = new Evaluation[MAX_EVALUATIONS];
        evaluationCount = 0;
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

}
