package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses22 {
	public static List<String> generateParenthesis(int n) {
		List<List<String>> lists = new ArrayList<>();
		lists.add(Collections.singletonList(""));

		for (int i = 1; i <= n; ++i) {
			final List<String> list = new ArrayList<>();
			
			for (int j = 0; j < i; ++j) {
				for (final String first : lists.get(j)) {
					for (final String second : lists.get(i - 1 - j)) {
						list.add("(" + first + ")" + second);
					}
				}
			}

			lists.add(list);
		}

		return lists.get(lists.size() - 1);
	}
	

	public static void main(String[] args) {
		List<String> result = generateParenthesis(4);
		System.out.println("size : " + result.size());
		for (String str : result) {
			System.out.println(str);
		}
	}
}
