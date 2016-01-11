package cn.edu.bit.lemondy.leetcode.easy;

/**
 * 
 * @author lemon
 * problem: 
 * 			�Ƚ��������ַ�����ʾ�İ汾�ŵĴ�С������  "0.1" < "0.2" <"1.2" < "12.2"��
 * solution��
 * 			����������и����Ǵ����� "01" "1" �������ַ��������Բ�����ֱ��ʹ��String.compareTo()����ֱ����Ľ��
 * 			ͨ���� "." Ϊ�ָ����������ж�ÿ��"."�ָ����ĵ�Ԫ���Ƿ���ͬ�����������������������ڵ�һ�ֽ����⿼�ǹ���ϸ���Ƽ��ڶ���д����
 */

public class CompareVersionNumbers {
	
	public static int compareVersion(String version1,String version2){
		
		//solution 1
		
//		String[] verSplit1 = version1.split("\\.");
//		String[] verSplit2 = version2.split("\\.");
//		
//		int val1 = 0, val2 = 0;
//		
//		int len = verSplit1.length>verSplit2.length?verSplit2.length:verSplit1.length;
//		int i;
//		for(i = 0; i < len; i++){
//			val1 = Integer.parseInt(verSplit1[i]);
//			val2 = Integer.parseInt(verSplit2[i]);
//			if(val1>val2){
//				return 1;
//			}else if(val1<val2){
//				return -1;
//			}else{
//				continue;
//			}
//		}
//		
//		if(verSplit1.length == verSplit2.length){
//			return 0;
//		}else if(verSplit1.length > verSplit2.length){
//			for(;i<verSplit1.length;i++){
//				if(Integer.parseInt(verSplit1[i]) != 0)
//					return 1;
//			}
//			return 0;
//		}else{
//			for(;i<verSplit2.length;i++){
//				if(Integer.parseInt(verSplit2[i]) != 0){
//					return -1;
//				}
//			}
//			return 0;
//		}
		
		//solution 2
		  String [] version1Arrs = version1.split("\\.");   //�� . Ϊ�ָ����Ǳ�������д������ָ�����ã�������ʽ
		  String [] version2Arrs = version2.split("\\.");
		
		  int l1 = version1Arrs.length;
		  int l2 = version2Arrs.length;
		
		  for(int i = 0; i < (l1<=l2?l2:l1); i++) {
		
		    int val1 = i < l1?Integer.parseInt(version1Arrs[i]):0;
		    int val2 = i < l2?Integer.parseInt(version2Arrs[i]):0;
		
		    if(val1 > val2) return 1;
		    else if(val1 < val2) return -1;
		
		  }
		  return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.parseInt("01"));
		System.out.println(compareVersion("1.0", "1"));
		System.out.println(compareVersion("01.1", "001.1.0"));
		
	}

}
