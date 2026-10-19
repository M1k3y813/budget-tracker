import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;


public class BudgetApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       // BudgetCategory groceries = new BudgetCategory("groceries",500, 401);
       // System.out.println(groceries);
    
       List<BudgetCategory> budgets = new ArrayList<>();
        while(scan.hasNextLine()) {
           String category = scan.nextLine();

            double limit = scan.nextDouble();
            double spent = scan.nextDouble();
            BudgetCategory budget = new BudgetCategory(category, limit, spent);
            budgets.add(budget);

    //         // Consume \n after spent input 
             if(scan.hasNextLine()) scan.nextLine();

    //         String limitString = String.format("$%.2f", limit);
    //         String spentString = String.format("$%.2f", spent);
    //         System.out.println("The budget limit for " + category + " was: " + limitString + 
    //                            " but the actual spend was " + spentString);
         }
        Collections.sort(budgets, java.util.Collections.reverseOrder());

         System.out.println(budgets);

         int totalDiff = budgetDifference(budgets);
         System.out.println("Overall total difference: $" + totalDiff);

         double overallPercent = budgetPercentage(budgets);
         System.out.printf("Overall percentage over/under: %.2f%%\n", overallPercent);
 }

    /**
     * Returns overall how much over/under budget a person is given a list of their
     * categories.
     * 
     * This should be the sum of how much over/under budget each individual category is.
     * 
     * If the person is under budget, the result will be negative. If they are over budget, the
     * result will be positive.
     * 
     * @param categories the budget categories with the spend
     * @return the total amount over/under budget
     */
    public static int budgetDifference(List<BudgetCategory> categories) {
// TODO: You will implement this method in Wave 4
        // Note that this method SHOULD NOT have a print statement.
        // It should instead return the value.

        double totalDifference = 0;

        for (BudgetCategory category : categories) {
            totalDifference += (category.getSpent() - category.getLimint());
        }
         
        return (int) totalDifference;
    }

 public static double budgetPercentage(List<BudgetCategory> categories) {
    double totalLimit = 0;
    double totalDifference = 0;
    
    for (BudgetCategory category : categories) {
        totalDifference += (category.getSpent() - category.getLimint());
        totalLimit += category.getLimint();
    }
    if (totalLimit == 0) {
        return 0.0;
    }
    return (totalDifference / totalLimit) * 100;

 }
}

      

