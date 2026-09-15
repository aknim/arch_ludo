public class Piece{
/*Knows*/
 private Cell position;
 private ColorEnum color;
/*Does*/
 public Piece(ColorEnum color, Cell position){this.position = position; this.color = color;}
 public void move(Cell newPos){this.position = newPos;}
}
