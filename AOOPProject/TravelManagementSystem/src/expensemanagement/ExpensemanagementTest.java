package expensemanagement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ExpensemanagementTest {
	

	static class Expense {
        private String description;
        private double amount;
        private boolean approved;

        public Expense(String description, double amount) {
            this.description = description;
            this.amount = amount;
            this.approved = false; // Initially, the expense is not approved
        }

        public String getDescription() {
            return description;
        }

        public double getAmount() {
            return amount;
        }

        public boolean isApproved() {
            return approved;
        }

        public void approve() {
            this.approved = true;
        }

        @Override
        public String toString() {
            return "Expense{" +
                    "description='" + description + '\'' +
                    ", amount=" + amount +
                    ", approved=" + approved +
                    '}';
        }
    }

    // Implementation of ExpenseReport class
    static class ExpenseReport {
        private java.util.List<Expense> expenses;

        public ExpenseReport() {
            expenses = new java.util.ArrayList<>();
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

    // Main method for testing the functionality of the system
    public static void main(String[] args) {
        ExpenseReport report = new ExpenseReport();

        // Adding expenses
        report.addExpense(new Expense("Flight to NYC", 300.50));
        report.addExpense(new Expense("Hotel Stay", 450.00));
        report.addExpense(new Expense("Conference Fee", 200.00));
        report.addExpense(new Expense("Dinner with Client", 85.75));

        // Displaying all expenses
        System.out.println("All Expenses:");
        report.displayExpenses();

        // Approving some expenses
        System.out.println("\nApproving some expenses...");
        report.approveExpense("Flight to NYC");
        report.approveExpense("Hotel Stay");

        // Displaying all expenses after approval
        System.out.println("\nExpenses after approval:");
        report.displayExpenses();

        // Calculating total reimbursement
        double totalReimbursement = report.calculateTotalReimbursement();
        System.out.println("\nTotal Approved Reimbursement: $" + totalReimbursement);
    }

    // JUnit 5 Tests
    static class TravelExpenseManagementSystemTests {

        private ExpenseReport report;

        @BeforeEach
        void setUp() {
            report = new ExpenseReport();
        }

        @Test
        void testExpenseCreation() {
            Expense expense = new Expense("Flight to NYC", 300.50);

            assertEquals("Flight to NYC", expense.getDescription());
            assertEquals(300.50, expense.getAmount());
            assertFalse(expense.isApproved(), "Expense should not be approved initially");
        }

        @Test
        void testApproveExpense() {
            Expense expense = new Expense("Hotel Stay", 450.00);

            assertFalse(expense.isApproved(), "Expense should not be approved initially");
            expense.approve();
            assertTrue(expense.isApproved(), "Expense should be approved after calling approve()");
        }

        @Test
        void testAddExpense() {
            Expense expense = new Expense("Dinner with Client", 85.75);
            report.addExpense(expense);

            assertFalse(report.calculateTotalReimbursement() > 0, "Total reimbursement should be 0 since no expense is approved yet");
        }

        @Test
        void testApproveExpenseInReport() {
            Expense expense = new Expense("Conference Fee", 200.00);
            report.addExpense(expense);

            report.approveExpense("Conference Fee");

            assertTrue(expense.isApproved(), "Expense should be approved");
            assertEquals(200.00, report.calculateTotalReimbursement(), "Total reimbursement should match the approved expense amount");
        }

        @Test
        void testCalculateTotalReimbursement() {
            report.addExpense(new Expense("Flight to NYC", 300.50));
            report.addExpense(new Expense("Hotel Stay", 450.00));
            report.addExpense(new Expense("Conference Fee", 200.00));

            report.approveExpense("Flight to NYC");
            report.approveExpense("Hotel Stay");

            double totalReimbursement = report.calculateTotalReimbursement();

            assertEquals(750.50, totalReimbursement, "Total reimbursement should sum only the approved expenses");
        }

        @Test
        void testApproveNonExistentExpense() {
            report.addExpense(new Expense("Taxi Fare", 50.00));

            // Attempt to approve an expense that doesn't exist
            report.approveExpense("Non-existent Expense");

            assertEquals(0.00, report.calculateTotalReimbursement(), "Total reimbursement should be 0 because the expense doesn't exist");
        }

}
}
    
