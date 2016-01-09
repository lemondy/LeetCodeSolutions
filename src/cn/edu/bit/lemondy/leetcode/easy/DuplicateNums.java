package cn.edu.bit.lemondy.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * @author lemon
 * PROBLEM: Given an array of integers, find if the array contains any duplicates. 
 *          Your function should return true if any value appears at least twice in the array, 
 *          and it should return false if every element is distinct.
 * Solution: 利用Java 中提供的数据结构Set，因为在Set集合中不能存在重复的元素，因此利用HashSet，在满足时间较短的同时能够检查是否存在相同的元素。
 */
public class DuplicateNums {
	public static boolean containsDuplicate(int[] nums) {
		//recommend solution: hashset 
		 HashSet<Integer> set = new HashSet<Integer>();
	      for(Integer i:nums){
	          if(!set.add(i))   //如果元素不存在就返回true
	            return true;
	      }
	      return false;
	      
	     //second solution, easy but not time efficient
//		 Arrays.sort(nums);
//		    final int len = nums.length;
//		    for (int i = 1; i <= len / 2; i++) {
//		        if (nums[i - 1] == nums[i] || nums[len - i] == nums[len - i - 1])
//		            return true;
//		    }
//		    return false;
	    }
	public static void main(String[] args){
		
		int nums[] = new int[30000];
		
		for(int i=0;i<nums.length;i++)
			nums[i]=i;
		
		long start=System.currentTimeMillis();
		
		System.out.println(containsDuplicate(nums));
		
		long end = System.currentTimeMillis();
		System.out.println("time:"+(end-start));
		
		
	}
}
