/**
 * Created by evgeny on 09.10.2016.
 */
public class Cell {

    private boolean isEmpty = true;
    private int x;
    private int y;

    Cell() {
        isEmpty = false;
    }

    Cell(int x, int y, boolean isEmpty) {
        this.x = x;
        this.y = y;
        this.isEmpty = isEmpty;
    }

    boolean isEmpty() {
        return isEmpty;
    }
}
