package cn.edu.bit.lemondy.leetcode.easy;

/**
 * 
 * @author lemon
 * problem: Write a function that takes an unsigned integer and 
 * 			returns the number of ’1' bits it has (also known as the Hamming weight).
 * 			For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
 * 			so the function should return 3.
 * 
 *  solution: 移位和与操作结合，循环次数为整数用二进制表示的位数
 */

public class NumberOfOneBits {

	 public static int hammingWeight(int n) {
	        int count=0;
	      
	        while(n!=0){
	            if((n&1)!=0){     //与操作判断最后一位是否为1
	                count++;
	            }
	             n=n>>>1;        //无符号的右移操作，补0
	        }
	        return count;
	    }
	 
	 public static void main(String[] args) {
		System.out.println(hammingWeight(25));
	}
}
