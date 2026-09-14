import java.util.Random;

public class Dice{
 private int faceCount;
 public Dice(int c){faceCount = c;}
 public int roll(){
  Random random = new Random();
  return random.nextInt(faceCount)+1;
 }
}
