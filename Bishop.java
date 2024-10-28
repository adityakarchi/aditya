// Bishop.java - Bishop piece with specific move logic
import java.awt.*;

public class Bishop extends ChessPiece {
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        if (Math.abs(startX - endX) == Math.abs(startY - endY)) { // Move diagonally
            int stepX = Integer.compare(endX, startX);
            int stepY = Integer.compare(endY, startY);

            int x = startX + stepX;
            int y = startY + stepY;

            while (x != endX || y != endY) {
                if (board[x][y] != null) return false;
                x += stepX;
                y += stepY;
            }
            return board[endX][endY] == null || board[endX][endY].isWhite() != isWhite();
        }
        return false;
    }

    @Override
    public void draw(Graphics g, int x, int y, int tileSize) {
        g.setColor(isWhite() ? Color.WHITE : Color.BLACK);
        g.fillOval(x + tileSize / 4, y + tileSize / 4, tileSize / 2, tileSize / 2);
    }
}
