import java.util.List;


/**
 * The interface Operator implementation.
 */
interface OperatorImplementation {
    /**
     * Eval double.
     *
     * @param args the args
     * @return the double
     */
    double eval(List<Double> args);
}

/**
 * The type Operator.
 */
class Operator {
    private final OperatorImplementation implementation;
    private final int numArgs;

    /**
     * Instantiates a new Operator.
     *
     * @param implementation the implementation
     * @param numArgs        the num args
     */
    public Operator(OperatorImplementation implementation, int numArgs) {
        this.implementation = implementation;
        this.numArgs = numArgs;
    }

    /**
     * Gets implementation.
     *
     * @return the implementation
     */
    public OperatorImplementation getImplementation() {
        return implementation;
    }

    /**
     * Gets num args.
     *
     * @return the num args
     */
    public int getNumArgs() {
        return numArgs;
    }
}

/**
 * The type Add operator.
 */
class AddOperator implements OperatorImplementation {
    @Override
    public double eval(List<Double> args) {
        return args.get(0) + args.get(1);
    }
}

/**
 * The type Sub operator.
 */
class SubOperator implements OperatorImplementation {
    @Override
    public double eval(List<Double> args) {
        return args.get(0) - args.get(1);
    }
}

/**
 * The type Mult operator.
 */
class MultOperator implements OperatorImplementation {
    @Override
    public double eval(List<Double> args) {
        return args.get(0) * args.get(1);
    }
}

/**
 * The type Div operator.
 */
class DivOperator implements OperatorImplementation {
    @Override
    public double eval(List<Double> args) {
        double divisor = args.get(1);
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return args.get(0) / divisor;
    }
}

/**
 * The type Print operator.
 */
class PrintOperator implements OperatorImplementation {
    @Override
    public double eval(List<Double> args) {
        double arg = args.get(0);
        System.out.println("Result: " + arg);
        return arg;
    }
}