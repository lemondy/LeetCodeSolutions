package cn.edu.bit.lemondy.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

public class RemoveDuplicatesII {
	
	public static int removeDuplicates(int[] nums){
		int count = 0;
		int forward = 0;
		int len = nums.length;
		for(int i=1;i<len;i++){
			if(nums[i] == nums[i-1]){
				count++;
			}else{
				if(count>1){
					forward = count-1;
					for(int j=i;j<nums.length;j++){
						nums[j-forward] = nums[j];
					}
					len = len-forward;
					count = 0;
					i = i-forward;
				}
			}
		}

		return nums.length;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1,2,2,3};
		System.out.println(removeDuplicates(nums));

		for(Integer i:nums)
			System.out.print(i+" ");
	}
}
