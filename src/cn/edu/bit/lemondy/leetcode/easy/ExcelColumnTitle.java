package cn.edu.bit.lemondy.leetcode.easy;

/**
 * 
 * @author lemon
 * problem: Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 			for example: 1->A, 2->B, 3->c,...,26->Z, 27->AA, 28->AB
 * 
 * solution: �����˼·�ǽ�һ��ʮ���Ƶ���ת���ɶ�ʮ�����ơ�ֻ�Ƕ�ʮ�������ô�д��ĸ��ʾ��˼·�ͳ���Ľ���ת�����ơ�
 */

public class ExcelColumnTitle {
	public static String convertToTitle(int n){
		String str="";
		
		if(n<=0){
			return null;
		       
		}else{
			//���ҵ���ĵõ��ַ��������Ԫ��
			while(n/26!=0){
				str= (char)((n-1)%26+'A')+str;  //����õ�ĩβ���ַ�
				n=(n-1)/26;
			}
			if(n!=0)   //�����λ��Ϊ0��˵��ǰ�滹�����
				str = (char)((n-1)+'A')+str;   //ÿ�������ǰ��
			return str;
			
		}
		
	}

	public static void main(String[] args) {
		System.out.println(convertToTitle(53));
		System.out.println(convertToTitle(52));
		System.out.println(convertToTitle(701));

	}
}
