public class Controller{
 private InputListener inp;
 private DisplayPanel disp;
 private Dice dice;
 private Player [] players;
 private Map2D map;

 public Controller(Dice dice, DisplayPanel disp, InputListener inp, Map2D map, Player [] players){
  this.dice = dice; this.disp = disp; this.inp = inp; this.map = map; this.players = players;
 }
 public void start(){
  int i = 0;
  int l = players.length;
  while(true){
   for(;;i=(i+1)%l){
    Player currPlayer = players[i];
    ColorEnum playerColor = currPlayer.getColor();
    String in = inp.giveUserIn();
    while(in==null){in = inp.giveUserIn();}
   }
  } 
 }
}
