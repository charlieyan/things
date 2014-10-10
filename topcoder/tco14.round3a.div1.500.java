import java.lang.String;
import java.util.ArrayList;

class Airport { 

  public ArrayList<int> directFlights;
  public int i;
  public int x;
  public int y;
  
  public Airport(int i, int x, int y, String[] flight) {
    this.i = i;
    this.x = x;
    this.y = y;
    for (int j = 0; j < flight.length(); j++) {
      if (j == i) { continue; }
      if (1 == Integer.valueOf(flight[j].charAt(i))) {
        reachable.push(j);
      }
    }
  }  

}

public class RandomFlights {

  public double expectedDistance(int[] x, int[] y, String[] flight) {
    // first we need to see which airports are not reachable
    double result = 0.0;
    // 
    return result;
  }
}