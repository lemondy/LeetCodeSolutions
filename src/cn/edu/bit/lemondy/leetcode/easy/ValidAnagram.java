package cn.edu.bit.lemondy.leetcode.easy;

/**
 * anagram: 回文构词法
 * @author lemon
 * problem: 写一个函数判断两个字符串是否是回文的。 例如： s = "anagram" t = "nagaram" return true.
 * 										  s = "rat" t = "car" return false.
 * 假设只含有小写字母。
 * solution: 利用一个数组表示 26个字母，初始数组里的值均为0，扫描第一个字符串，对出现的字符对应的数组下标的位置的数加1操作。
 *           再依次扫描第二个字符，对出现的字符对应数组中的下标的位置，将其值进行减一操作。
 *           最后扫描一边数组，如果有非零值存在，则这两个字符串不是回文，否则，是。
 * 
 */

public class ValidAnagram {
	
	 public static boolean isAnagram(String s, String t) {
	        
	        if(s.length() != t.length())
	            return false;
	        int[] alphabet = new int[26];   
	     
	        int i;
	        
	        for(i=0;i<s.length();i++)
	            alphabet[s.charAt(i)-97]++;
	            
	        for(i=0;i<t.length();i++){
	            alphabet[t.charAt(i)-97]--;    
	        }
	            
	        for(i=0;i<alphabet.length;i++)
	            if(alphabet[i] < 0) 
	                return false;
	        return true;
	    }

	 public static void main(String[] args) {
		System.out.println(isAnagram("rat","cat"));
		System.out.println(isAnagram("anagram", "nagaram"));
	}
}
