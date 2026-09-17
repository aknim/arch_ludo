public class Main{
 public static void main(String [] args){
  ColorEnum [] colors = new ColorEnum[4];
  int i = 0;
  for(ColorEnum color: ColorEnum.values()){
   colors[i] = color;
  }
  Composite c = new Composite(colors, 6, 4, "Ludo");
  c.start();
 }
}
