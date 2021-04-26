package vanderbilt.gpuhunter.wroker;

public class ExecutionNode {
    public Order order;
    public ExecutionNode left;
    public ExecutionNode right;

    public ExecutionNode(Order order) {
        this.order = order;
        this.left = null;
        this.right = null;
    }

    public int getOrderTimestamp() {
        return order.getTimestamp();
    }

    public int getScheduledTime() {
        return order.getScheduledTime();
    }
}
