import java.lang.String;

public class BrightLamps {

  // largest toggling
  public int maxBrightness(String init, int[] a, int K) {
    int initialSum = applyStateSum(init, a);
    
    // move the sliding window of K length, see difference, find greatest difference and apply
    int greatestDiff = 0;
    for (int i = 0; i < init.length()-K; i++) {
      int diff = computeDiff(init, a, K, i);
      if (diff > greatestDiff) {
        greatestDiff = diff;
      }
    }
    
    return initialSum + greatestDiff;
  }
  
  public int applyStateSum(String init, int[] a) {
    int result = 0;
    for (int i = 0; i < init.length(); i++) {
      if (init.charAt(i) == '1') {
        result = result + a[i];
      }
    }
    return result;
  }
  
  public int computeDiff(String init, int[] a, int K, int start) {
    int result = 0;
    for (int i = 0; i < K; i++) {
      if (init.charAt(start+i) == '0') {
        result = result + a[start+i];
      }
      else {
        result = result - a[start+i];
      }
    }
    return result;
  }
}