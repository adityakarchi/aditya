// ChessBoard.java - Manages the chessboard and game logic
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ChessBoard extends JPanel {
    private final int SIZE = 8;
    private final Color lightColor = Color.WHITE;
    private final Color darkColor = Color.GRAY;
    private ChessPiece[][] board = new ChessPiece[SIZE][SIZE];
    private Point selectedPiece = null;
    private boolean isWhiteTurn = true;

    public ChessBoard() {
        setupPieces();
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                handleClick(e.getX(), e.getY());
            }
        });
    }

    private void setupPieces() {
        // Pawns
        for (int i = 0; i < SIZE; i++) {
            board[i][1] = new Pawn(false);
            board[i][6] = new Pawn(true);
        }
        // Other pieces setup (rooks, knights, bishops, queens, kings)
        board[0][0] = new Rook(false); board[7][0] = new Rook(false);
        board[0][7] = new Rook(true); board[7][7] = new Rook(true);

        board[1][0] = new Knight(false); board[6][0] = new Knight(false);
        board[1][7] = new Knight(true); board[6][7] = new Knight(true);

        board[2][0] = new Bishop(false); board[5][0] = new Bishop(false);
        board[2][7] = new Bishop(true); board[5][7] = new Bishop(true);

        board[3][0] = new Queen(false);
        board[3][7] = new Queen(true);

        board[4][0] = new King(false);
        board[4][7] = new King(true);
    }

    private void handleClick(int x, int y) {
        int col = x / (getWidth() / SIZE);
        int row = y / (getHeight() / SIZE);

        if (selectedPiece == null) {
            // Selecting a piece
            if (board[col][row] != null && board[col][row].isWhite() == isWhiteTurn) {
                selectedPiece = new Point(col, row);
                repaint();
            }
        } else {
            // Moving selected piece
            ChessPiece piece = board[selectedPiece.x][selectedPiece.y];
            if (piece.isValidMove(selectedPiece.x, selectedPiece.y, col, row, board)) {
                board[col][row] = piece;
                board[selectedPiece.x][selectedPiece.y] = null;
                isWhiteTurn = !isWhiteTurn;
            }
            selectedPiece = null;
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int tileSize = getWidth() / SIZE;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                boolean isLight = (row + col) % 2 == 0;
                g.setColor(isLight ? lightColor : darkColor);
                g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);

                ChessPiece piece = board[col][row];
                if (piece != null) {
                    piece.draw(g, col * tileSize, row * tileSize, tileSize);
                }
            }
        }
        if (selectedPiece != null) {
            g.setColor(Color.RED);
            g.drawRect(selectedPiece.x * tileSize, selectedPiece.y * tileSize, tileSize, tileSize);
        }
    }
}
