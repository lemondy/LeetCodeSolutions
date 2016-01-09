package cn.edu.bit.lemondy.leetcode.easy;

/**
 * 
 * @author lemon
 * problem: 
 *          现在开发一款产品，当产品在迭代的过程中某个版本不合格，就会导致之后所有的版本都存在问题。
 *          假设你有 n 个版本号 [1,2,...,n]，要求最快的找出第一个坏的版本号。提供一个API函数  bool isBadVersion(version)
 *          你可以调用。要满足这个函数被调用次数尽可能少。
 *  solution: 
 *  		 要求使isBadVersion函数的调用次数最少。题目有个特征是：出现一个坏版本，之后全部都是坏的。
 *  		  本题思路：利用二分查找的思想，将时间复杂度为O(n)变为O(log).
 *  
 *  ！！！以往的二叉查找代码中都存在一个问题，就是下标越界问题。这个越界指的是超过该数据类型表示的范围，而不是范围数组越界。
 *      因为在计算中间位置时，传统的为： mid = (low+high)/2  当low和high比较大时，它们的和就有可能超过数据类型能够表示的范围。
 *  
 */

public class FirstBadVerion {
	
	//这个是本人自己构造的，与平台的判断出错版本号有差别
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
