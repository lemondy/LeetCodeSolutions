package cn.edu.bit.lemondy.leetcode.easy;

/**
 * 
 * @author lemon
 * problem: 给定两个字符串，字符串的内容是二进制的数字，编写函数，返回值为两个二进制字符串的和。例如： a="11" b="1" 返回值为"100".
 * description: 对于整数的一些操作，需要注意的一点是防止操作越界。此题不可将二进制的字符串转换成整数，求和之后再转化成从字符串。
 * 				因为当二进制的字符串表示的整数过大，或者两数值和超过整数能够表示的范围，就不能正确的转换成int类型。
 * 
 */

public class AddBinary {
	public static String addBinary(String a,String b){
	
		int x, y, c = 0;      //c 表示当前位之和是否存在进位
		int cur = 0;          //记录两个字符串某一位的二进制数之和
		String result = "";
		
		int i,j;
		i = a.length()-1;     //第一个字符串末尾
		j = b.length()-1;     //第二个字符串末尾
		
		while(i>=0&&j>=0){    //两个字符串都从最末尾的位置开始向前扫描，注意下标的扫描方式
			x = a.charAt(i) - '0';   
			y = b.charAt(j) - '0';
			cur = x + y + c;
			
			if(cur > 2){
				cur = 1;
				c = 1;
			}else if(cur == 2){
				cur = 0;
				c = 1;
			}else{
				c = 0;
			}
			result = cur + result;
			i--;
			j--;	
		}
		
		//当两个字符串不等长的时候执行下面两个while
		while(i>=0){
			x = a.charAt(i) - 48;
			cur = x + c;
			if(cur == 2){
				cur = 0;
				c = 1;
			}else{
				c = 0;
			}
			result = cur + result;
			i--;
		}
		
		while(j>=0){
			y = b.charAt(j) - 48;
			cur = y + c;
			if(cur == 2){
				cur = 0;
				c = 1;
			}else{
				c = 0;
			}
			result = cur + result;
			j--;
		}
		
		if(c != 0)   //如果最后还有一个进位，添加到最开始
			result = c + result;
			
		return result;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(addBinary("100", "110010"));
		System.out.println(addBinary("10011001101110", "11110000001101010"));
		
	}
}
