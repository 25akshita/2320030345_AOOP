package expensemanagement;
import java.util.ArrayList;
import java.util.List;


public class ExpenseReport {
	private List<Expense> expenses;

    public ExpenseReport() {
        expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void approveExpense(String description) {
        for (Expense expense : expenses) {
            if (expense.getDescription().equals(description) && !expense.isApproved()) {
                expense.approve();
                System.out.println("Expense approved: " + description);
                return;
            }
        }
        System.out.println("Expense not found or already approved: " + description);
    }

    public double calculateTotalReimbursement() {
        return expenses.stream()
                .filter(Expense::isApproved)
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public void displayExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

}
