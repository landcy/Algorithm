package String;

public class JudgeRouteCircle657 {
	public static boolean judgeCircle(String moves) {
		if (moves == null || moves.length() <= 1) {
			return false;
		}
		int u = 0, l = 0, len = moves.length();
		for (int i = 0; i < len; i++) {
			char ch = moves.charAt(i);
			switch (ch) {
			case 'U':
				u++;
				break;
			case 'D':
				u--;
				break;
			case 'L':
				l++;
				break;
			case 'R':
				l--;
				break;
			default:
				return false;
			}
		}
		return u == 0 && l == 0;
	}

	public static void main(String[] args) {
		String[] tests = new String[] { "UDLS", "UUDD", "", "LDLRDUUR" };
		for (String moves : tests) {
			System.out.println(judgeCircle(moves));
		}
	}

}
