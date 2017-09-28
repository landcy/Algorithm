package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class GenerateParentheses22 {
	public static List<String> generateParenthesis(int n) {
		HashSet<String> set = generateOneByOne(n);
		List<String> result = new ArrayList<String>(set);
		return result;
	}

	private static HashSet<String> generateOneByOne(int n) {
		HashSet<String> result = new HashSet<String>();
		if (n <= 0) {
			return result;
		}
		if (n == 1) {
			result.add("()");
			return result;
		}
		HashSet<String> set = generateOneByOne(n - 1);
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			result.add("()" + str);
			result.add(str + "()");
			result.add("(" + str + ")");
		}
		return result;
	}

	public static void main(String[] args) {
		List<String> result = generateParenthesis(0);
		for (String str : result) {
			System.out.println(str);
		}
	}
}
