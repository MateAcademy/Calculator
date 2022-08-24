package enteties;

public enum Chars {
    OPEN_BRACKET('('), CLOSED_BRACKET(')'), NUMBER_BOTTOM_LIMIT('0'), NUMBER_TOP_LIMIT('9');

    private char value;

    Chars(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}