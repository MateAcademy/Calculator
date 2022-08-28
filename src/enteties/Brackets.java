package enteties;

/**
 * @author Sergey Klunniy
 */
public class Brackets {
    private int openPosition;
    private int closedPosition;

    public Brackets(int openPosition) {
        this.openPosition = openPosition;
        this.closedPosition = -1;
    }

    public int getOpenPosition() {
        return openPosition;
    }

    public int getClosedPosition() {
        return closedPosition;
    }

    public void setClosedPosition(int closedPosition) {
        this.closedPosition = closedPosition;
    }
}
