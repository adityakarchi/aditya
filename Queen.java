// Queen.java - Queen piece with specific move logic
import java.awt.*;

public class Queen extends ChessPiece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        Rook rookMovement = new Rook(isWhite());
        Bishop bishopMovement = new Bishop(isWhite());

        // Queen can move like both Rook and Bishop
        return rookMovement.isValidMove(startX, startY, endX, endY, board) ||
               bishopMovement.isValidMove(startX, startY, endX, endY, board);
    }

    @Override
    public void draw(Graphics g, int x, int y, int tileSize) {
        g.setColor(isWhite() ? Color.WHITE : Color.BLACK);
        g.fillRect(x + tileSize / 6, y + tileSize / 6, tileSize * 2 / 3, tileSize * 2 / 3);
    }
}
