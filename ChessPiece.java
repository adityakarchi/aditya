// ChessPiece.java - Abstract class for chess pieces
import java.awt.*;

abstract class ChessPiece {
    private boolean isWhite;

    public ChessPiece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public abstract boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board);
    public abstract void draw(Graphics g, int x, int y, int tileSize);
}
