package cn.edu.bit.lemondy.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * @author lemon
 * PROBLEM: Given an array of integers, find if the array contains any duplicates. 
 *          Your function should return true if any value appears at least twice in the array, 
 *          and it should return false if every element is distinct.
 * Solution: ����Java ���ṩ�����ݽṹSet����Ϊ��Set�����в��ܴ����ظ���Ԫ�أ��������HashSet��������ʱ��϶̵�ͬʱ�ܹ�����Ƿ������ͬ��Ԫ�ء�
 */
public class DuplicateNums {
	public static boolean containsDuplicate(int[] nums) {
		//recommend solution: hashset 
		 HashSet<Integer> set = new HashSet<Integer>();
	      for(Integer i:nums){
	          if(!set.add(i))   //���Ԫ�ز����ھͷ���true
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
