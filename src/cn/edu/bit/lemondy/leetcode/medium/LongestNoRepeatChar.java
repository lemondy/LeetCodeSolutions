package cn.edu.bit.lemondy.leetcode.medium;

import java.util.HashMap;

public class LongestNoRepeatChar {
	public static int lengthOfLongestSubstring(String s){
//		if(s == null)
//			return 0;
//		if(s.length() == 1)
//			return 1;
//		
//		int max = 0;
//		int count = 0;
//		HashMap<Character, Integer> map = new HashMap<>();
//		
//		
//		for(int i=0;i<s.length();i++){
//			for(int j=i;j<s.length();j++){
//				if(map.containsKey(s.charAt(j))){
//					if(count>max){
//						max = count;	
//					}	
//					count = 0;
//					map.clear();
//					break;
//				}else{
//					map.put(s.charAt(j),1);
//					count++;
//				}
//			}
//		}
//		
//		
//		return max;
		
		int maxLength = 1, start = 0, end = 1;
		String current = s.substring(start, end);
		
		for(int i=1;i<s.length();i++){
			if(current.indexOf(s.charAt(i)) >= 0){  //this character has been exists.	
				maxLength = Math.max(maxLength, end-start);
				//start = i;
				start += (current.indexOf(s.charAt(i))+ 1);
				end = i+1;
				current = s.substring(start,end);
			}else{
				end = i+1;
				current = s.substring(start,end);
			}
		}
		maxLength = Math.max(maxLength, end-start);
		return maxLength;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("aabbccdd"));
		System.out.println(lengthOfLongestSubstring("adbcdsdpoiuytrewq"));
		System.out.println(lengthOfLongestSubstring("dddd"));
		System.out.println(lengthOfLongestSubstring("d"));
		
	}
}
