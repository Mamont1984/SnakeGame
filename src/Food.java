import java.awt.*;

/**
 * Created by evgeny on 09.10.2016.
 */
public class Food extends Cell {

    Food() {
        super(false, Color.red);
    }

    Food(int x, int y) {
        super(x, y, false, Color.red);
    }
}
