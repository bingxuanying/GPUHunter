package vanderbilt.gpuhunter.wroker;

public class ExecutionTree implements WorkerTree{
    private ExecutionNode root;

    @Override
    public void insert(Order order) {
        root = insert(root, order);
    }

    @Override
    public void delete(Order order) {}

    @Override
    public boolean contains(Order order) {
        return contains(root, order);
    }

    @Override
    public ExecutionNode findOldestAndRemove() {
        Order oldestOrder = findOldestNode(root);
        root = delete(root, oldestOrder);
        return root;
    }

    private ExecutionNode insert(ExecutionNode current, Order order) {
        if (current == null) {
            return new ExecutionNode(order);
        }

        if (order.getTimestamp() < current.getOrderTimestamp()) {
            current.left = insert(current.left, order);
        } else if (order.getTimestamp() > current.getOrderTimestamp()) {
            current.right = insert(current.right, order);
        }

        return current;
    }

    private ExecutionNode delete(ExecutionNode current, Order order) {
        if (current == null) {
            return null;
        }

        if (order.getTimestamp() > current.getOrderTimestamp()) {
            current.right = delete(current.right, order);
            return current;
        }
        else if (order.getTimestamp() < current.getOrderTimestamp()) {
            current.left = delete(current.left, order);
            return current;
        } else {
            if (current.left == null || current.right == null) {
                return (current.left == null) ? current.right : current.left;
            } else {
                Order youngestOrder = findYoungestNode(current.right);
                current.order = youngestOrder;
                current.right = delete(current.right, youngestOrder);
                return current;
            }
        }
    }

    private Order findYoungestNode(ExecutionNode root) {
        return root.left == null ? root.order : findYoungestNode(root.left);
    }

    private boolean contains(ExecutionNode current, Order order) {
        if (current == null) { return false; }

        if (order.getTimestamp() == current.getOrderTimestamp()) { return true; }

        return order.getTimestamp() < current.getOrderTimestamp()
                ? contains(current.left, order)
                : contains(current.right, order);
    }

    private Order findOldestNode(ExecutionNode root) {
        return root.right == null ? root.order : findOldestNode(root.right);
    }
}
