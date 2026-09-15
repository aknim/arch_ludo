import java.util.ArrayList;
import java.util.HashMap;
public class Map{
 private HashMap<Cell, Cell> commonPath;
 private ArrayList<HashMap<Cell, Cell>> playerYards;
 private ArrayList<HashMap<Cell, Cell>> homeColumns;

 private Cell [] homeTriangles;
 private ColorEnum [] givenColors;
 public Map(ColorEnum [] colors){
  givenColors = colors.clone();
  initiateHomeTriangles();
  initiateHomeColumns(); 

  for(int i=0;i<colors.length;i++){
   Cell first = new Cell(CellEnum.STARTSPACE, colors[i]);
   
  }
 }
 private void initiateHomeTriangles(){
  homeTriangles = new Cell[givenColors.length]; 
  for(int i=0;i<givenColors.length;i++){
   homeTriangles[i] = new Cell(CellEnum.HOMETRIANGLE, givenColors[i]);  
  }
 }
 private void initiateHomeColumns(){
  CellEnum cellType = CellEnum.HOMECOLUMN;
  homeColumns = new ArrayList<HashMap<Cell, Cell>>();
  for(int i=0;i<givenColors.length;i++){
    ColorEnum color = givenColors[i];
    Cell next = homeTriangles[i];
    HashMap<Cell, Cell> tmp = new HashMap<Cell, Cell>();
    for(int j=0;j<=5;j++){
     Cell curr = new Cell(cellType, color);
     tmp.put(curr, next);
     next = curr;
    }
    homeColumns.add(tmp);
  } 
 }
 public Cell getNextCell(Cell c, ColorEnum col){
  if(c.getType()==CellEnum.HOMETRIANGLE){return null;}
  else if(c.getType()==CellEnum.HOMECOLUMN){
   return homeColumns.get(getColIndex(col)).get(c);
  }
  return null;  
 }
 private int getColIndex( ColorEnum col){
  for(int i=0;i<givenColors.length;i++){
   if (givenColors[i] == col) return i;
  }  
  return -1;
 }
}
