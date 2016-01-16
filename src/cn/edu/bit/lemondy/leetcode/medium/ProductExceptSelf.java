package cn.edu.bit.lemondy.leetcode.medium;

/**
 * 
 * @author lemondy
 * problem: 
 * 			假设有一个数组，元素都是整数，元素个数n>1,返回一个数组output，output[i] 是除nums数组中
 *  		的第i个元素之外所有元素的乘积。要求时间复杂度O(n),除输出数组外，空间复杂度为O(1)。
 * solution: 
 * 			先得到所有的元素的乘积结果，然后依次除以数组中的每个元素就得到了结果。这个思想有个问题是nums数组中不能存在0.
 * 			因此需要对数组中是否有0元素进行判断，同时，若数组中的0超过两个，输出结果肯定都为0.
 */

public class ProductExceptSelf {

	public static int[] productExceptSelf(int[] nums) {

		int result = 1;
		int index = -1;
		boolean isFirstZero = false;
		int[] output = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0 && !isFirstZero) {    //meet the first zero
				isFirstZero = true;
				index = i;
				continue;
			}

			if (isFirstZero == true && nums[i] == 0) { // the second zero
				result = 0;
				break;
			} else {
				result *= nums[i];
			}
		}

		if (result == 0) { // have more than one zero
			return output;
		}

		if (index == -1) { // no zero

			for (int i = 0; i < nums.length; i++) {

				output[i] = result / nums[i];
			}
		} else { // have one zero
			output[index] = result;
		}

		return output;
	}

	public static void main(String[] args) {
		int nums1[] = { 1, 0, 3, 0, 9 };
		
		int[] result = productExceptSelf(nums1);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + "  ");
		}
		
		System.out.println();
		
		int nums2[] = { 1, 2, 3, 4 };
		int[] result2 = productExceptSelf(nums2);
		for (int i = 0; i < result2.length; i++) {
			System.out.print(result2[i] + "  ");
		}
	}
}
