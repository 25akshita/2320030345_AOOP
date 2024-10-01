package insurance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PolicyManager {
    private List<Policy> policies;

    public PolicyManager() {
        policies = new ArrayList<>();
    }

    public void addPolicy(Policy policy) {
        policies.add(policy);
    }

    public void sortPoliciesByNumber() {
        Collections.sort(policies);
    }

    public void sortPoliciesByPremium() {
        policies.sort(new PremiumComparator());
    }

    public void listPolicies() {
        PolicyIterator iterator = new PolicyIterator(policies);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public Policy clonePolicy(int policyNumber) {
        for (Policy policy : policies) {
            if (policy.getPolicyNumber() == policyNumber) {
                try {
                    return (Policy) policy.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
