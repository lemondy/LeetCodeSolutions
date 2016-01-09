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
