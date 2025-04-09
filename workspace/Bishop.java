// Name: Ulises Cantor
// Teacher: Mr. Menchukov
// Period: 2
// Piece: Bishop
// The bishop moves diagonally, staying on the same colored square throughout the entire game. 
// It has infinite range until the end of the board or until there is a piece in the way (if it is an opposite color piece, it can capture it)
// and moves in all directions diagonal to it.



import java.util.ArrayList;


public class Bishop extends Piece{
    // Precondition: Valid boolean color and image file
    // Postcondition: A piece is created that can move like a bishop, in diagonals, with the provided color and image
    public Bishop(boolean isWhite, String img_file) {
      super(isWhite,img_file);
    }
    
// Precondition: The piece exists, not null 
// Postcondition: Returns an arry list of all squares that the selected piece can "see", for this it is all the diagonal spaces until the bishop reaches a sight "limit"
    public ArrayList<Square> getControlledSquares(Square[][] b, Square start) {
      ArrayList<Square> controlledSquares = new ArrayList<Square>();
      int sRow = start.getRow();
      int tempRow = sRow;
      int sCol = start.getCol();
      int tempCol = sCol;
      boolean available = true;
      while (available == true && (tempRow + 1 < 8) && (tempCol + 1 < 8)){
        tempRow++;
        tempCol++;
        if (b[tempRow][tempCol].isOccupied()==false){
          controlledSquares.add(b[tempRow][tempCol]);
        }
        else {
            controlledSquares.add(b[tempRow][tempCol]);
          
          available = false;
        }
      }
      tempRow = sRow;
      tempCol = sCol;
      available = true;
      while (available == true && (tempRow - 1 >= 0) && (tempCol + 1 < 8)){
        tempRow--;
        tempCol++;
        if (b[tempRow][tempCol].isOccupied()==false){
          controlledSquares.add(b[tempRow][tempCol]);
        }
        else {
            controlledSquares.add(b[tempRow][tempCol]);
          
          available = false;
        }
      }
      tempRow = sRow;
      tempCol = sCol;
      available = true;
      while (available == true && (tempRow - 1 >= 0) && (tempCol - 1 >= 0)){
        tempRow--;
        tempCol--;
        if (b[tempRow][tempCol].isOccupied()==false){
          controlledSquares.add(b[tempRow][tempCol]);
        }
        else {
            controlledSquares.add(b[tempRow][tempCol]);
          
          available = false;
        }
      }
      tempRow = sRow;
      tempCol = sCol;
      available = true;
      while (available == true && (tempRow + 1 < 8) && (tempCol - 1 >= 0)){
        tempRow++;
        tempCol--;
        if (b[tempRow][tempCol].isOccupied()==false){
          controlledSquares.add(b[tempRow][tempCol]);
        }
        else {
            controlledSquares.add(b[tempRow][tempCol]);
          
          available = false;
        }
      }
    	return controlledSquares;
    }
    
// Precondition: Bishop is selected and not null
// Postcondition: Returns an array list of all moves that can be made by the bishop during its turn, in diagonal directions limited by the edge of the board, its own pieces, and enemy pieces, which it CAN capture
    public ArrayList<Square> getLegalMoves(Board b, Square start){
      ArrayList<Square> legalMoves = new ArrayList<Square>();
      int sRow = start.getRow();
      int tempRow = sRow;
      int sCol = start.getCol();
      int tempCol = sCol;
      boolean available = true;
      while (available == true && (tempRow + 1 < 8) && (tempCol + 1 < 8)){
        tempRow++;
        tempCol++;
        Square targetSquare = b.getSquareArray()[tempRow][tempCol];
        if (targetSquare.isOccupied()==false){
          legalMoves.add(b.getSquareArray()[tempRow][tempCol]);
        }
        else {
          if ((targetSquare.getOccupyingPiece().getColor()) != this.getColor() && !(targetSquare.getOccupyingPiece() instanceof Unmovable)){
            legalMoves.add(targetSquare);
          }
          available = false;
        }
      }
      tempRow = sRow;
      tempCol = sCol;
      available = true;
      while (available == true && (tempRow - 1 >= 0) && (tempCol + 1 < 8)){
        tempRow--;
        tempCol++;
        Square targetSquare = b.getSquareArray()[tempRow][tempCol];
        if (targetSquare.isOccupied()==false){
          legalMoves.add(targetSquare);
        }
        else {
          if ((targetSquare.getOccupyingPiece().getColor()) != this.getColor() && !(targetSquare.getOccupyingPiece() instanceof Unmovable)){
            legalMoves.add(targetSquare);
          }
          available = false;
        }
      }
      tempRow = sRow;
      tempCol = sCol;
      available = true;
      while (available == true && (tempRow - 1 >= 0) && (tempCol - 1 >= 0)){
        tempRow--;
        tempCol--;
        Square targetSquare = b.getSquareArray()[tempRow][tempCol];
        if (targetSquare.isOccupied()==false){
          legalMoves.add(targetSquare);
        }
        else {
          if ((targetSquare.getOccupyingPiece().getColor()) != this.getColor() && !(targetSquare.getOccupyingPiece() instanceof Unmovable)){
            legalMoves.add(targetSquare);
          }
          available = false;
        }
      }
      tempRow = sRow;
      tempCol = sCol;
      available = true;
      while (available == true && (tempRow + 1 < 8) && (tempCol - 1 >= 0)){
        tempRow++;
        tempCol--;
        Square targetSquare = b.getSquareArray()[tempRow][tempCol];
        if (targetSquare.isOccupied()==false){
          legalMoves.add(targetSquare);
        }
        else {
          if ((targetSquare.getOccupyingPiece().getColor()) != this.getColor() && !(targetSquare.getOccupyingPiece() instanceof Unmovable)){
            legalMoves.add(targetSquare);
          }
          available = false;
        }
      }
    	return legalMoves;
    }

    // Precondition: Bishop is selected and not null
    // Postcondition: Returns a String of text that says "A <color of piece> Bishop"
    public String toString(){
      return "A " + super.toString() + " Bishop";
    }
}