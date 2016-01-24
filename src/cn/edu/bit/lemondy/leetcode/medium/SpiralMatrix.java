package cn.edu.bit.lemondy.leetcode.medium;

public class SpiralMatrix {
	
	public static int[][] generateMatrix(int n){
		int[][] result = new int[n][n];
		
		
		return result;
	}
	
	static int getInner(int x, int y, int n) // 由外向内顺时针螺旋
	{
		if (x <= y) {
			int k = Math.min(x, n - 1 - y);
			return 4 * k * (n - k) + 1 + (x + y - k * 2);
		}
		int k = Math.min(y, n - 1 - x) + 1; 
		return 4 * k * (n - k) + 1 - (x + y - (k - 1) * 2);
	}
	
	static int getOuter(int x, int y, int n) //螺旋矩阵（由内向外扩散）
	{
		int t = (n - 1) | 1;
		if (x <= y) {
			int k = Math.min(x, t - y);
			return (t - 2 * k) * (t - 2 * k - 1) + 1 + (x + y - 2 * k);
		}
		int k = Math.min(y + 1, t - x) - 1;
		return (t - 2 * k) * (t - 2 * k - 1) + 1 - (x + y - 2 * k);
	}
	
	public static void main(String[] args) {
		
		int n = 5;
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				System.out.print(getInner(i,j,n)+"\t");
			System.out.println();
		}
		
		System.out.println("---------------------------");
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				System.out.print(getOuter(i,j,n)+"\t");
			System.out.println();
		}
			
	}
}
