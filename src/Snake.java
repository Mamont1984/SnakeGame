import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by evgeny on 09.10.2016.
 */
public class Snake {

    private int snakeLength;
    List<Cell> body = new ArrayList<Cell>();

    Snake(int x, int y,Field field, int snakeLength) {
        this.snakeLength = snakeLength;
        for (int i = 0; i < snakeLength; i++) {
            body.add(field.setSnakeBody(x + i, y));
        }
    }

    public void snakeMove(int currentSnakeDirection, Field field, Graphics g) {

        int x = body.get(body.size() - 1).getX();
        int y = body.get(body.size() - 1).getY();

        switch (currentSnakeDirection) {
            case SnakeGame.UP:
                if (field.getCell(x, y - 1) == null) {
                    body.add(field.setSnakeBody(x , y - 1));
                } else {
                    SnakeGame.setGameOver();
                }
                break;
            case SnakeGame.DOWN:
                if (field.getCell(x, y + 1) == null) {
                    body.add(field.setSnakeBody(x , y + 1));
                } else {
                    SnakeGame.setGameOver();
                }
                break;
            case SnakeGame.LEFT:
                if (field.getCell(x - 1, y) == null) {
                    body.add(field.setSnakeBody(x - 1, y));
                } else {
                    SnakeGame.setGameOver();
                }
                break;
            case SnakeGame.RIGTH:
                if (field.getCell(x +1 , y) == null) {
                    body.add(field.setSnakeBody(x + 1, y));
                } else {
                    SnakeGame.setGameOver();
                }
                break;
        }
        g.setColor(Color.white);
        g.fillRect(body.get(0).getX() * SnakeGame.CELL_SIZE, body.get(0).getY() * SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE);
        field.removeSnakeBody(body.get(0).getX(), body.get(0).getY());
        body.remove(0);
    }
}
