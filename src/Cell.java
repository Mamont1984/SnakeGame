import java.awt.*;

/**
 * Created by evgeny on 09.10.2016.
 */
public class Cell {

    private boolean isEmpty = true;
    private int x;
    private int y;
    private Color color = Color.white;

    Cell() {
        isEmpty = false;
    }

    Cell(int x, int y, boolean isEmpty, Color color) {
        this.x = x;
        this.y = y;
        this.isEmpty = isEmpty;
        this.color = color;
    }

    boolean isEmpty() {
        return isEmpty;
    }
}
