import java.util.ArrayList;
import java.util.HashMap;
public class Map{
 private ArrayList<HashMap<Cell, Cell>> commonSections;
 private ArrayList<HashMap<Cell, Cell>> homeColumns;
 private Cell [] homeColumnStarts;

 private ColorEnum [] givenColors;
 private int numOfPieces;
 
 private Cell [] homeTriangles;
 private Cell [][] playerYards;
 private Cell [] playerStarts;
 private Cell [] trackStars;
 private Cell [] turningPoints;
 public Cell [] getPlayerYards(ColorEnum color){
  int colorIndex = getColIndex(color);
  return playerYards[colorIndex];
 }
 public Map(ColorEnum [] colors, int numOfPieces){
  givenColors = colors.clone();
  this.numOfPieces = numOfPieces;

  initiatePlayerYards();
  
  initiatePlayerStarts();

  initiateTrackStars();
  initiateTurningPoints();

  initiateCommonSections();

  initiateHomeTriangles();
  initiateHomeColumns(); 


  for(int i=0;i<colors.length;i++){
   Cell first = new Cell(CellEnum.STARTSPACE, colors[i]);
   
  }
 }
 private void initiatePlayerYards(){
  playerYards = new Cell[givenColors.length][numOfPieces]; 
  for(int i=0;i<givenColors.length;i++){
   for(int j=0;j<numOfPieces;j++){
    playerYards[i][j] = new Cell(CellEnum.YARD, givenColors[i]);  
   }
  }
 }
 private void initiatePlayerStarts(){
  playerStarts = new Cell[givenColors.length]; 
  for(int i=0;i<givenColors.length;i++){
   playerStarts[i] = new Cell(CellEnum.STARTSPACE, givenColors[i]);  
  }
 }
 private void initiateCommonSections(){
  commonSections = new ArrayList<HashMap<Cell, Cell>>();
  for(int i=0;i<givenColors.length;i++){
   Cell tmpCurr = playerStarts[i];
   commonSections.add(new HashMap<Cell, Cell>()); 
   for(int j=1;j<=7;j++){
    Cell tmpNew = new Cell(CellEnum.NORMALSPACE, givenColors[i]);
    commonSections.get(i).put(tmpCurr, tmpNew); 
    tmpCurr = tmpNew; 
   }
    commonSections.get(i).put(tmpCurr, trackStars[i]); tmpCurr = trackStars[i];
   for(int j=1;j<=2;j++){
    Cell tmpNew = new Cell(CellEnum.NORMALSPACE, givenColors[i]);
    commonSections.get(i).put(tmpCurr, tmpNew); 
    tmpCurr = tmpNew; 
   }
    commonSections.get(i).put(tmpCurr, turningPoints[i]); tmpCurr = turningPoints[i];
    Cell tmpNew = new Cell(CellEnum.NORMALSPACE, givenColors[i]);
    commonSections.get(i).put(tmpCurr, tmpNew); tmpCurr = tmpNew; 
    Cell nextPlayerStart =  playerStarts[(i+1)%(givenColors.length)];
    commonSections.get(i).put(tmpCurr, nextPlayerStart); tmpCurr = nextPlayerStart;
  }
 }
 private void initiateTrackStars(){
  trackStars = new Cell[givenColors.length]; 
  for(int i=0;i<givenColors.length;i++){
   trackStars[i] = new Cell(CellEnum.STARSPACE, givenColors[i]);  
  }
 }
 private void initiateTurningPoints(){
  turningPoints = new Cell[givenColors.length]; 
  for(int i=0;i<givenColors.length;i++){
   turningPoints[i] = new Cell(CellEnum.TURNINGPOINT, givenColors[i]);  
  }
 }
 private void initiateHomeColumns(){
  homeColumnStarts = new Cell[givenColors.length];
  CellEnum cellType = CellEnum.HOMECOLUMN;
  homeColumns = new ArrayList<HashMap<Cell, Cell>>();
  for(int i=0;i<givenColors.length;i++){
    ColorEnum color = givenColors[i];
    Cell next = homeTriangles[i];
    HashMap<Cell, Cell> tmp = new HashMap<Cell, Cell>();
    for(int j=0;j<=5;j++){
     Cell curr = new Cell(cellType, color);
     if(j==0) homeColumnStarts[i] = curr;
     tmp.put(curr, next);
     next = curr;
    }
    homeColumns.add(tmp);
  } 
 }
 private void initiateHomeTriangles(){
  homeTriangles = new Cell[givenColors.length]; 
  for(int i=0;i<givenColors.length;i++){
   homeTriangles[i] = new Cell(CellEnum.HOMETRIANGLE, givenColors[i]);  
  }
 }

 private Cell getNextFromCommonSections(Cell c, ColorEnum pieceColor){
  int playerColorIndex = getColIndex(pieceColor);
  ColorEnum cellColor = c.getColor();
  int cellColorIndex = getColIndex(cellColor);
  return (commonSections.get(cellColorIndex)).get(c); 
 }
 public Cell getNextCell(Cell c, ColorEnum pieceColor){
  int playerColorIndex = getColIndex(pieceColor);
  CellEnum cellType = c.getType();
  ColorEnum cellColor = c.getColor();
  int cellColorIndex = getColIndex(cellColor);
  
  switch(cellType){
   case CellEnum.YARD: return playerStarts[playerColorIndex];
   case CellEnum.STARTSPACE: return getNextFromCommonSections(c, pieceColor); 
   case CellEnum.NORMALSPACE: return getNextFromCommonSections(c, pieceColor);
   case CellEnum.STARSPACE: return getNextFromCommonSections(c, pieceColor);
   case CellEnum.TURNINGPOINT:  
     if(playerColorIndex == cellColorIndex) return homeColumnStarts[cellColorIndex];
     else return getNextFromCommonSections(c, pieceColor);
   case CellEnum.HOMECOLUMN: homeColumns.get(cellColorIndex);
   case CellEnum.HOMETRIANGLE: return null;
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
