public class Player{
 /*Knows*/
 private ColorEnum color;
 private Piece [] pieces;
 private String state; //won or not 
 /*Does*/
 public ColorEnum getColor(){}
 public String getState(){}
 // Remember the player, does not represent real human
 // It is just a data container. So, it will never collab with input, only the controller will do that (atleast for now, when all the players are playing on same laptop)
 public void move(Piece p, Cell newPos){}
}
