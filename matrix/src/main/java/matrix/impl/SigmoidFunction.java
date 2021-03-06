package matrix.impl;

import matrix.Function;

public class SigmoidFunction implements Function {
    public double value(double x) {
        return 1.0 / (1.0 + (Math.exp(-x)));
    }
}
