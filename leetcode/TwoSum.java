import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, String> m = new HashMap<Integer, String>();
        for (int i = 0; i < nums.length; ++i) {
            m.put(nums[i], Integer.toString(i) + "_" + Integer.toString(target-nums[i]));
        }
        Iterator<Map.Entry<Integer,String>> iterator = m.entrySet().iterator();
        int[] result = new int[2];
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            String v = entry.getValue();
            String[] vTokens = v.split("_");
            int targetDiff = Integer.parseInt(vTokens[1]);
            int idx = Integer.parseInt(vTokens[0]);
            String v2 = m.get(targetDiff);
            if (v2 != null) {
                String[] v2Tokens = v2.split("_");
                int idx2 = Integer.parseInt(v2Tokens[0]);
                result[0] = (idx < idx2) ? idx + 1 : idx2 + 1;
                result[1] = (idx < idx2) ? idx2 + 1 : idx + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {  
        // numbers={2, 7, 11, 15}, target=9
        int[] test1 = {2,7,11,15};
        TwoSum t = new TwoSum();
        int[] result = t.twoSum(test1, 18);
        System.out.println(Integer.toString(result[0]) + " " + Integer.toString(result[1]));

        int[] test2 = {0,4,3,0};
        result = t.twoSum(test2, 0);
        System.out.println(Integer.toString(result[0]) + " " + Integer.toString(result[1]));
    }
}