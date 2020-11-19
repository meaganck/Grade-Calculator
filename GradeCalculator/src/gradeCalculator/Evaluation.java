package gradeCalculator;

public class Evaluation {
    private String name;
    private double grade;
    private double weight;

    // constructor
    public Evaluation(String n, Double g, Double w){
        name = n;
        grade = g;
        weight = w;
    }

    public Evaluation(){
        // default
        name = "";
        grade = 0;
        weight = 0;
    }

    // getters
    public String getName(){return name;}
    public Double getGrade(){return grade;}
    public Double getWeight(){return weight;}

    // setters
    public void setName(String n){name = n;}
    public void setGrade(Double g){grade = g;}
    public void setWeight(Double w){weight =w;}

}
