package gradeCalculator;

public class Evaluation implements Comparable{
    public static final int SORT_BY_NAME = 0;
    public static final int SORT_BY_GRADE = 1;
    public static final int SORT_BY_WEIGHT = 2;
    public static int sortStrategy = SORT_BY_NAME; // default

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

    public int compareTo(Object obj){
        switch (sortStrategy){
            case SORT_BY_NAME:
                // check just in case
                if(obj instanceof Evaluation){
                    Evaluation e = (Evaluation)obj;
                    return name.compareTo(e.name);
                }
                return 0;
            case SORT_BY_GRADE:
                if(obj instanceof Evaluation){
                    Evaluation e = (Evaluation)obj;
                    return (int)(e.getGrade() - grade);
                }
                return 0;
            case SORT_BY_WEIGHT:
                if(obj instanceof Evaluation){
                    Evaluation e = (Evaluation)obj;
                    return (int)(e.getWeight() - weight);
                }
                return 0;
        }
        return 0;
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
