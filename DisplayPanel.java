import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

public class DisplayPanel extends JPanel{
 private final int TILE_SIZE = 25; //25x25 pixels
 private final int gridWidth, gridHeight;
 private String [][] activeGridFrame;
 private String gameName;
 public DisplayPanel(int w, int h, InputListener keyListener, String gameName){
  this.gridWidth = w; this.gridHeight = h; this.activeGridFrame = new String[h][w]; this.gameName = gameName;
  //canvas dimensions & background
  this.setPreferredSize(new Dimension(w * TILE_SIZE, h * TILE_SIZE));
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
 public void updateGridFrame(String[][] freshGrid){
  this.activeGridFrame = freshGrid;
  this.repaint(); 
 }

 @Override
 protected void paintComponent(Graphics g){
  super.paintComponent(g);
  if(activeGridFrame == null) return;

  //Paint the coordinates as colored blocks
  for (int y=0; y<gridHeight; y++){
   for (int x=0; x<gridWidth; x++){
    String cellValue = activeGridFrame[gridHeight-y-1][x];
    if(cellValue !=null){
     Color c = null;
     switch(cellValue){
      case "s": c = Color.GREEN; break;
      case "f": c = Color.RED; break;
      case "e": c = Color.WHITE; break;
      case "d": c = Color.GRAY; break;
     }
     g.setColor(c);
     g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE-1, TILE_SIZE-1); 
    }
   }
  }
 }
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
