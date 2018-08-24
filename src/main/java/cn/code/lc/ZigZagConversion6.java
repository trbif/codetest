/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月15日 下午2:26:28
 * @version V1.0
 * @说明:
 */
public class ZigZagConversion6 {

    public String convert(String s, int numRows) {
    	StringBuilder result = new StringBuilder();
    	for(int i=0;i<numRows;i++){
    		for(int j=0;;j++){
    			int index = (2*numRows-2)*j+i;
    			if(index-numRows+1<s.length()){
    				if(j!=0){
	    				result.append(s.charAt(index-j));
	    				result.append(s.charAt(index+j));
    				}else{
	    				result.append(s.charAt(index));
    				}
    			}
    		}
    	}
        return null;
    }
    
    //wrong answer
    public String convertNew(String s, int numRows) {
    	char[] result = new char[s.length()];
    	int helper = numRows*2-2;
    	int[] deep = new int[helper];
    	int[] flag = new int[helper];
    	for(int i=0;i<helper;i++){
    		deep[i] = (i>numRows-1)?(deep[i-1]-1):(i);
    		flag[i] = (i>numRows-1)?(1):(0);
    	}
    	int index = 0;
    	int roller = 0;
    	int length = 0;
    	int count = 0;
    	while(index<s.length()){
    		index = deep[roller]+((numRows-2)*2+1+flag[roller])*length;
    		result[index] = s.charAt(count++);
    		length = count/helper;
    		roller = count%helper;
    	}
        return null;
    }
    public String convertNewNew(String s, int numRows) {
    	numRows = (numRows>s.length())?(s.length()):numRows;
    	if(s==null||s.equals("")||numRows==1){
    		return s;
    	}
    	StringBuilder toReturn = new StringBuilder();
    	char[] result = new char[s.length()];
    	int[] rowsSize = new int[numRows+1];
    	rowsSize[0] = 0;
    	int helper = 2*numRows-2;
    	int[] deep = new int[helper];
    	for(int i=0;i<helper;i++){
    		deep[i] = (i>numRows-1)?(deep[i-1]-1):(i);
    	}
    	int blockLength = s.length()/helper;
    	int extra = s.length()%helper;
    	for(int i=1;i<rowsSize.length;i++){
    		if(i!=1&&i!=rowsSize.length-1){
        		rowsSize[i] = blockLength*2;
    		}else{
        		rowsSize[i] = blockLength;
    		}
    		if(extra!=0){
        		if(i!=1&&i!=rowsSize.length-1&&extra+1==(numRows-i-1)*2){
        			rowsSize[i] += 2;
        			extra -= 2;
        		}else{
        			rowsSize[i] += 1;
        			extra--;
        		}
    		}
    		rowsSize[i] += rowsSize[i-1];
    	}
    	for(int i=0;i<rowsSize.length;i++){
    		System.out.println((rowsSize[i]));
		}
    	for(int i=0;i<s.length();i++){
    		int index = i%helper;
    		int length = i/helper;
    		if(index==0||index==helper/2){
    			index = rowsSize[deep[index]]+length;
    		}else if(index>helper/2){
    			index = rowsSize[deep[index]]+2*length+1;
    		}else{
    			index = rowsSize[deep[index]]+2*length;
    		}
    		result[index] = s.charAt(i);
    	}
    	for(int i=0;i<result.length;i++){
    		toReturn.append(result[i]);
		}
        return toReturn.toString();
    }
    
    public static void main(String[] args) {
    	String s = "abcdef";
		System.out.println(new ZigZagConversion6().convertNewNew(s, 6));
	}
}
