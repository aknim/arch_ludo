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
    
    Piece [] pieceCopies = new Piece[players.length*4];
    for(int a = 0;a<players.length;a++){
     Player p = players[a];
     Piece [] onePlayerPieceCopies = p.getPiecesCopies();
     for(int b = 0;b<4;b++){
      pieceCopies[a*4+b] = onePlayerPieceCopies[b];  
     }
    }
    disp.updateGridFrame(map.getGridData(), pieceCopies); 
    while(in==null){
     in = inp.giveUserIn();
     if(in!=null)System.out.println(">>>>>>>>>"+in); 
    }
   } 
  } 
 }
}
