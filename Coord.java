public class Coord{
 private int x, y;
 public Coord(int a, int b){this.x = b; this.y = a;}
 public Coord(Coord a){this.x = a.getX(); this.y = a.getY();}
 public int getX(){return x;}
 public int getY(){return y;}
}
