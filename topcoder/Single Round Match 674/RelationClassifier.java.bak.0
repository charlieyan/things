import java.io.*;
import java.util.*;

public class RelationClassifier {
    String bijection = "Bijection";
    String not = "Not";
	public String isBijection(int[] domain, int[] range) {
        // walk through each element in domain, get key
        Map<Integer, Integer> domainMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> rangeMap  = new HashMap<Integer, Integer>();
        for (int i = 0; i < domain.length; ++i) {
            Integer v = domainMap.get(domain[i]);
            if (v != null) {
                if (v != range[i]) {
                    return not;
                }
            }
            domainMap.put(domain[i], range[i]);
        }
        for (int i = 0; i < range.length; ++i) {
            Integer v = rangeMap.get(range[i]);
            if (v != null) {
                if (v != domain[i]) {
                    return not;
                }
            }
            rangeMap.put(range[i], domain[i]);
        }
		return bijection;
	}

// CUT begin
	public static void main(String[] args){
		System.err.println("RelationClassifier (250 Points)");
		System.err.println();
		HashSet<Integer> cases = new HashSet<Integer>();
        for (int i = 0; i < args.length; ++i) cases.add(Integer.parseInt(args[i]));
        runTest(cases);
	}

	static void runTest(HashSet<Integer> caseSet) {
	    int cases = 0, passed = 0;
	    while (true) {
	    	String label = Reader.nextLine();
	    	if (label == null || !label.startsWith("--"))
	    		break;

            int[] domain = new int[Integer.parseInt(Reader.nextLine())];
            for (int i = 0; i < domain.length; ++i)
                domain[i] = Integer.parseInt(Reader.nextLine());
            int[] range = new int[Integer.parseInt(Reader.nextLine())];
            for (int i = 0; i < range.length; ++i)
                range[i] = Integer.parseInt(Reader.nextLine());
            Reader.nextLine();
            String __answer = Reader.nextLine();

            cases++;
            if (caseSet.size() > 0 && !caseSet.contains(cases - 1))
                continue;
    		System.err.print(String.format("  Testcase #%d ... ", cases - 1));

            if (doTest(domain, range, __answer))
                passed++;
	    }
	    if (caseSet.size() > 0) cases = caseSet.size();
        System.err.println(String.format("%nPassed : %d/%d cases", passed, cases));

        int T = (int)(System.currentTimeMillis() / 1000) - 1448936067;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format("Time   : %d minutes %d secs%nScore  : %.2f points", T / 60, T % 60, 250 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))));
	}

	static boolean doTest(int[] domain, int[] range, String __expected) {
		long startTime = System.currentTimeMillis();
		Throwable exception = null;
		RelationClassifier instance = new RelationClassifier();
		String __result = "";
		try {
			__result = instance.isBijection(domain, range);
		}
		catch (Throwable e) { exception = e; }
		double elapsed = (System.currentTimeMillis() - startTime) / 1000.0;

		if (exception != null) {
			System.err.println("RUNTIME ERROR!");
			exception.printStackTrace();
			return false;
		}
		else if (__expected.equals(__result)) {
			System.err.println("PASSED! " + String.format("(%.2f seconds)", elapsed));
			return true;
		}
		else {
			System.err.println("FAILED! " + String.format("(%.2f seconds)", elapsed));
			System.err.println("           Expected: " + "\"" + __expected + "\"");
			System.err.println("           Received: " + "\"" + __result + "\"");
			return false;
		}
	}

	static class Reader {
        private static final String dataFileName = "RelationClassifier.sample";
	    private static BufferedReader reader;

	    public static String nextLine() {
	        try {
                if (reader == null) {
                    reader = new BufferedReader(new InputStreamReader(new FileInputStream(dataFileName)));
                }
                return reader.readLine();
	        }
	        catch (IOException e) {
	            System.err.println("FATAL!! IOException");
	            e.printStackTrace();
	            System.exit(1);
	        }
	        return "";
	    }
	}
// CUT end
}
