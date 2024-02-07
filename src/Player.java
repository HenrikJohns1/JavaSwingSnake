import java.awt.*;
import java.awt.event.KeyEvent;

public class Player implements gameObject {

    // DATA
    private int xPos;
    private int yPos;
    private int tileSize;
    int timer = 0;
    int moveTime = 150;

    enum Direction {
        North,
        South,
        West,
        East
    }

    Direction snakeDirection = Direction.West;

    // CONSTRUCTOR
    public Player(int x, int y, int tileSize) {
        this.xPos = x;
        this.yPos = y;

    }

    // METHODS
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){ // Up
            snakeDirection = Direction.North;
        }
        if(e.getKeyCode() == KeyEvent.VK_S) { // down
            snakeDirection = Direction.South;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){ // left
            snakeDirection = Direction.West;
        }
        if(e.getKeyCode() == KeyEvent.VK_D) { //right
            snakeDirection = Direction.East;
        }
    }

    public void draw(Graphics g) {
        g.setColor(new Color(131, 75, 169, 186));
        g.fillRect(xPos,yPos, 50, 50);
    }

    @Override
    public void tick() {
        timer += GameBoard.DELAY;
        if (timer > moveTime){
            timer = 0;
            movePlayer();
        }
    }

    private void movePlayer() {
        switch (snakeDirection) {
            case North -> yPos -= 50;
            case South -> yPos += 50;
            case West -> xPos -= 50;
            case East -> xPos += 50;
        }
    }
}
