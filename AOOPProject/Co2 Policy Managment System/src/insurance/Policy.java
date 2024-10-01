package insurance;

public class Policy implements Comparable<Policy>, Cloneable {
    private int policyNumber;
    private String policyHolderName;
    private double premiumAmount;

    public Policy(int policyNumber, String policyHolderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.premiumAmount = premiumAmount;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public int compareTo(Policy otherPolicy) {
        // Sorting policies based on policy number
        return Integer.compare(this.policyNumber, otherPolicy.policyNumber);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Deep copy of the policy object
        return super.clone();
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber=" + policyNumber +
                ", policyHolderName='" + policyHolderName + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}
