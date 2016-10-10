import javax.swing.*;
import java.awt.*;

/**
 * Created by evgeny on 09.10.2016.
 */
public class SnakeGame extends JFrame {

    final static int FIELD_WIDTH = 10;
    final static int FIELD_HEIGHT = 10;
    final static int CELL_SIZE = 25;
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

        frame.setSize(FIELD_WIDTH * CELL_SIZE, FIELD_HEIGHT * CELL_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        canvas.setBackground(Color.white);
        frame.add(canvas);

        frame.setVisible(true);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        g = canvas.getGraphics();
        g.setColor(Color.red);
        g.fillRect(0, 0, 20, 20);
        g.dispose();
        canvas.paint(g);

//      field.show();
    }

    public void paint(Graphics g, Canvas canvas){


    }
}
