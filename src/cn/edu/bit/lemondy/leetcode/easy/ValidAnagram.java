package cn.edu.bit.lemondy.leetcode.easy;

/**
 * anagram: ���Ĺ��ʷ�
 * @author lemon
 * problem: дһ�������ж������ַ����Ƿ��ǻ��ĵġ� ���磺 s = "anagram" t = "nagaram" return true.
 * 										  s = "rat" t = "car" return false.
 * ����ֻ����Сд��ĸ��
 * solution: ����һ�������ʾ 26����ĸ����ʼ�������ֵ��Ϊ0��ɨ���һ���ַ������Գ��ֵ��ַ���Ӧ�������±��λ�õ�����1������
 *           ������ɨ��ڶ����ַ����Գ��ֵ��ַ���Ӧ�����е��±��λ�ã�����ֵ���м�һ������
 *           ���ɨ��һ�����飬����з���ֵ���ڣ����������ַ������ǻ��ģ������ǡ�
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
