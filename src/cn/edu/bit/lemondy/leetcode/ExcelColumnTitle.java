package cn.edu.bit.lemondy.leetcode;

public class ExcelColumnTitle {
	public static String convertToTitle(int n){
		String str="";
		
		if(n<=0){
			return null;
		       
		}else{
		
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
//		System.out.println((char)('A'+1));
//		System.out.println(2/26);
		System.out.println(convertToTitle(53));
		System.out.println(convertToTitle(52));
		System.out.println(convertToTitle(701));

	}
}
