package ArrayMatrix;

import java.util.HashMap;

public class TwoSum1 {
	public static int[] twoSum(int[] nums, int target) {
		if (nums == null) {
			return null;
		}
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				result[0] = map.get(nums[i]);
				result[1] = i;
				return result;
			} else {
				int mins = target - nums[i];
				map.put(mins, i);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 17, 8, 9, 10, 11 };
		int sum = 80;
		int[] result = twoSum(nums, sum);
		if (result == null) {
			System.out.println("null");
		} else {
			System.out.println(result[0] + " " + result[1]);
		}
	}
}
