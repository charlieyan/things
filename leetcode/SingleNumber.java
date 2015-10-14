public class SingleNumber {
    public int singleNumber(int[] nums) {
        int compile = 0;
        for (int i = 0; i < nums.length; i++) {
            compile = compile ^ nums[i];
        }
        return compile;
    }

    public static void main(String[] args) {
        int[] temp = {2,3,7,2,3,4,5,4,5,6,6};
        SingleNumber s = new SingleNumber();
        int x = s.singleNumber(temp);
        System.out.println(x);
    }
}