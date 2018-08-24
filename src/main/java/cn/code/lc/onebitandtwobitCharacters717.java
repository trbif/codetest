package cn.code.lc;

public class onebitandtwobitCharacters717 {

    public boolean isOneBitCharacter(int[] bits) {
    	int sum = 0;
    	for(int i=0;i<bits.length-1;i++){
    		if(bits[i]=='0'){
    			sum += 1;
    		}else{
    			sum += 2;
    			i++;
    		}
    	}
        return (bits.length-1)==sum;
    }
    
    public static void main(String[] args) {
    	int[] bits = {'1','1','1','0'};
		System.out.println(new onebitandtwobitCharacters717().isOneBitCharacter(bits));
	}
}
