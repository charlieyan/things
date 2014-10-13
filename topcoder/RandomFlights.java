import java.lang.String;
import java.lang.Math;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Random;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class RandomFlights {

  public static HashSet<String> solutions;

  public double expectedDistance(int[] x, int[] y, String[] flight) {
    solutions = new HashSet<String>();
  
    BitSet visited = new BitSet(x.length);
    List<Integer> reachable = new ArrayList<Integer>();
    HashSet<Integer> unReachable = new HashSet<Integer>();
    
    Queue<Integer> aQueue = new LinkedBlockingQueue<Integer>();
    aQueue.add(0);
    while (!aQueue.isEmpty()) {
      Integer idx = aQueue.remove();
      visited.set(idx);
      reachable.add(idx);
      // look at flight at i, get all 1's and enqueue them
      String temp = flight[idx];
      for (int i = 0; i < temp.length(); i++) {
        if (i == idx) { continue; };
        if (temp.charAt(i) == '1' && !visited.get(i)) {
          aQueue.add(i);
        }
      }
    }
  
  // walk through the airports, trying to go from 0 to 1, if you find 1, compare to smallest
  BitSet seed = new BitSet(x.length);
  seed.set(0);
  HashMap<Integer,Double> result = minDistance(flight, x, y, unReachable, "0", seed, 0, 0.0, false);
  
  // average out result's true, compare it to result's false
    if (result.keySet().contains(1)) {
    double avg = result.get(1) / result.get(2);
    if (result.keySet().contains(0)) {
      System.out.println("HAS BOTH");
      return result.get(0);
    }
    System.out.println("HAS AVG");
    System.out.println(result.get(2));
    System.out.println(result.get(1));
    return avg;
    }
    System.out.println("HAS MIN");
    return result.get(0);
  }
  
  public double edistance(int x1, int y1, int x2, int y2) {
    return Math.sqrt( Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
  }
  
  // mode is to average or to seek minimum
  public HashMap<Integer,Double> minDistance(String[] flight, int[] x, int[] y, HashSet<Integer> unReachable, String path, BitSet b, int latest, double current, boolean mode) {
    if (latest == 1) {
      System.out.println(current);
      HashMap<Integer,Double> e = new HashMap<Integer,Double>();
      Integer q = (mode) ? 1 : 0;
      e.put(q, current);
      e.put(2, 1.0);
      solutions.add(path);
      System.out.println(solutions);
      return e;
    }
    BitSet comp = new BitSet(x.length);
    comp.set(0);
    String temp = flight[latest];
    double falseSmallest = 0.0; boolean falseSet = false; 
    double g1 = 0.0; boolean trueSet = false;
    double t1 = 0.0;
    for (int j = 0; j < temp.length(); j++) {
      if (!b.get(j) && j != latest ) {
        BitSet b2 = (BitSet) b.clone();
        b2.set(j);
        String u = path + "->" + Integer.toString(j);
        System.out.println("wanting " + b2);
        if (solutions.contains(b2) && b2 != comp) {
          continue;
        }
        boolean newMode = ((temp.charAt(j) != '1')) ? true : false;
        newMode = newMode || mode;
        double t = edistance(x[latest], y[latest], x[j], y[j]);
        System.out.println("Calling: " + b2 + " and latest: " + j + "and newMode " + newMode);
        HashMap<Integer,Double> newSmall = minDistance(flight, x, y, unReachable, u, b2, j, current + t, newMode);
        
        if (newSmall.keySet().contains(0)) {
        double falseSmall = newSmall.get(0);
        if (!falseSet) {
          falseSmallest = falseSmall;
          falseSet = true;
        }
        else {
          if (falseSmall < falseSmallest) {
            falseSmallest = falseSmall;
          }
        }
        }
        
        if (newSmall.keySet().contains(1)) {
          trueSet = true;
          g1 = g1 + newSmall.get(1);
          t1 = t1 + newSmall.get(2);
        }
      }
    }
    HashMap<Integer,Double> f = new HashMap<Integer,Double>();
    if (falseSet) {
      f.put(0, falseSmallest);
    }
    if (trueSet) {
      f.put(1, g1);
      f.put(2, t1);
    }
    return f;
  }
}