/**
 * 
 */
package cn.code.lc;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangqi
 * @date 2018年3月14日 下午4:41:18
 * @version V1.0
 * @说明:
 */
public class MedianofTwoSortedArrays4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid = (nums1.length+nums2.length)>>1;
        int index1 = 0;
        int index2 = 0;
        double result = 0d;
        while((index1+index2)<mid){
        	if(nums1[index1]<=nums2[index2]){
        		while((index1+index2)<mid&&nums1[index1]<=nums2[index2]) index1++;
            	result = (nums1[index1-1]+nums2[index2])/2d;
        	}else{
        		while((index1+index2)<mid&&nums1[index1]>nums2[index2]) index2++;
            	result = (nums1[index1]+nums2[index2-1])/2d;
        	}
        	if((index1+index2)>=mid){
        		break;
        	}
        	index1++;
        	index2++;
        }
        return result;
    }

    public double findMedianSortedArraysNew(int[] nums1, int[] nums2) {
        int mid = (nums1.length+nums2.length)>>1;
        int index1 = 0;
        int index2 = 0;
        double result = 0d;
        boolean flag = (mid*2==(nums1.length+nums2.length))?true:false;
        while((index1+index2)<mid){
        	while(index1<nums1.length&&(index1+index2)<mid&&nums1[index1]<=nums2[index2]){
            	if((index1+index2)>=mid){
            		if(flag)
            			result = (nums1[index1]+nums2[index2])/2d;
            		else if(nums1[index1]>=nums1[index2])
            			result = nums1[index2];
            		else if(nums1[index1]<nums1[index2])
            			result = nums1[index1];
            		break;
            	}
        		index1++;
        	}
        	while(index2<nums2.length&&(index1+index2)<mid&&nums1[index1]>nums2[index2]){
            	if((index1+index2)>=mid){
            		if(flag)
            			result = (nums1[index1]+nums2[index2])/2d;
            		else if(nums1[index1]>=nums1[index2])
            			result = nums1[index2];
            		else if(nums1[index1]<nums1[index2])
            			result = nums1[index1];
            		break;
            	}
            	index2++;
        	}
        }
        System.out.println("index1: "+index1);
        System.out.println("index2: "+index2);
        return result;
    }

    public double findMedianSortedArraysNewNew(int[] nums1, int[] nums2) {
    	if(nums1.length+nums2.length==0)
    		return 0d;
        int mid = (nums1.length+nums2.length)>>1;
        int index1 = 0;
        int index2 = 0;
        List<Double> container = new LinkedList<>();
        container.add(0d);
        container.add(0d);
        boolean flag = (mid*2==(nums1.length+nums2.length))?true:false;
        while((index1+index2)<=mid){
            double result = 0d;
        	if(index1>=nums1.length){
        		result = nums2[index2];
//                System.out.println("result2: "+result);
                container.remove(1);
                container.add(0, result);
        		index2++;
        		continue;
        	}
        	if(index2>=nums2.length){
        		result = nums1[index1];
//                System.out.println("result1: "+result);
                container.remove(1);
                container.add(0, result);
        		index1++;
        		continue;
        	}
        	if(nums1[index1]>nums2[index2]){
        		result = nums2[index2];
//                System.out.println("result2: "+result);
        		index2++;
        	}else{
        		result = nums1[index1];
//                System.out.println("result1: "+result);
        		index1++;
        	}
            container.remove(1);
            container.add(0, result);
        }
        System.out.println("container: "+container.get(0)+"~"+container.get(1));
//        System.out.println("result: "+result);
        if(flag){
        	return (container.get(0)+container.get(1))/2;
        }
        return container.get(0);
    }
    
    public static void main(String[] args) {
		int[] nums1 = {};
		int[] nums2 = {};
		System.out.println(new MedianofTwoSortedArrays4().findMedianSortedArraysNewNew(nums1, nums2));
	}
}
