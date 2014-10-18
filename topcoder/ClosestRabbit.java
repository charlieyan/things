import java.lang.Math;
import java.util.HashMap;
import java.util.ArrayList;

public class ClosestRabbit {

  public HashMap<String, Integer> freeSpaces;

  public double getExpected(String[] board, int r) {
    // consume data
    int rows = board.length;
    int cols = board[0].length();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.println("CHARLIE: " + board[i].charAt(j));
        if (board[i].charAt(j) == '#') {
           System.out.println("filled");
        }
        else {
          System.out.println("empty");
          String k = freeSpacesEncode(i,j);
          freeSpaces.put(k,-1); // coordinate, rabit
        }
      }
    }
    

    return 0;
  }

  public ArrayList<ArrayList<Integer>> allRabitCombiantions(int[] freeSpaces, int start, int numRabbits) {
    // recursive solution to find freeSpaces choose numRabbits, assume that freeSpaces.length >= numRabbits

    // freeSpaces.length - start >= numRabbits the 'subarray' is start..freeSpaces.length = freeSpaces.length-1 - start + 1
    if ((freeSpaces.length - start) < numRabbits) {
      return null;
    }

    // base case: numRabbits is 1
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> ffunct = new ArrayList<ArrayList<Integer>>();
    if (numRabbits == 1) {
      for (int i = 0; i < freeSpaces.length; i++) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(i);
        result.add(temp);
      }
      return result;
    }

    // iterate through freeSpaces, get freeSpaces 
    for (int i = start; i < freeSpaces.length; i++) {
      ArrayList<ArrayList<Integer>> r = allRabitCombiantions(freeSpaces, i+1, numRabbits-1);
      for (int j = 0; j < r.size(); j++) {
        r.get(j).add(0,freeSpaces[i]);
        ArrayList<Integer> f = setFFunct(r.get(j));
        result.add(r.get(j).concat(f));
      }
    }
    return result;
  }

  public ArrayList<Integer> setFFunct

  public double edistance(int x1, int y1, int x2, int y2) {
    return Math.sqrt( Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
  }

  public String freeSpacesEncode(int r, int c) {
    return Integer.toString(r) + "_" + Integer.toString(c);
  }

  public int[] freeSpacesDecode(String k) {
    String[] x = k.split("_");
    int[] result = new int[2];
    result[0] = Integer.valueOf(x[0]);
    result[1] = Integer.valueOf(x[1]);
    return result;
  }
}