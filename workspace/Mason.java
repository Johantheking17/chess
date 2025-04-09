
//John Taylor

//Mason
//This piece (not in its current state but in its final state) will move like a queen except
// it doesn capture and it leaves a trail of pieces like for the next move, will act as an unmoving piece

import java.util.ArrayList;


//you will need to implement two functions in this file.
public class Mason extends Piece{
    
    public Mason(boolean isWhite, String img_file) {
        super(isWhite, img_file);
        
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.

    //Pre-Condition: board exists and start is a square in the board
    //Post-Condition: returns an empty Array List because the piece doesnt capture
    @Override
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      return new ArrayList<Square>();
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.

    //This piece moves like a queen but cannot capture (piece not completely finished by your request)\

    //Pre-Condition: b exists and start is a non-null square inside of the board b
    //Post-Condition: returns an Array List of sqaures that the piece can move to given that it moves like a queen.
    @Override
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
    @Override
    public String toString() {
      return "A "+super.toString()+" Mason";
    }
}