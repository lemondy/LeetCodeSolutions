package cn.edu.bit.lemondy.leetcode;

public class ExcelColumnTitle {
	public static String convertToTitle(int n){
		String str="";
		
		if(n<=0){
			return null;
		       
		}else{
		
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
//		System.out.println((char)('A'+1));
//		System.out.println(2/26);
		System.out.println(convertToTitle(53));
		System.out.println(convertToTitle(52));
		System.out.println(convertToTitle(701));

	}
}
