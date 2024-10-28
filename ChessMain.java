// ChessMain.java - Main class to start the chess game
import javax.swing.*;
import java.awt.*;

public class ChessMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess Game");
        ChessBoard chessBoard = new ChessBoard();
        frame.add(chessBoard);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
