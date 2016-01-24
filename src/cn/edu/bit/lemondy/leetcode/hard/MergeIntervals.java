package cn.edu.bit.lemondy.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.List;

/**
 * 
 * @author lemon
 * problem: 
 * 			给定一些集合的间隔，将有重叠的集合进行合并。例如： 给定 [1,3],[2,5],[8,10],[14,18]
 * 			合并后得到： [1,5],[8,10],[14,18]
 * solution: 
 * 			给定的集合的顺序不一定是有序的，所以第一步要排序，接着遍历有序集合，判断区间左右边界的关系。
 * 			需要考虑清楚的是：区间有可能会有一样，或者排序后区间右边界不是从小到大等问题。
 */

public class MergeIntervals {
	
	public static List<Interval> merge(List<Interval> intervals){
		if(intervals == null)
			return null;
		if(intervals.size()<2)  
			return intervals;
		List<Interval> resultIntervals = new ArrayList<Interval>();
		
		//sorted the list
		Collections.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.start, o2.start);
			}
			
		});
		
		int i;
		for(i=0;i<intervals.size()-1;i++){
			if(intervals.get(i).end<intervals.get(i+1).start){    //形如[2,6] [8,10]，就将当前的[2,6]添加到结果中。
				resultIntervals.add(intervals.get(i));

			}else{
				if(intervals.get(i).end<intervals.get(i+1).end){   //形如 [1,3] [2,6]，或者[1,3] [2,3],要进行合并
					Interval tem = new Interval(intervals.get(i).start, intervals.get(i+1).end);

					intervals.set(i+1, tem);  //当前合并的不添加到结果中，有可能还要与后面的合并
				}else{     //形如[1,4] [2,3]
					intervals.set(i+1, intervals.get(i));
				}
			}
		}
		resultIntervals.add(intervals.get(i));  //最后一个添加到结果中
		return resultIntervals;
	}
	
	//另外一种写法，更精简
	public static List<Interval> merge2(List<Interval> intervals){
		int N = intervals.size();
	    Collections.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval i, Interval j){
	                return i.end - j.end;
	        }
	    });
	    for(int i = N-1; i>0;i--){
	        Interval inter1 = intervals.get(i-1);
	        Interval inter2 = intervals.get(i);
	        if(inter1.end >= inter2.start){
	            inter1.start = Math.min(inter1.start, inter2.start);
	            inter1.end = inter2.end; //inter1.end is always smaller than inter2.end because of the sort, so no need to use Math.max()
	            intervals.remove(i);
	        }
	    }
	    
	    return intervals;
	    
	}
	
	public static void main(String[] args) {
		Interval interval1 = new Interval(1, 3);
		Interval interval2 = new Interval(1, 3);
		Interval interval3 = new Interval(15, 18);
		Interval interval4 = new Interval(8, 10);
		
		List<Interval> list = new ArrayList<>();
		list.add(interval1);
		list.add(interval2);
		list.add(interval3);
		list.add(interval4);
		
		List<Interval> resultIntervals = merge(list);
		for(Interval interval:resultIntervals){
			System.out.println(interval);
		}
	}
}

class Interval{
	public int start;
	public int end;
	public Interval(){ start = 0; end = 0;}
	public Interval(int s,int e){
		start = s;
		end = e;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+start+","+end+"]";
	}
	
}