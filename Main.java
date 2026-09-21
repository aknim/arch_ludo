public class Main{
 public static void main(String [] args){
  int numOfPlayers = 4;
  ColorEnum [] colors = new ColorEnum[numOfPlayers];
  int i = 0;
  for(ColorEnum color: ColorEnum.values()){
   colors[i++] = color; if(i==numOfPlayers) break; 
  }
  Composite c = new Composite(colors, 6, 4, "Ludo");
  c.start();
 }
}
