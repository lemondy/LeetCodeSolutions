package cn.edu.bit.lemondy.leetcode;

/**
 * 
 * @author lemon
 * �� n!���β���ж��ٸ�0
 */

public class FactorialTrailingZeroes {
	public static int trailingZeroes(int n){
		int count = 0;
		long start = System.currentTimeMillis();
		while(n/5 != 0){
			count += n/5;
			n = n/5;
		}
		long end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println(start);
		System.out.println(Math.log10(n));
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(trailingZeroes(2123455633));
	}
}
