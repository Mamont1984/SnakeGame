import java.awt.*;

/**
 * Created by evgeny on 09.10.2016.
 */
public class Cell {

    private boolean isEmpty = true;
    private int x;
    private int y;
    private Color color = Color.white;

    Cell(boolean isEmpty, Color color) {
        this.isEmpty = isEmpty;
        this.color =color;
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

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
