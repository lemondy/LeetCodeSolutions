package cn.edu.bit.lemondy.leetcode.easy;

public class FirstBadVerion {
	
	public static boolean isBadVersion(int n){
		if(n>500000000)
			return true;
		else {
			return false;
		}
	}
	
	
	/**
	 * 
	 * @param n
	 * @return
	 * 如下方式在leetcode上执行时间是18ms
	 */
    public static int firstBadVersion(int n) {
    	 int low,high,mid;
         low = 1; high = n;

         //mid = (low+high)/2;
         while(low<=high){
             mid = low+(high-low)/2;   //二叉搜索树中这里要特别注意，两个数之和求中间位置有可能会发生越界，所以要求差之后在加上基础值得到中值
             if(isBadVersion(mid)){
                 high = mid-1;
             }else{
                 low=mid+1;
             }
         }
         return low;
    }
    
    public static void main(String[] args) {
		System.out.println(firstBadVersion(700000000));
	}
}
