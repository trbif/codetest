/**
 * 
 */
package cn.code.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqi
 * @date 2018年2月22日 上午10:42:47
 * @version V1.0
 * @说明:
 */
public class ReverseInteger {
	
	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(153423646));
//														2147483647
	}
	
    public int reverse1(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        int result = 0;
        List<Integer> list = new ArrayList<>();
        while(x>0){
        	list.add(x%10);
        	x /= 10;
        }
        for(int i=list.size()-1;i>=0;i--){
        	System.out.println(list.get(i));
        	result += list.get(i)*(int)Math.pow(10, list.size()-i-1);
        }
        return sign*result;
    }
    

    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        int result = 0;
        while (x > 0) {
        	int newResult = result * 10 + x % 10;
        	if ((newResult - x % 10) / 10 != result){
        		return 0;
        	}
        	result = newResult;
            x /= 10;
        }
        
        return sign * result;
    }
}
