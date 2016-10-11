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
        int nextx = 0;
        int nexty = 0;

        switch (currentSnakeDirection) {
            case SnakeGame.UP:
                nextx = x;
                nexty = y - 1;
                break;
            case SnakeGame.DOWN:
                nextx = x;
                nexty = y + 1;
                break;
            case SnakeGame.LEFT:
                nextx = x - 1;
                nexty = y;
                break;
            case SnakeGame.RIGTH:
                nextx = x + 1;
                nexty = y;
                break;
        }

        if (field.getCell(nextx, nexty) == null) {
            body.add(field.setSnakeBody(nextx, nexty));
            g.setColor(Color.white);
            g.fillRect(body.get(0).getX() * SnakeGame.CELL_SIZE, body.get(0).getY() * SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE);
            field.removeSnakeBody(body.get(0).getX(), body.get(0).getY());
            body.remove(0);
        } else if (field.getCell(nextx, nexty) instanceof Food){
            body.add(field.setSnakeBody(nextx, nexty));
            field.setRandom(new Food());
            field.setRandom(new Poison());
        } else {
            SnakeGame.setGameOver();
        }
    }
}
