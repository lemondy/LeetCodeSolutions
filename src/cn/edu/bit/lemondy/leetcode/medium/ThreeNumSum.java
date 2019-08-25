package cn.edu.bit.lemondy.leetcode.medium;

import java.util.Arrays;

/**
 * 
 * @author lemondy
 * problem: 
 * 			��һ�����飬�ж��������Ƿ�������Ԫ��֮�͵���0��������Ԫ��ĸ���
 * solution1:
 * 			��������forѭ�������α������鿴�Ƿ��������Ԫ������Ҫ�󡣸��Ӷȣ�O(n*n*n)
 * solution2:
 * 			����������forѭ��������һ�������㷨�������Ƿ��������һ���������Ӷȣ�O(n*n*logn)
 * solution3:
 * 			������ ��Ȼ��ͬʱ����ߺ��ұ߽��в�������, O(n*n)
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
