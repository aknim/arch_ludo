import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class InputListener implements KeyListener{
 private String readUserIn;
 public InputListener(){readUserIn=null;}
 public String giveUserIn(){String ret = readUserIn; readUserIn = null; return ret; }
 @Override
 public void keyPressed(KeyEvent e){
  switch(e.getKeyCode()){
   case KeyEvent.VK_1 -> readUserIn = "1";
   case KeyEvent.VK_2 -> readUserIn = "2";
   case KeyEvent.VK_3 -> readUserIn = "3";
   case KeyEvent.VK_4 -> readUserIn = "4";
  }
  System.out.println(readUserIn);
 }

 @Override public void keyTyped(KeyEvent e){}
 @Override public void keyReleased(KeyEvent e){}
}
