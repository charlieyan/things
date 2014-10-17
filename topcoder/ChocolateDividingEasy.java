// SRM 636 DIV 1 250

public class ChocolateDividingEasy {

  public int sumUp(int[][] choco, int[] piece) {
    int s = 0;
    for (int i = piece[0]; i < piece[1]; i++) {
      for (int j = piece[2]; j < piece[3]; j++) {
        s = s + choco[i][j];
      }
    }
    return s;
  }

  public int findBest(String[] chocolate) {
   
    //seed the 2d array with qualities
    int[][] choco = new int[50][50];
    
    int numRows = chocolate.length;
    int numCols = chocolate[0].length();
    
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        choco[i][j] = chocolate[i].charAt(j) - '0';
      }
    }
    
    // brute force it!
    int max = -1;
    for (int i = 1; i < numRows; i++) {
      for (int i2 = i+1; i2 < numRows; i2++) {
        for (int j = 0; j < numCols; j++) {
          for (int j2 = j+1; j2 < numCols; j2++) {
            //compute minimum of 9 qualities
            int min = sumUp(choco, new int[]{0, i, 0, j});
            min = Math.min(min, sumUp(choco, new int[]{0, i, j, j2}));
            min = Math.min(min, sumUp(choco, new int[]{0, i, j2, numCols}));
            min = Math.min(min, sumUp(choco, new int[]{i, i2, 0, j}));
            min = Math.min(min, sumUp(choco, new int[]{i, i2, j, j2}));
            min = Math.min(min, sumUp(choco, new int[]{i, i2, j2, numCols}));
            min = Math.min(min, sumUp(choco, new int[]{i2, numRows, 0, j}));
            min = Math.min(min, sumUp(choco, new int[]{i2, numRows, j, j2}));
            min = Math.min(min, sumUp(choco, new int[]{i2, numRows, j2, numCols}));
            max = Math.max(min, max);
          }
        }
      }
    }
    
    return max;
  } 
}