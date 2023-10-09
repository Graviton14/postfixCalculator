import java.util.*;

/**
 * The type Postfix calc.
 */
public class PostfixCalc {
    private final DoubleStack operandStack;
    private final Map<String, Operator> operatorMap;

    /**
     * Instantiates a new Postfix calc.
     */
    public PostfixCalc() {
        operandStack = new DoubleStack();
        operatorMap = new HashMap<>();

        // Fill the operator map with associations of symbols to operator objects.
        operatorMap.put("+", new Operator(new AddOperator(), 2));
        operatorMap.put("add", operatorMap.get("+"));

        operatorMap.put("-", new Operator(new SubOperator(), 2));
        operatorMap.put("sub", operatorMap.get("-"));

        operatorMap.put("*", new Operator(new MultOperator(), 2));
        operatorMap.put("mult", operatorMap.get("*"));

        operatorMap.put("/", new Operator(new DivOperator(), 2));
        operatorMap.put("div", operatorMap.get("/"));

        operatorMap.put("=", new Operator(new PrintOperator(), 1));
        operatorMap.put("print", operatorMap.get("="));
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // Example usage
        PostfixCalc calculator = new PostfixCalc();
        calculator.storeOperand(3.0);
        calculator.storeOperand(2.0);
        calculator.evalOperator("+");
        calculator.storeOperand(5.0);
        calculator.evalOperator("*");
        calculator.evalOperator("=");
    }

    /**
     * Store operand.
     *
     * @param operand the operand
     */
    public void storeOperand(double operand) {
        operandStack.push(operand);
    }

    /**
     * Eval operator.
     *
     * @param operator the operator
     */
    public void evalOperator(String operator) {
        if (!operatorMap.containsKey(operator)) {
            throw new IllegalArgumentException("Unsupported operator: " + operator);
        }

        Operator op = operatorMap.get(operator);
        int numArgs = op.getNumArgs();

        if (operandStack.size() < numArgs) {
            throw new IllegalArgumentException("Not enough operands for operator: " + operator);
        }

        List<Double> args = new ArrayList<>();

        for (int i = 0; i < numArgs; i++) {
            args.add(operandStack.pop());
        }

        Collections.reverse(args);

        double result = op.getImplementation().eval(args);
        operandStack.push(result);
    }
}