public class Map2D{
 Cell [][] grid;
 public Cell [][] getGridData(){
  Cell [][] tmpGrid = new Cell[grid.length][grid[0].length];
  for(int i=0;i<grid.length;i++){
   for(int j=0;j<grid[0].length;j++){
    tmpGrid[i][j] = new Cell(grid[i][j]);
   }
  }
  return tmpGrid;
 } 
 public Map2D(){
  grid = new Cell[17][17];
  int i = 0; int j = 0;

  //entire space
  for(i=0;i<grid.length;i++){
   for(j=0;j<grid[i].length;j++) grid[i][j] = new Cell(CellEnum.EMPTY, ColorEnum.NOCOLOR); // empty
  }
  i=0; j=0;
  // boundary
  //System.out.println(i);
  //System.out.println(grid[i].length);  
  for(j=0;j<grid[i].length;j++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR); 
  i = 16; for(j=0;j<grid[i].length;j++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR);
  
  j = 0; for(i=0;i<grid.length;i++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR);
  j = 16; for(i=0;i<grid.length;i++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR);

   i=6; for(j=1;j<=6;j++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR); 
   i=10; for(j=1;j<=6;j++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR);
 
   i=6; for(j=10;j<=15;j++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR); 
   i=10; for(j=10;j<=15;j++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR);

 
   j=6; for(i=1;i<=6;i++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR); 
   j=10; for(i=1;i<=6;i++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR);
 
   j=6; for(i=10;i<=15;i++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR); 
   j=10; for(i=10;i<=15;i++) grid[i][j] = new Cell(CellEnum.DEAD, ColorEnum.NOCOLOR); 

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

  // CommonPaths
  i=7; for(j=1;j<=6;j++) grid[i][j] = new Cell(CellEnum.NORMALSPACE, ColorEnum.RED); grid[7][2] = new Cell(CellEnum.STARTSPACE, ColorEnum.RED);
  i=7; for(j=10;j<=15;j++) grid[i][j] = new Cell(CellEnum.NORMALSPACE, ColorEnum.GREEN); grid[7][13] = new Cell(CellEnum.STARSPACE, ColorEnum.GREEN);
  i=9; for(j=1;j<=6;j++) grid[i][j] = new Cell(CellEnum.NORMALSPACE, ColorEnum.BLUE); grid[9][3] = new Cell(CellEnum.STARSPACE, ColorEnum.BLUE);
  i=9; for(j=10;j<=15;j++) grid[i][j] = new Cell(CellEnum.NORMALSPACE, ColorEnum.YELLOW); grid[9][14] = new Cell(CellEnum.STARTSPACE, ColorEnum.YELLOW);

  j=7; for(i=1;i<=6;i++) grid[i][j] = new Cell(CellEnum.NORMALSPACE, ColorEnum.RED); grid[3][7] = new Cell(CellEnum.STARSPACE, ColorEnum.RED);
  j=7; for(i=10;i<=15;i++) grid[i][j] = new Cell(CellEnum.NORMALSPACE, ColorEnum.BLUE); grid[14][7] = new Cell(CellEnum.STARTSPACE, ColorEnum.BLUE);
  j=9; for(i=1;i<=6;i++) grid[i][j] = new Cell(CellEnum.NORMALSPACE, ColorEnum.GREEN); grid[2][9] = new Cell(CellEnum.STARTSPACE, ColorEnum.GREEN);
  j=9; for(i=10;i<=15;i++) grid[i][j] = new Cell(CellEnum.NORMALSPACE, ColorEnum.YELLOW); grid[13][9] = new Cell(CellEnum.STARSPACE, ColorEnum.YELLOW);

 // TurningPoints
  grid[8][1] = new Cell(CellEnum.TURNINGPOINT, ColorEnum.RED);
  grid[8][15] = new Cell(CellEnum.TURNINGPOINT, ColorEnum.YELLOW);
  grid[1][8] = new Cell(CellEnum.TURNINGPOINT, ColorEnum.GREEN);
  grid[15][8] = new Cell(CellEnum.TURNINGPOINT, ColorEnum.BLUE);

 //HomeColumns
   i=8; for(j=2;j<=6;j++) grid[i][j] = new Cell(CellEnum.HOMECOLUMN, ColorEnum.RED); 
   i=8; for(j=10;j<=14;j++) grid[i][j] = new Cell(CellEnum.HOMECOLUMN, ColorEnum.YELLOW); 
   j=8; for(i=2;i<=6;i++) grid[i][j] = new Cell(CellEnum.HOMECOLUMN, ColorEnum.GREEN); 
   j=8; for(i=10;i<=14;i++) grid[i][j] = new Cell(CellEnum.HOMECOLUMN, ColorEnum.BLUE); 

 // HomeTriangle
  grid[7][8] = new Cell(CellEnum.HOMETRIANGLE, ColorEnum.GREEN);
  grid[9][8] = new Cell(CellEnum.HOMETRIANGLE, ColorEnum.BLUE);
  grid[8][7] = new Cell(CellEnum.HOMETRIANGLE, ColorEnum.RED);
  grid[8][9] = new Cell(CellEnum.HOMETRIANGLE, ColorEnum.YELLOW);

 }
 public Cell getNextCell(int i, int j, ColorEnum playerColor){
  Cell curr = grid[i][j];
  CellEnum cellType = curr.getType();
  ColorEnum colorType = curr.getColor();
  Cell next = null;
  switch(cellType){
   case CellEnum.HOMETRIANGLE: next = null; break;
   case CellEnum.HOMECOLUMN:
    if(colorType == ColorEnum.RED) return nextCell(i, j, "rt");
    else if(colorType == ColorEnum.YELLOW) return nextCell(i, j, "lt");
    else if(colorType == ColorEnum.GREEN) return nextCell(i, j, "dn");
    else if(colorType == ColorEnum.BLUE) return nextCell(i, j, "up");
    return null;
   case CellEnum.TURNINGPOINT:
    if(colorType == playerColor){
     if(colorType == ColorEnum.RED) return nextCell(i, j, "rt");
     else if(colorType == ColorEnum.YELLOW) return nextCell(i, j, "lt");
     else if(colorType == ColorEnum.GREEN) return nextCell(i, j, "dn");
     else if(colorType == ColorEnum.BLUE) return nextCell(i, j, "up");
     return null;
    }
    else{
     if(colorType == ColorEnum.RED) return nextCell(i, j, "up");
     else if(colorType == ColorEnum.YELLOW) return nextCell(i, j, "dn");
     else if(colorType == ColorEnum.GREEN) return nextCell(i, j, "rt");
     else if(colorType == ColorEnum.BLUE) return nextCell(i, j, "lt");
     return null;
    }
   case CellEnum.STARSPACE:
    if(colorType == ColorEnum.RED) return nextCell(i, j, "up");
    else if(colorType == ColorEnum.YELLOW) return nextCell(i, j, "dn");
    else if(colorType == ColorEnum.GREEN) return nextCell(i, j, "rt");
    else if(colorType == ColorEnum.BLUE) return nextCell(i, j, "lt");
    return null;
   case CellEnum.STARTSPACE:
    if(colorType == ColorEnum.RED) return nextCell(i, j, "rt");
    else if(colorType == ColorEnum.YELLOW) return nextCell(i, j, "lt");
    else if(colorType == ColorEnum.GREEN) return nextCell(i, j, "dn");
    else if(colorType == ColorEnum.BLUE) return nextCell(i, j, "up");
    return null;
   case CellEnum.YARD:
    if(colorType == ColorEnum.RED) return grid[7][2];
    else if(colorType == ColorEnum.YELLOW) return grid[9][14];
    else if(colorType == ColorEnum.GREEN) return grid[2][9];
    else if(colorType == ColorEnum.BLUE) return grid[14][7];
    return null;
  }
  return null;
 }
 private Cell nextCell(int i, int j, String dir){
  switch(dir){
   case("up"): return grid[i-1][j];
   case("dn"): return grid[i+1][j];
   case("rt"): return grid[i][j+1];
   case("ln"): return grid[i][j-1];
  }
  return null;
 }
 public Cell [] getPlayerYards(ColorEnum col){
  switch(col){
   case ColorEnum.RED: return new Cell[]{grid[2][2], grid[2][4], grid[4][2], grid[4][4]};
   case ColorEnum.GREEN: return new Cell[]{grid[2][12], grid[2][14], grid[4][12], grid[4][14]};
   case ColorEnum.BLUE: return new Cell[]{grid[12][2], grid[12][4], grid[14][2], grid[14][4]};
   case ColorEnum.YELLOW: return new Cell[]{grid[12][12], grid[12][14], grid[14][12], grid[14][14]};
  }
  return null; 
 }
}
