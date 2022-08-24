package enteties;

public enum Operations {
    MULTIPLY('*') {
        @Override
        public double count(double a, double b) {
            return a * b;
        }
    }, DIVISION('/') {
        @Override
        public double count(double a, double b) {
            return a / b;
        }
    }, ADDITION('+') {
        @Override
        public double count(double a, double b) {
            return a + b;
        }
    },
    SUBSTRACTION('-') {
        @Override
        public double count(double a, double b) {
            return a - b;
        }
    };

    private char operation;

    Operations(char operation) {
        this.operation = operation;
    }

    public char getOperation() {
        return operation;
    }

    public abstract double count(double a, double b);
}