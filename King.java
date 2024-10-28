// King.java - King piece with specific move logic
import java.awt.*;

public class King extends ChessPiece {
    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        int dx = Math.abs(startX - endX);
        int dy = Math.abs(startY - endY);
        
        // King can move only one square in any direction
        return dx <= 1 && dy <= 1 &&
               (board[endX][endY] == null || board[endX][endY].isWhite() != isWhite());
    }

    @Override
    public void draw(Graphics g, int x, int y, int tileSize) {
        g.setColor(isWhite() ? Color.WHITE : Color.BLACK);
        g.fillRoundRect(x + tileSize / 6, y + tileSize / 6, tileSize * 2 / 3, tileSize * 2 / 3, 10, 10);
    }
}
