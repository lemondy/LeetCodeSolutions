package cn.edu.bit.lemondy.leetcode.easy;

/**
 * 
 * @author lemon
 * problem: Write a function that takes an unsigned integer and 
 * 			returns the number of ��1' bits it has (also known as the Hamming weight).
 * 			For example, the 32-bit integer ��11' has binary representation 00000000000000000000000000001011,
 * 			so the function should return 3.
 * 
 *  solution: ��λ���������ϣ�ѭ������Ϊ�����ö����Ʊ�ʾ��λ��
 */

public class NumberOfOneBits {

	 public static int hammingWeight(int n) {
	        int count=0;
	      
	        while(n!=0){
	            if((n&1)!=0){     //������ж����һλ�Ƿ�Ϊ1
	                count++;
	            }
	             n=n>>>1;        //�޷��ŵ����Ʋ�������0
	        }
	        return count;
	    }
	 
	 public static void main(String[] args) {
		System.out.println(hammingWeight(25));
	}
}
