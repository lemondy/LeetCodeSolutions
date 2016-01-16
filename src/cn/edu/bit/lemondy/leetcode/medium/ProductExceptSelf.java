package cn.edu.bit.lemondy.leetcode.medium;

/**
 * 
 * @author lemondy
 * problem: 
 * 			������һ�����飬Ԫ�ض���������Ԫ�ظ���n>1,����һ������output��output[i] �ǳ�nums������
 *  		�ĵ�i��Ԫ��֮������Ԫ�صĳ˻���Ҫ��ʱ�临�Ӷ�O(n),����������⣬�ռ临�Ӷ�ΪO(1)��
 * solution: 
 * 			�ȵõ����е�Ԫ�صĳ˻������Ȼ�����γ��������е�ÿ��Ԫ�ؾ͵õ��˽�������˼���и�������nums�����в��ܴ���0.
 * 			�����Ҫ���������Ƿ���0Ԫ�ؽ����жϣ�ͬʱ���������е�0�����������������϶���Ϊ0.
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
