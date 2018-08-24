/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月12日 下午3:02:44
 * @version V1.0
 * @说明:
 */
public class SqrtX69 {

    public int mySqrt(int x) {
        long r = x;
        while(r*r>x){
        	r = (r + x/r) / 2;
        }
        return (int) r;
    }
    
    public static void main(String[] args) {
		System.out.println(new SqrtX69().mySqrt(8));
	}

}
