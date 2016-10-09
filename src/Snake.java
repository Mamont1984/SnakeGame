import java.util.LinkedList;
import java.util.List;

/**
 * Created by evgeny on 09.10.2016.
 */
public class Snake {

    private int snakeLength;

    Snake(int x, int y,Field field, int snakeLength) {
        this.snakeLength = snakeLength;
        List body = new LinkedList();
        for (int i = 0; i < snakeLength; i++) {
            body.add(field.setSnakeBody(x + i, y));
        }
    }
}
