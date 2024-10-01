package insurance;

import java.util.Comparator;

public class PremiumComparator implements Comparator<Policy> {
    @Override
    public int compare(Policy p1, Policy p2) {
        // Sorting policies based on premium amount
        return Double.compare(p1.getPremiumAmount(), p2.getPremiumAmount());
    }
}
