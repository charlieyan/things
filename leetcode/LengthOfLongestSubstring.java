import java.util.*;

public class LengthOfLongestSubstring {

    public void insertInto(Map<Character, String> target, Character c, int idx, Queue<Character> q) {
        String existing = target.get(c);
        if (existing == null) {
            target.put(c, Integer.toString(idx));
            q.add(c);
        }
        else {
            String updated = existing + "_" + Integer.toString(idx);
            target.put(c, updated);
        }
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, String> occurences = new HashMap<Character, String>();
        Queue<Character> q = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); ++i) {
            Character c = s.charAt(i);
            insertInto(occurences, c, i, q);
        }
        int maxLength = 0;
        while (!q.isEmpty()) {
            Character k = q.remove();
            String v = occurences.get(k);
            String[] tokens = v.split("_");
            int[] idxs = new int[tokens.length];
            for (int i = 0; i < tokens.length; ++i) {
                idxs[i] = Integer.parseInt(tokens[i]);
            }

        }
        return maxLength;
    }

    public static void main(String[] args){
        String test1 = "abcab";
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring(test1));
    }
    // a : 0,3 length of 3 => 3
    // b : 1,4 length of 3
    // c : 2

    // abcdef
    // abcbefg
}