package cn.edu.bit.lemondy.leetcode.medium;

public class SearchMatrix {
	 public static boolean searchMatrix(int[][] matrix, int target) {
	        //row matrix.length
	        //columns matrix[0].length
	        int rows = matrix.length;
	        int columns = matrix[0].length;
	        
	        int low = 0, high = rows-1;
	        int mid=0;
	        while(low<high){
	            mid = low + (high-low)/2;
	            if(matrix[mid][columns-1] > target){
	                high = mid-1;
	            }else if(matrix[mid][columns-1]<target){
	                low = mid+1;
	            }else{//equals
	                return true;
	            }
	        }
	        if(matrix[low][columns-1]<target){
	        	
	        	if(rows>2){
	        		if(low+1 < rows)  //·ÀÖ¹Ô½½ç
	        			low+=1;	        		
	        	}	        		
				
	        }
	        for(int i=0;i<columns;i++){
	            if(matrix[low][i] == target)
	                return true;
	            if(matrix[low][i]>target)
	                return false;
	        }
	        return false;
	    }
	 public static void main(String[] args) {
		int[][] matrix ={{1},{2},{3}};//{{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};//{{1},{2},{3}};
		
		//System.out.println(matrix.length+":"+matrix[0].length);
		System.out.println(searchMatrix(matrix, 50));
	}
}
