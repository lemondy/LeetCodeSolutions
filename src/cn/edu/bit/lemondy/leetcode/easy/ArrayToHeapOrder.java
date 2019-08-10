package cn.edu.bit.lemondy.leetcode.easy;

/**
 * 
 * @author zhang
 * @desc 将一个数组转换成小（大）顶堆
 */
public class ArrayToHeapOrder {
	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public static void arrayToMaxHeapOrder(int nums[], int i) {
		if (i == 0) {
			return;
		}
		int max = Math.max(nums[i], nums[i - 1]);
		int j = nums[i] > nums[i - 1] ? i : i - 1;
		
		if (nums[i] < max) {
			swap(nums, i, j);
			arrayToMaxHeapOrder(nums, i);
		}
	}
	
	public static void arrayToMinHeapOrder(int nums) {
		
	}
	
	public static void main(String[] args) {
		
		int[] nums = {1, 4, 6, 9, 2, 3, 5};
		
		//arrayToMaxHeapOrder(nums);
		for (int num : nums) {
			System.out.println(num + " ");
		}
	}
}
