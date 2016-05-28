package dynamicprogramming;

public class Knapsack {
	/**
	 * 0-1背包问题： 状态转移方程
	 */
	/**
	 * 
	 * @param goods weight,value
	 * @param weight the amount of package 
	 * @return
	 */
	public static int maxValue(int[][] goods, int weight){ 
		//int maxValue = 0;
		int[][] selected = new int[goods.length][weight+1];   
		
		for(int w=1;w<=weight;w++){
			selected[0][w] = 0;
		}
		
		for(int i=1;i<=goods.length-1;i++){
			selected[i][0] = 0;
			for(int w=1;w<=weight;w++){
				if(goods[i][1] <=w){
					if(goods[i][0]+selected[i-1][w-goods[i][1]] > selected[i-1][w]){
						selected[i][w]= goods[i][0]+selected[i-1][w-goods[i][1]];
					}else{
						selected[i][w] = selected[i-1][w];
					}
				}else{
					selected[i][w] = selected[i-1][w];
				}
				
			}
		}
		return selected[goods.length-1][weight];
	}
	
	public static void main(String[] args) {
		int[][] goods = {{0,0},{60,30},{100,20},{120,30}};   //value, weight
		System.out.println(maxValue(goods, 50));
	}
	
}
