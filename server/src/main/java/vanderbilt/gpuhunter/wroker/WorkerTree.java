package vanderbilt.gpuhunter.wroker;

public interface WorkerTree {

    public void insert(Order order);

    public void delete(Order order);

    public boolean contains(Order order);

    public ExecutionNode findOldestAndRemove();
}
