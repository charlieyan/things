public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int head = 1;
        for (int i = 1; i < nums.length; ++i) {
        	int diff = nums[i] - nums[i-1];
        	if (diff != 0) {
        		count = count + 1;
        		nums[head] = nums[i];
        		head = head + 1;
        	}
        }
        return count;
    }

    public static void main(String[] args) {
    	RemoveDuplicates r = new RemoveDuplicates();
    	System.out.println(r.removeDuplicates([1,1,2,3]));
    }
}