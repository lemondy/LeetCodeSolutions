package cn.edu.bit.lemondy.leetcode.easy;

/**
 * 
 * @author lemon
 * problem: ���������ַ������ַ����������Ƕ����Ƶ����֣���д����������ֵΪ�����������ַ����ĺ͡����磺 a="11" b="1" ����ֵΪ"100".
 * description: ����������һЩ��������Ҫע���һ���Ƿ�ֹ����Խ�硣���ⲻ�ɽ������Ƶ��ַ���ת�������������֮����ת���ɴ��ַ�����
 * 				��Ϊ�������Ƶ��ַ�����ʾ���������󣬻�������ֵ�ͳ��������ܹ���ʾ�ķ�Χ���Ͳ�����ȷ��ת����int���͡�
 * 
 */

public class AddBinary {
	public static String addBinary(String a,String b){
	
		int x, y, c = 0;      //c ��ʾ��ǰλ֮���Ƿ���ڽ�λ
		int cur = 0;          //��¼�����ַ���ĳһλ�Ķ�������֮��
		String result = "";
		
		int i,j;
		i = a.length()-1;     //��һ���ַ���ĩβ
		j = b.length()-1;     //�ڶ����ַ���ĩβ
		
		while(i>=0&&j>=0){    //�����ַ���������ĩβ��λ�ÿ�ʼ��ǰɨ�裬ע���±��ɨ�跽ʽ
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
		
		//�������ַ������ȳ���ʱ��ִ����������while
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
		
		if(c != 0)   //��������һ����λ����ӵ��ʼ
			result = c + result;
			
		return result;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(addBinary("100", "110010"));
		System.out.println(addBinary("10011001101110", "11110000001101010"));
		
	}
}
