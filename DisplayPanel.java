import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

public class DisplayPanel extends JPanel{
 private final int TILE_SIZE = 25; //25x25 pixels
 private final int gridWidth, gridHeight;
 private Cell [][] grid;
 private String gameName;
 public DisplayPanel(Cell[][] grid, InputListener keyListener, String gameName){
  this.gridWidth = grid[0].length; this.gridHeight = grid.length; this.grid = grid; this.gameName = gameName;
  //canvas dimensions & background
  this.setPreferredSize(new Dimension(gridWidth * TILE_SIZE, gridHeight * TILE_SIZE));
  this.setBackground(Color.BLACK);
  this.setFocusable(true);

  this.addKeyListener(keyListener);

  //launch the OS frame window wrapper
  JFrame window = new JFrame(gameName);
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  window.add(this);
  window.pack();
  window.setLocationRelativeTo(null); //centers window on screen
  window.setVisible(true);
  this.requestFocusInWindow(); 
 }
 
 /** 
  * Receives the new state from the controller and schedules a canvas redraw
 */
 public void updateGridFrame(Cell[][] freshGrid){
  this.grid = freshGrid;
  this.repaint(); 
 }

 @Override
 protected void paintComponent(Graphics g){
  super.paintComponent(g);
  if(grid == null) return;

  //Paint the coordinates as colored blocks
  for (int y=0; y<gridHeight; y++){
   for (int x=0; x<gridWidth; x++){
    Cell cell = grid[y][x];
    CellEnum cellType = cell.getType();
    ColorEnum cellColor = cell.getColor();
    
    Color c = null;
    switch(cellColor){
     case ColorEnum.GREEN: c = Color.GREEN; break;
     case ColorEnum.RED: c = Color.RED; break;
     case ColorEnum.YELLOW: c = Color.YELLOW; break;
     case ColorEnum.BLUE: c = Color.BLUE; break;
     case ColorEnum.NOCOLOR: c = Color.WHITE; break;
    }
    if(cellType==CellEnum.YARD) fillYard(g, c, x, y);
   }
  }
 }
 private void fillYard(Graphics g, Color c, int x, int y){
  g.setColor(c);
  g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE-1, TILE_SIZE-1); 
  
 }
/* private void fillYard(x, y){}
 private void fillYard(x, y){}
 private void fillYard(x, y){}
 private void fillYard(x, y){}
 private void fillYard(x, y){} */
 /*private displayTimeBox dtb; private displayLevelBox dlb; private displayScoreBox dsb; private displayGameNameBox dgnb; private displayGridBox dgb; private displayInstructionsBox dib; 
 public mainDisplay(){ dtb = new displayTimeBox(); dlb = new displayLevelBox(); dsb = new displayScoreBox(); dgnb = new displayGameNameBox(); dgb = new displayGridBox(); dib = new displayInstructionsBox();}
 public void displayTime(String time){dtb.display(time);}
 public void displayLevel(int level){dlb.display(level);}
 public void displayScore(int score){dsb.display(score);}
 public void displayGameName(String name){dgnb.display(name);}
 public void displayGrid(String [][] grid){dgb.display(grid);}
 public void displayInstructions(String inst){dib.display(inst);}*/
 //public void display(String time, int level, int score, String gameName, String [][]grid, String userInst){displayGameName(gameName);displayTime(time); displayLevel(level); displayScore(score); displayGrid(grid); displayInstructions(userInst); }
 
}
