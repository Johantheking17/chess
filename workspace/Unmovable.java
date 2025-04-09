//Name: Anthony
//Piece: Pawn
//Description: Can move one square forward, or two squares if on the starting column. Captures forward diagnaolly. 

import java.util.ArrayList;


//you will need to implement two functions in this file.
public class Unmovable extends Piece{
    
    public Unmovable(String img_file) {
        super (img_file);
    }

    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    //Pre-Condition: Takes into two argument, the board itself alongside the starting square for the piece. User must click on this piece.
    //Post-condition: Returns a list of tiles which the piece we are currently looking at controls.
    public ArrayList<Square> getControlledSquares(Square [][] board, Square start) {
      return new ArrayList<>();
  }

    public ArrayList<Square> getLegalMoves(Board b, Square start){
      return new ArrayList<>();
    }
  //Pre-condition: A pawn is moved
  //Post-condtion: Returns a string, stating the color of the pawn which just moved. 
  public String toString(){
    return "A Chopped Unmovable";
  }
}