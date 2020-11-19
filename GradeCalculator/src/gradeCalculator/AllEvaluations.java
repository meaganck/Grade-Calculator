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

}
