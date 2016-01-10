package cn.edu.bit.lemondy.leetcode.easy;

/**
 * 
 * @author lemon
 * problem: 
 * 			删除数组中给定的值，并返回新数组的长度。
 * solution 1:
 * 			依次遍历数组，当遇到给定的值，将其删除并且将后面的值向前移
 * solution 2：
 * 			利用两个指针，一个进行遍历，另一个记录当前无指定元素的位置。
 * 			
 * 
 */

public class RemoveElements {

	 public static  int removeElement(int[] nums, int val) {
	        //第一种方法，删除，之后移动元素
	        // if(nums.length<=0)
	        //     return 0;
	            
	        // int len = nums.length;
	        // for(int i=0;i<len;i++){
	        //     if(nums[i] == val){
	        //         for(int k=i;k<len-1;k++){
	        //             nums[k]=nums[k+1];
	        //         }
	        //         len--;
	        //         i--;   //当前位置的元素被后一个替换了，所以要再判断一次
	        //     }
	        // }
	        
	        // return len;
	        
	        //two pointers
	        if(nums==null||nums.length == 0) return 0;
	        int k=0,j=0;
	        int len = nums.length;
	        while(j<len){
	            if(nums[j]!=val){
	                nums[k++] = nums[j];
	            }
	            j++;
	        }
	        return k;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,4,3,6,5,2};
		int val = 2;
		//System.out.println(removeElement(nums, val));
		int len = removeElement(nums, val);
		for(int i=0;i<len;i++){
			System.out.println(nums[i]);
		}
	}
}
