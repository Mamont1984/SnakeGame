import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by evgeny on 09.10.2016.
 */
public class SnakeGame extends JFrame implements KeyListener {

    final static int FIELD_WIDTH = 20;
    final static int FIELD_HEIGHT = 20;
    final static int FIELD_WIDTH_DX = 6;
    final static int FIELD_HEIGHT_DX = 28;
    final static int CELL_SIZE = 10;
    final static int SNAKE_LENGTH = 1;
    final static int GAME_SPEED_MILS = 500;
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

        frame.setVisible(true);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < SnakeGame.FIELD_WIDTH; i++) {
            for (int j = 0; j < SnakeGame.FIELD_HEIGHT; j++) {
                g = canvas.getGraphics();
                g.setColor(field.getCell(i,j).c);
                g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.dispose();
                canvas.paint(g);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
