public class Piece{
/*Knows*/
 private Cell position;
 private ColorEnum color;
/*Does*/
 public Piece(ColorEnum color, Cell position){this.position = position; this.color = color;}
 public Piece(Piece piece){this.position = piece.position; this.color = piece.color;}
 public void move(Cell newPos){this.position = newPos;}
 public Coord getCoord(){ return position.getCoord();}
 public ColorEnum getColor(){return color;}
}
