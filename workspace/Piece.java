
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
        
        try {
            if (this.img == null) {
              this.img = ImageIO.read(getClass().getResource(img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      return null;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.

    //This piece moves like a queen but cannot capture (piece not completely finished by your request)
    public ArrayList<Square> getLegalMoves(Board b, Square start){
      Square [][] board = b.getSquareArray();
    	ArrayList<Square> legalSquares = new ArrayList<Square>();
      boolean hitsOccupiedSquare = false;
      int counter = start.getRow() - 1;
      while(hitsOccupiedSquare == false && counter >= 0){
        if (board[counter][start.getCol()].isOccupied()){
          hitsOccupiedSquare = true;
        } else {
          legalSquares.add(board[counter][start.getCol()]);
          counter--;
        }
      }
      hitsOccupiedSquare = false;
      counter = start.getRow() + 1;

      while(hitsOccupiedSquare == false && counter < board.length){
        if (board[counter][start.getCol()].isOccupied()){
          hitsOccupiedSquare = true;
        } else {
          legalSquares.add(board[counter][start.getCol()]);
          counter++;
        }
      }
      hitsOccupiedSquare = false;
      counter = start.getCol() - 1;

      while(hitsOccupiedSquare == false && counter >= 0){
        if (board[start.getRow()][counter].isOccupied()){
          hitsOccupiedSquare = true;
        } else {
          legalSquares.add(board[start.getRow()][counter]);
          counter--;
        }
      }
      hitsOccupiedSquare = false;
      counter = start.getCol() + 1;

      while(hitsOccupiedSquare == false && counter < board[0].length){
        if (board[start.getRow()][counter].isOccupied()){
          hitsOccupiedSquare = true;
        } else {
          legalSquares.add(board[start.getRow()][counter]);
          counter++;
        }
      }
      hitsOccupiedSquare = false;
      counter = 1;

      while(hitsOccupiedSquare == false && ((start.getRow() - counter) >= 0) && ((start.getCol() - counter) >= 0)){
        if (board[start.getRow() - counter][start.getCol() - counter].isOccupied()){
          hitsOccupiedSquare = true;
        } else {
          legalSquares.add(board[start.getRow() - counter][start.getCol() - counter]);
          counter++;
        }
      }

      hitsOccupiedSquare = false;
      counter = 1;

      while(hitsOccupiedSquare == false && ((start.getRow() + counter) < board.length) && ((start.getCol() + counter) < board[0].length)){
        if (board[start.getRow() + counter][start.getCol() + counter].isOccupied()){
          hitsOccupiedSquare = true;
        } else {
          legalSquares.add(board[start.getRow() + counter][start.getCol() + counter]);
          counter++;
        }
      }
      hitsOccupiedSquare = false;
      counter = 1;

      while(hitsOccupiedSquare == false && ((start.getRow() + counter) < board.length) && ((start.getCol() - counter) >= 0)){
        if (board[start.getRow() + counter][start.getCol() - counter].isOccupied()){
          hitsOccupiedSquare = true;
        } else {
          legalSquares.add(board[start.getRow() + counter][start.getCol() - counter]);
          counter++;
        }
      }
      hitsOccupiedSquare = false;
      counter = 1;

      while(hitsOccupiedSquare == false && ((start.getRow() - counter) >= 0) && ((start.getCol() + counter) < board[0].length)){
        if (board[start.getRow() - counter][start.getCol() + counter].isOccupied()){
          hitsOccupiedSquare = true;
        } else {
          legalSquares.add(board[start.getRow() - counter][start.getCol() + counter]);
          counter++;
        }
      }

      return legalSquares;
    }
}