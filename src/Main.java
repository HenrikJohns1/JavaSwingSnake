import javax.swing.*;
import java.awt.*;

class Main implements Runnable {
    @Override
    public void run() {
        JFrame frame = new JFrame("Game Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameBoard board = new GameBoard();
        frame.add(board);

        frame.addKeyListener(board);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Main());
    }

}

