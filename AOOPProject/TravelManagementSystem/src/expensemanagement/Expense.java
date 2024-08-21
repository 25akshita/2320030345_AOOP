package expensemanagement;

public class Expense {
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
