public class Cell{
 private CellEnum type;
 private ColorEnum color;
 private final int i, j;
 public Cell(CellEnum type, ColorEnum color, int i, int j){this.type = type; this.color = color; this.i = i; this.j = j;}
 public Cell(Cell cell){this.type = cell.type; this.color = cell.color; this.i = cell.i; this.j = cell.j;}
 public CellEnum getType(){return type;}
 public ColorEnum getColor(){return color;}
 public Coord getCoord(){return new Coord(i, j);}
}
