package cn.edu.bit.lemondy.leetcode.medium;

import java.util.Arrays;

/**
 * 
 * @author lemondy
 * problem: 
 * 			给一个数组，判断数组中是否有三个元素之和等于0，返回三元组的个数
 * solution1:
 * 			利用三层for循环，依次遍历。查看是否存在三个元素满足要求。复杂度：O(n*n*n)
 * solution2:
 * 			先排序，两层for循环，在用一种搜素算法，查找是否存在另外一个数。复杂度：O(n*n*logn)
 * solution3:
 * 			先排序 ，然后同时从左边和右边进行查找数字, O(n*n)
 * 			
 */

public class ThreeNumSum {
	public static int solution1(int nums[], int target) {
		if (nums == null || nums.length < 3) {
			return 0;
		}
		int cnt = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == target) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	
	public static boolean binarySearch(int[] nums, int target) {
		boolean isFind = false;
		int l = 0, h = nums.length - 1;
		int m = (h - l)/2 + l;
		
		while(l < h) {
			if (nums[m] == target) {
				isFind = true;
				break;
			} else if (nums[m] > target) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		
		return isFind;
	}
	
	public static int solutions2(int nums[], int target) {
		
		if (nums == null || nums.length < 3) {
			return 0;
		}
		int cnt = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int expectVal = target - nums[i] - nums[j];
				if (binarySearch(nums, expectVal)) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	public static int solutions3(int nums[], int target) {
		if (nums == null || nums.length < 3) {
			return 0;
		}
		int cnt = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-2; i++) {
			int l = i + 1, h = nums.length - 1;
			while (l < h) {
				if (nums[l] + nums[h] > -nums[i]) {
					h--;
				}else if (nums[l] + nums[h] < -nums[i]) {
					l++;
				}else {
					cnt++;
					l++;
					h--;
				}
			}
			
			
		}
		
		return cnt;
		
	}

}
