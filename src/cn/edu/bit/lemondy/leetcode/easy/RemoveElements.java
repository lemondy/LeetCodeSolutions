package cn.edu.bit.lemondy.leetcode.easy;

/**
 * 
 * @author lemon
 * problem: 
 * 			ɾ�������и�����ֵ��������������ĳ��ȡ�
 * solution 1:
 * 			���α������飬������������ֵ������ɾ�����ҽ������ֵ��ǰ��
 * solution 2��
 * 			��������ָ�룬һ�����б�������һ����¼��ǰ��ָ��Ԫ�ص�λ�á�
 * 			
 * 
 */

public class RemoveElements {

	 public static  int removeElement(int[] nums, int val) {
	        //��һ�ַ�����ɾ����֮���ƶ�Ԫ��
	        // if(nums.length<=0)
	        //     return 0;
	            
	        // int len = nums.length;
	        // for(int i=0;i<len;i++){
	        //     if(nums[i] == val){
	        //         for(int k=i;k<len-1;k++){
	        //             nums[k]=nums[k+1];
	        //         }
	        //         len--;
	        //         i--;   //��ǰλ�õ�Ԫ�ر���һ���滻�ˣ�����Ҫ���ж�һ��
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
