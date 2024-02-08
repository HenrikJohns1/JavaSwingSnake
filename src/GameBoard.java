import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameBoard extends JPanel implements KeyListener, ActionListener {

    // DATA =============================================================================

    static final int DELAY = 25;
    private Timer timer;

    // Moving character
    Player player;
    Food food;
    World world;


    // CONSTRUCTORS |=|=|==|=|==|=|==|=|==|=|==|=|==|=|==|=|==|=|==|=|==|=|==|=|==|=|=|
    public GameBoard() {
        this.setPreferredSize(new Dimension(600, 600));

        // this timer will call the actionPerformed() method every DELAY ms
        timer = new Timer(DELAY, this);
        timer.start();
        world = new World();
    }


    // METHODS ==========================================================================

    // GRAPHICS |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        world.draw(g);
    }

    // INPUT |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        world.keyPressed(e);

    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }


    // GAME LOOP ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        world.tick();
        repaint();
    }

}
