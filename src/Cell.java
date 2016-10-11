import java.awt.*;

/**
 * Created by evgeny on 09.10.2016.
 */
abstract public class Cell {

    private int x;
    private int y;
    private Color color;

    Cell(Color color) {
        this.color =color;
    }

    Cell(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
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
