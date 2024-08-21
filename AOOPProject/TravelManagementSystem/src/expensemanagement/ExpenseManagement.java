package expensemanagement;

public class ExpenseManagement {

	public static void main(String[] args) {
		ExpenseReport report = new ExpenseReport();

        // Adding expenses
        report.addExpense(new Expense("Flight to Delhi", 9050));
        report.addExpense(new Expense("Hotel Stay", 4500));
        report.addExpense(new Expense("Conference Fee", 2000));
        report.addExpense(new Expense("Dinner with friend", 1500));

        // Displaying all expenses
        System.out.println("All Expenses:");
        report.displayExpenses();

        // Approving some expenses
        System.out.println("\nApproving some expenses...");
        report.approveExpense("Flight to Delhi");
        report.approveExpense("Hotel Stay");

        // Displaying all expenses after approval
        System.out.println("\nExpenses after approval:");
        report.displayExpenses();

        // Calculating total reimbursement
        double totalReimbursement = report.calculateTotalReimbursement();
        System.out.println("\nTotal Approved Reimbursement: rupees " + totalReimbursement);
		// TODO Auto-generated method stub

	}

}
