import java.awt.*;

/**
 * Created by evgeny on 09.10.2016.
 */
public class Poison extends Cell {

    Poison() {
        super(false, Color.green);
    }

    Poison(int x, int y) {
        super(x, y, false, Color.green);
    }
}
