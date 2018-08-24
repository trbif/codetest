/**
 * 
 */
package cn.code.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqi
 * @date 2018��3��16�� ����8:45:02
 * @version V1.0
 * @˵��:
 */
public class SelfDividingNumbers728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
    	List<Integer> result = new ArrayList<Integer>();
        for(int i=left;i<=right;i++){
        	int tmp = i;
        	boolean flag = true;
        	while(tmp!=0){
        		System.err.println(tmp);
        		if(tmp%10!=0&&i%(tmp%10)==0){
        			tmp /= 10;
        			continue;
        		}
        		flag = false;
        		break;
        	}
        	if(flag){
        		result.add(i);
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
		System.out.println(new SelfDividingNumbers728().selfDividingNumbers(22, 22));
	}
}
