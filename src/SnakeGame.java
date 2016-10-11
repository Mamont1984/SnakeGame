import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by evgeny on 09.10.2016.
 */
public class SnakeGame extends JFrame {

    final static int FIELD_WIDTH = 40;
    final static int FIELD_HEIGHT = 40;
    final static int FIELD_WIDTH_DX = 6;
    final static int FIELD_HEIGHT_DX = 28;
    final static int CELL_SIZE = 10;
    final static int SNAKE_LENGTH = 5;
    final static int GAME_SPEED_MILLS = 100;
    final static int UP = 38;
    final static int DOWN = 40;
    final static int LEFT = 37;
    final static int RIGTH = 39;
    int currentSnakeDirection = UP;
    static boolean GameOver = false;
    KeyListener k = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case UP:
                    if (currentSnakeDirection != DOWN)
                    currentSnakeDirection = UP;
                    break;
                case DOWN:
                    if (currentSnakeDirection != UP)
                    currentSnakeDirection = DOWN;
                    break;
                case LEFT:
                    if (currentSnakeDirection != RIGTH)
                    currentSnakeDirection = LEFT;
                    break;
                case RIGTH:
                    if (currentSnakeDirection != LEFT)
                    currentSnakeDirection = RIGTH;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };
    JFrame frame = new JFrame("Snake Game");
    Canvas canvas = new Canvas();
    Graphics g;

    public static void main(String[] args) {
        new SnakeGame().play();
    }

    private void play(){
        Field field = new Field();
        Snake snake = new Snake(FIELD_WIDTH / 2, FIELD_HEIGHT / 2, field, SNAKE_LENGTH);
        field.setRandom(new Food());
        field.setRandom(new Poison());

        frame.setSize(FIELD_WIDTH * CELL_SIZE + FIELD_WIDTH_DX, FIELD_HEIGHT * CELL_SIZE + FIELD_HEIGHT_DX);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        canvas.setBackground(Color.white);
        frame.add(canvas);
        canvas.addKeyListener(k);


        frame.setVisible(true);

        while (!GameOver) {
            try {
                Thread.sleep(GAME_SPEED_MILLS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < SnakeGame.FIELD_WIDTH; i++) {
                for (int j = 0; j < SnakeGame.FIELD_HEIGHT; j++) {
                    if (field.getCell(i, j) != null) {
                        g = canvas.getGraphics();
                        g.setColor(field.getCell(i, j).getColor());
                        g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);

                    }
                }
            }
            snake.snakeMove(currentSnakeDirection, field, g);
        }
    }

    public static void setGameOver() {
        GameOver = true;
    }
}
