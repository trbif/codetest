/**
 * 
 */
package cn.code.lc;


import cn.code.tools.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * @author zhangqi
 * @date 2018年3月21日 下午3:47:51
 * @version V1.0
 * @说明:
 */
public class MergeIntervals56 {

    public List<Interval> merge(List<Interval> intervals) {
    	if(intervals==null||intervals.size()==0){
    		return intervals;
    	}
    	TreeMap<Integer,Interval> helper = new TreeMap<Integer,Interval>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
    	for(Interval interval:intervals){
    		helper.put(interval.start, interval);
    	}
		System.out.println(helper);
    	List<Interval> result = new ArrayList<Interval>();
    	intervals = new ArrayList<Interval>(helper.values());
		System.out.println(intervals);
    	result.add(intervals.get(0));
        for(int i=1;i<helper.size();i++){
        	Interval pre = result.get(result.size()-1);
        	Interval next = intervals.get(i);
        	if(pre.end<=next.start){
        		result.add(next);
        	}else{
        		if(pre.end<next.end){
					pre.end = next.end;
					result.set(result.size()-1,pre);
        		}
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
    	Interval a = new Interval(1,4);
    	Interval b = new Interval(0,4);
    	List<Interval> intervals = new ArrayList<Interval>();
    	intervals.add(a);
    	intervals.add(b);
    	new MergeIntervals56().merge(intervals);
	}
}
