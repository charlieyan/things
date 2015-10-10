import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, String> m = new HashMap<Integer, String>();
        for (int i = 0; i < nums.length; ++i) {
            String existing = m.get(nums[i]);
            String p = Integer.toString(i) + "_" + Integer.toString(target-nums[i]);
            if (existing == null) {
                m.put(nums[i], p);
            }
            else {
                existing = existing + ":" + p;
                m.put(nums[i], existing);
            }
        }
        Iterator<Map.Entry<Integer,String>> iterator = m.entrySet().iterator();
        int[] result = new int[2];
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            String v = entry.getValue();
            String[] ps = v.split(":");
            for (int i = 0; i < ps.length; ++i) {
                String p = ps[i];
                String[] vTokens = p.split("_");
                int idx = Integer.parseInt(vTokens[0]);
                int targetDiff = Integer.parseInt(vTokens[1]);
                String v2 = m.get(targetDiff);
                if (v2 != null) {
                    String[] ps2 = v2.split(":");
                    for (int j = 0; j < ps2.length; ++j) {
                        String p2 = ps2[j];
                        String[] v2Tokens = p2.split("_");
                        int idx2 = Integer.parseInt(v2Tokens[0]);
                        if (idx2 != idx) {
                            result[0] = (idx < idx2) ? idx + 1 : idx2 + 1;
                            result[1] = (idx < idx2) ? idx2 + 1 : idx + 1;
                            return result;
                        }
                    }
                }
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