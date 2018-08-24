/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月22日 下午3:44:05
 * @version V1.0
 * @说明:
 */
public class AddDigits258 {

    public int addDigits(int num) {
        int tmp = num;
        while(tmp>=10){
        	int sum = 0;
            while(tmp!=0){
            	sum += tmp%10;
            	tmp /= 10;
            }
            tmp = sum;
        }
        return tmp;
    }
//    int[][] nums = {
//    		{0,1,2,3,4,5,6,7,8,9},
//    		{1,2,3,4,5,6,7,8,9,1},
//    		{2,3,4,5,6,7,8,9,1,2},
//    		{3,4,5,6,7,8,9,1,2,3},
//    		{4,5,6,7,8,9,1,2,3,4},
//    		{5,6,7,8,9,1,2,3,4,5},
//    		{6,7,8,9,1,2,3,4,5,6},
//    		{7,8,9,1,2,3,4,5,6,7},
//    		{8,9,1,2,3,4,5,6,7,8},
//    		{9,1,2,3,4,5,6,7,8,9}};
    public int addDigitsNew(int num){
    	return num==0?0:(num%9==0?9:(num%9));
    }
    
    public static void main(String[] args) {
		System.out.println(new AddDigits258().addDigitsNew(111));
	}
}
