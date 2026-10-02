import java.util.*;
public class Player{
 /*Knows*/
 private ColorEnum color;
 private Piece [] pieces;
 private String state; //won or not 
 /*Does*/
 public Player(ColorEnum color, Cell [] yardCells){
  pieces = new Piece[4];
  for(int i=0;i<pieces.length;i++){pieces[i] = new Piece(color, yardCells[i]);}
 }
 public Piece [] getPiecesCopies(){
  Piece [] pieceCopies = new Piece[4];
  for(int i=0;i<4;i++){pieceCopies[i] = new Piece(pieces[i]);}
  return pieceCopies;
 }
 /*public int [][] getPiecesCoord(){
  int [][] piecesCoords = new int[4][2];
  for(int i=0;i<piecesCoords.length;i++){
   int [] coord = pieces[i].getCoord();
   piecesCoords[i][0] = coord[0];
   piecesCoords[i][1] = coord[1];
  }
  return piecesCoords; 
 }*/
 public ColorEnum getColor(){return this.color;}
 public String getState(){return this.state;}
 // Remember the player, does not represent real human
 // It is just a data container. So, it will never collab with input, only the controller will do that (atleast for now, when all the players are playing on same laptop)
 public void move(Piece p, Cell newPos){p.move(newPos);}
}
