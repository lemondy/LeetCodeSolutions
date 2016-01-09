package cn.edu.bit.lemondy.leetcode.easy;

/**
 * 
 * @author lemon
 * problem: 给定的一个整数是否是2的m次幂。不需要求出m是多少。
 * 
 * solution： 2的m次幂有一个特定就是某一位为1，其他位均为0，因此，如果该数是2的m次幂，那么n-1用二进制表示的就会与n用二进制表示的每一位均不同，
 *           从而n&(n-1) =0;
 * 
 */

public class PowerOfTwo {
	 public static boolean isPowerOfTwo(int n) {

		 return n>0 && (n&(n-1))==0;
	 }
	 public static void main(String[] args) {
		//int[] n = new int[];
		System.out.println(isPowerOfTwo(32));

	}
}
