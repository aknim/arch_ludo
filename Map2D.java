public class Map2D{
 Cell [][] grid;
 public Map(){
  grid = new Cell[17][17];
  int i = 0; int j = 0;

  //entire space
  for(i=0;i<grid.length;i++){
   for(j=0;j<grid[i].length;j++) grid[i][j] = new Cell(CellEnum.EMPTY, ColorEnum.NOCOLOR); // empty
  }

  // boundary
  for(j=0;j<grid[i].length;j++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR); 
  i = 16; for(j=0;j<grid[i].length;j++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR);
  
  j = 0; for(i=0;i<grid.length;i++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR);
  j = 16; for(i=0;i<grid.length;i++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR);

  // PlayerYards
  grid[2][2] =   new Cell(CellEnum.YARD, ColorEnum.RED); 
  grid[2][4] =   new Cell(CellEnum.YARD, ColorEnum.RED); 
  grid[4][2] =   new Cell(CellEnum.YARD, ColorEnum.RED); 
  grid[4][4] =   new Cell(CellEnum.YARD, ColorEnum.RED); 

  grid[2][12] =   new Cell(CellEnum.YARD, ColorEnum.GREEN); 
  grid[2][14] =   new Cell(CellEnum.YARD, ColorEnum.GREEN); 
  grid[4][12] =   new Cell(CellEnum.YARD, ColorEnum.GREEN); 
  grid[4][14] =   new Cell(CellEnum.YARD, ColorEnum.GREEN); 

  grid[12][2] =   new Cell(CellEnum.YARD, ColorEnum.BLUE); 
  grid[12][4] =   new Cell(CellEnum.YARD, ColorEnum.BLUE); 
  grid[14][2] =   new Cell(CellEnum.YARD, ColorEnum.BLUE); 
  grid[14][4] =   new Cell(CellEnum.YARD, ColorEnum.BLUE); 

  grid[12][12] =   new Cell(CellEnum.YARD, ColorEnum.YELLOW); 
  grid[12][14] =   new Cell(CellEnum.YARD, ColorEnum.YELLOW); 
  grid[14][12] =   new Cell(CellEnum.YARD, ColorEnum.YELLOW); 
  grid[14][14] =   new Cell(CellEnum.YARD, ColorEnum.YELLOW);
 }
}
