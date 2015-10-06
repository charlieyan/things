public class MoveZeroes {
  public void moveZeroes(int[] nums) {
    int swapPlace = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] != 0) {
        nums[swapPlace] = nums[i];
        if (swapPlace != i) {
          nums[i] = 0;
        }
        swapPlace = swapPlace + 1;
      }
    }
  }

  public static void main(String[] args) {
    int[] temp = {1,0,0,2,3};
    MoveZeroes s = new MoveZeroes();
    s.moveZeroes(temp);
    for (int i = 0; i < 5; i++) {
      System.out.println(temp[i]);
    }
  }
}