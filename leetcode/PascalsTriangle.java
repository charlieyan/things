import java.util.*;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
    	if (numRows < 1) {
    		return output;
    	}

        List<Integer> entry = new ArrayList<Integer>(); entry.add(1);
        for (int row = 1; row < numRows+1; ++row) {
        	output.add(entry);

        	// make the new entry
        	List<Integer> newEntry = new ArrayList<Integer>();
        	newEntry.add(1);
        	for (int i = 1; i < entry.size(); i++) {
        		int sum = entry.get(i-1) + entry.get(i);
        		newEntry.add(sum);
        	}
        	newEntry.add(1);
        	entry = newEntry;
        }

        return output;
    }

    public static void main(String[] args) {
    	PascalsTriangle pt = new PascalsTriangle();
    	List<List<Integer>> output = pt.generate(4);

    	for (int i = 0; i < output.size(); i++) {
    		List<Integer> entry = output.get(i);
    		System.out.println("entry:");
    		String x = "";
    		for (int j = 0; j < entry.size(); j++) {
    			int e = entry.get(j);
    			x += Integer.toString(e) + " ";
    		}
    		System.out.println(x);
    	}
    }
}