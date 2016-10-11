import java.util.Random;

/**
 * Created by evgeny on 09.10.2016.
 */
public class Field {

    Random rnd = new Random();
    Cell[][] field = new Cell[SnakeGame.FIELD_WIDTH][SnakeGame.FIELD_HEIGHT];

    Field() {
        for (int i = 0; i < SnakeGame.FIELD_WIDTH; i++) {
            for (int j = 0; j < SnakeGame.FIELD_HEIGHT; j++) {
                if ((i == 0) || (j == 0) || (i == SnakeGame.FIELD_WIDTH - 1) || (j == SnakeGame.FIELD_HEIGHT - 1)) {
                    field[i][j] = new Wall(i, j);
                }
            }
        }
    }

    public Cell setSnakeBody(int x, int y) {
        field[x][y] = new SnakesBody(x, y);
        return field[x][y];
    }

    public void removeSnakeBody(int x, int y) {
        field[x][y] = null;
    }

    public void setRandom(Cell element) {
        int x;
        int y;
            do {
                x = rnd.nextInt(SnakeGame.FIELD_WIDTH - 1);
                y = rnd.nextInt(SnakeGame.FIELD_HEIGHT - 1);
            } while (field[x][y] != null);
        field[x][y] = element;
    }

    public Cell getCell(int x,int y) {
        return field[x][y];
    }
}
