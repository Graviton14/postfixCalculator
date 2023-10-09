import java.util.LinkedList;

/**
 * The type Double stack.
 */
public class DoubleStack implements Stack<Double> {
    private final LinkedList<Double> stack;

    /**
     * Instantiates a new Double stack.
     */
    public DoubleStack() {
        stack = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void push(Double val) {
        stack.push(val);
    }

    @Override
    public void push(double val) {
        stack.push(val);
    }

    @Override
    public Double pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stack.pop();
    }

    @Override
    public Double peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stack.peek();
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return stack.size();
    }
}
