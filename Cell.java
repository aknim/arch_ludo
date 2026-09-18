public class Cell{
 private CellEnum type;
 private ColorEnum color;
 public Cell(CellEnum type, ColorEnum color){this.type = type; this.color = color;}
 public Cell(Cell cell){this.type = cell.type; this.color = cell.color;}
 public CellEnum getType(){return type;}
 public ColorEnum getColor(){return color;}
}
