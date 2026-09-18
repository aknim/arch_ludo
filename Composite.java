public class Composite{
 Controller controller;
 public Composite(ColorEnum [] colors, int diceFaces, int numOfPiecesPerPlayer, String gameName){
  Map2D map = new Map2D();
  InputListener inputListener = new InputListener();
  controller = new Controller(new Dice(diceFaces), 
   new DisplayPanel(map.getGridData(), inputListener, gameName),
   inputListener, 
   map,
   composePlayers(colors, map));
 }
 private Player [] composePlayers(ColorEnum [] colors, Map2D map){
  Player [] players = new Player[colors.length];
  for(int i=0;i<players.length;i++){
   players[i] = new Player(colors[i], map.getPlayerYards(colors[i]));
  }
  return players;
 }
 public void start(){
  controller.start(); 
 }
}
