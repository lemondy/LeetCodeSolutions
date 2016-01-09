package cn.edu.bit.lemondy.leetcode.easy;

/**
 * 
 * @author lemon
 * problem: 
 *          ���ڿ���һ���Ʒ������Ʒ�ڵ����Ĺ�����ĳ���汾���ϸ񣬾ͻᵼ��֮�����еİ汾���������⡣
 *          �������� n ���汾�� [1,2,...,n]��Ҫ�������ҳ���һ�����İ汾�š��ṩһ��API����  bool isBadVersion(version)
 *          ����Ե��á�Ҫ����������������ô����������١�
 *  solution: 
 *  		 Ҫ��ʹisBadVersion�����ĵ��ô������١���Ŀ�и������ǣ�����һ�����汾��֮��ȫ�����ǻ��ġ�
 *  		  ����˼·�����ö��ֲ��ҵ�˼�룬��ʱ�临�Ӷ�ΪO(n)��ΪO(log).
 *  
 *  �����������Ķ�����Ҵ����ж�����һ�����⣬�����±�Խ�����⡣���Խ��ָ���ǳ������������ͱ�ʾ�ķ�Χ�������Ƿ�Χ����Խ�硣
 *      ��Ϊ�ڼ����м�λ��ʱ����ͳ��Ϊ�� mid = (low+high)/2  ��low��high�Ƚϴ�ʱ�����ǵĺ;��п��ܳ������������ܹ���ʾ�ķ�Χ��
 *  
 */

public class FirstBadVerion {
	
	//����Ǳ����Լ�����ģ���ƽ̨���жϳ���汾���в��
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
	 * ���·�ʽ��leetcode��ִ��ʱ����18ms
	 */
    public static int firstBadVersion(int n) {
    	 int low,high,mid;
         low = 1; high = n;

         //mid = (low+high)/2;
         while(low<=high){
             mid = low+(high-low)/2;   //����������������Ҫ�ر�ע�⣬������֮�����м�λ���п��ܻᷢ��Խ�磬����Ҫ���֮���ڼ��ϻ���ֵ�õ���ֵ
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
