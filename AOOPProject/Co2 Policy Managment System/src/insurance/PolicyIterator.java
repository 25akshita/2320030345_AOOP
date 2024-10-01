package insurance;

import java.util.Iterator;
import java.util.List;

public class PolicyIterator implements Iterator<Policy> {
    private List<Policy> policies;
    private int position;

    public PolicyIterator(List<Policy> policies) {
        this.policies = policies;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < policies.size();
    }

    @Override
    public Policy next() {
        return policies.get(position++);
    }
}
