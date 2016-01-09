package cn.edu.bit.lemondy.leetcode.easy;

/**
 * 
 * @author lemon
 * problem: ������һ�������Ƿ���2��m���ݡ�����Ҫ���m�Ƕ��١�
 * 
 * solution�� 2��m������һ���ض�����ĳһλΪ1������λ��Ϊ0����ˣ����������2��m���ݣ���ôn-1�ö����Ʊ�ʾ�ľͻ���n�ö����Ʊ�ʾ��ÿһλ����ͬ��
 *           �Ӷ�n&(n-1) =0;
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
