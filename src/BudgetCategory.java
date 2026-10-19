public class BudgetCategory {
    
    private String name;
    private double limint;
    private double spent; 

public BudgetCategory(String name, double limint, double spent) {
    this.name = name;
    this.limint = limint;
    this.spent = spent;

}
 public String toString() {
    return name + "Budget: $ "+ limint + "Spent: $ "  +  spent; 
 }

 public int compareTo(BudgetCategory other) {
    double diff = limint-spent;
    double otherdiff = other.limint - other.spent;
    if(diff<otherdiff) {
        return -1;
    }
    if(diff==otherdiff){
        return 0;
    }
    return 1;
 }

 public String getName() {
    return name;
 }
 public void setName(String name) {
    this.name = name;
 }
 public double getLimint() {
    return limint;
 }
 public void setLimint(double limint) {
    this.limint = limint;
 }
 public double getSpent() {
    return spent;
 }
 public void setSpent(double spent) {
    this.spent = spent;
 }
}