/**
 * 
 */
package cn.code.lc;

import java.util.TreeSet;

/**
 * @author zhangqi
 * @date 2018年3月14日 下午1:09:23
 * @version V1.0
 * @说明:
 */
public class BestTimetoBuyandSellStock121 {

	// Time Limit Exceeded
    public int maxProfit(int[] prices) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<prices.length-1;i++){
        	for(int j=i+1;j<prices.length;j++){
        		if(prices[j]>prices[i]){
        			set.add(prices[j]-prices[i]);
        		}
        	}
        }
        if(set.size()==0){
        	return 0;
        }
        return set.last();
    }
	// Time Limit Exceeded
    public int maxProfitNew(int[] prices) {
        int max = 0;
        for(int i=0;i<prices.length-1;i++){
        	for(int j=i+1;j<prices.length;j++){
        		if(prices[j]>prices[i]){
        			max = Math.max(max, prices[j]-prices[i]);
        		}
        	}
        }
        return max;
    }
    public int maxProfitNewNew(int[] prices) {
        int maxCur = 0;
        int maxSoFar = 0;
        for(int i=1;i<prices.length;i++){
        	maxCur += prices[i]-prices[i-1];
        	maxCur = Math.max(0,maxCur);
        	maxSoFar = Math.max(maxSoFar,maxCur);
        }
        return maxSoFar;
    }
    
    public static void main(String[] args) {
    	int[] prices = {6, 1, 3,2,7,4};
		System.out.println(new BestTimetoBuyandSellStock121().maxProfitNewNew(prices));
	}
    
}
