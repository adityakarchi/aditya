// Knight.java - Knight piece with specific move logic
import java.awt.*;

public class Knight extends ChessPiece {
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        int dx = Math.abs(startX - endX);
        int dy = Math.abs(startY - endY);
        return (dx == 2 && dy == 1 || dx == 1 && dy == 2) &&
               (board[endX][endY] == null || board[endX][endY].isWhite() != isWhite());
    }

    @Override
    public void draw(Graphics g, int x, int y, int tileSize) {
        g.setColor(isWhite() ? Color.WHITE : Color.BLACK);
        g.fillRoundRect(x + tileSize / 4, y + tileSize / 4, tileSize / 2, tileSize / 2, 10, 10);
    }
}
