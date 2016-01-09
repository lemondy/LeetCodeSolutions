package cn.edu.bit.lemondy.leetcode.easy;

/**
 * 
 * @author lemon
 * problem: Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 			for example: 1->A, 2->B, 3->c,...,26->Z, 27->AA, 28->AB
 * 
 * solution: 本题的思路是将一个十进制的数转换成二十六进制。只是二十六进制用大写字母表示，思路和常规的进制转换类似。
 */

public class ExcelColumnTitle {
	public static String convertToTitle(int n){
		String str="";
		
		if(n<=0){
			return null;
		       
		}else{
			//从右到左的得到字符串里面的元素
			while(n/26!=0){
				str= (char)((n-1)%26+'A')+str;  //求余得到末尾的字符
				n=(n-1)/26;
			}
			if(n!=0)   //如果这位不为0，说明前面还得添加
				str = (char)((n-1)+'A')+str;   //每次添加在前面
			return str;
			
		}
		
	}

	public static void main(String[] args) {
		System.out.println(convertToTitle(53));
		System.out.println(convertToTitle(52));
		System.out.println(convertToTitle(701));

	}
}
