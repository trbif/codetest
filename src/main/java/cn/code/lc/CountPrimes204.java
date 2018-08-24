/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018��3��22�� ����1:47:32
 * @version V1.0
 * @˵��:
 */
public class CountPrimes204 {

    public int countPrimes(int n) {
    	int result = 0;
        for(int i=1;i<n;i++){
        	if(isPrime(i)){
        		result++;
        	}
        }
        return result;
    }
    
    private boolean isPrime(int num){
    	if(num==1)
    		return false ;  
        //������С�����⴦��  
    	if(num==2||num==3)
    		return true ;  
        //����6�ı��������һ����������  
        if(num%6!=1&&num%6!=5)
        	return false ;  
        int tmp = (int)Math.sqrt(num);  
        //��6�ı��������Ҳ���ܲ�������  
        for(int i=5;i<=tmp;i+=6){
        	if(num %i==0||num %(i+2)==0){
                return false ;  
        	}
        }
        //�ų����У�ʣ���������  
        return true ;  
    }
    
    public static void main(String[] args) {
		System.out.println(new CountPrimes204().countPrimes(1));
	}
}
