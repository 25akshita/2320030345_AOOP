package insurance;

public class Main {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        // Adding some policies
        manager.addPolicy(new Policy(101, "John Doe", 5000.0));
        manager.addPolicy(new Policy(102, "Jane Smith", 3000.0));
        manager.addPolicy(new Policy(103, "Alice Brown", 4000.0));

        System.out.println("Policies sorted by Policy Number:");
        manager.sortPoliciesByNumber();
        manager.listPolicies();

        System.out.println("\nPolicies sorted by Premium Amount:");
        manager.sortPoliciesByPremium();
        manager.listPolicies();

        // Cloning a policy
        Policy clonedPolicy = manager.clonePolicy(102);
        System.out.println("\nCloned Policy: " + clonedPolicy);
    }
}
