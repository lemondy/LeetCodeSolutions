package cn.edu.bit.lemondy.leetcode.easy;

/**
 * 
 * @author lemon
 * 有待改进 
 */

public class MyAtoi {

	 public static int myAtoi(String str) {
		 String intString = "";
		 boolean isFirst = false;
		 for(int i=0;i<str.length();i++){
			 char ch = str.charAt(i);
			 
			 if(ch>='0' && ch<='9'){
				 if(isFirst == false)
					 isFirst = true;
				 if(i>0){
					 if(str.charAt(i-1) == '+' || str.charAt(i-1) == '-')
					 	intString = str.charAt(i-1)+intString;
				 }
				 intString = intString + ch;
			 }else{
				 if(isFirst == true){
					 isFirst = false;
					 //intString = intString+ch;
					 break;
				 }
					 
			 }
		 }
		 int result;
		 try{
			 result = Integer.parseInt(intString); 
			 return result;
		 }catch(NumberFormatException e){
			 double temp = Double.parseDouble(intString);
			 result = (int)(Integer.MAX_VALUE-temp);
			 return result;
		 }	 
		 
	 }
	 
	 public static void main(String[] args) {
		System.out.println(Integer.parseInt("+1"));
		System.out.println(myAtoi("2147483648"));  //字符表示的整形越界，大于int能够表示的范围
		System.out.println("3".compareTo("2147483648"));
	}
}
