import java.awt.*;
import java.awt.event.KeyEvent;

public class World {
    Player player;
    Food food;

    int tileSize = 50;
    int tileWidth = 12;
    int tileHeight = 12;


    public World(){
        int playerPosX = 5;
        int playerPosY = 5;
        player = new Player(playerPosX,playerPosY, tileSize);
        food = new Food(tileSize);
    }

    public void tick() {
        // Collision test (if snake is on food, wall or body)


        // update game objects
        player.tick();
        food.tick();
    }

    public void draw(Graphics g) {
        player.draw(g);
        food.draw(g);
        drawCheckerBoard(g);
    }

    private void drawCheckerBoard(Graphics g) {
        Color lightColor = new Color(181, 232, 192);
        Color darkColor = new Color(109, 196, 121);
        Color currentColor;
        for(int y = 0; y < tileHeight; y++) {
            for (int x = 0; x < tileWidth; x++) {
                currentColor = (x + y) % 2 == 0 ? lightColor : darkColor;
                g.setColor(currentColor);
                g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
            }
        }

        food.draw(g);
        player.draw(g);
    }


    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
    }
}
