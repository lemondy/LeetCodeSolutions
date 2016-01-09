package cn.edu.bit.lemondy.leetcode.easy;

public class PowerOfTwo {
	 public static boolean isPowerOfTwo(int n) {
//	        double result = (double)Math.log10(n)/(double)Math.log10(2);
//	        String temp = String.valueOf(result);
//	        int index = temp.indexOf(".");
//	        String decimal = temp.substring(index+1,temp.length());
//	        double d = Double.valueOf(decimal);
//	        if(d == 0)
//	        return true;
//	        else 
//	        return false;
//		 while(n%2 == 0){
//			 if(n==2 || n == 1)
//				 return true;
//			 n=n/2;
//			 
//		 }
//	      return false;
//	    }
		 return n>0 && (n&(n-1))==0;
	 }
	 public static void main(String[] args) {
		//int[] n = new int[];
		System.out.println(isPowerOfTwo(32));

	}
}
