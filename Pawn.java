// Pawn.java - Pawn piece with specific move logic
import java.awt.*;

public class Pawn extends ChessPiece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        int direction = isWhite() ? -1 : 1;
        if (startX == endX && board[endX][endY] == null && endY == startY + direction) {
            return true;
        }
        return false;
    }

    @Override
    public void draw(Graphics g, int x, int y, int tileSize) {
        g.setColor(isWhite() ? Color.WHITE : Color.BLACK);
        g.fillOval(x + tileSize / 4, y + tileSize / 4, tileSize / 2, tileSize / 2);
    }
}
