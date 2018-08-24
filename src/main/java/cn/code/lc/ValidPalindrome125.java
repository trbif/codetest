package cn.code.lc;

public class ValidPalindrome125 {

    public boolean isPalindrome(String s) {
    	if(s==null){
    		return true;
    	}
    	s = s.trim().toLowerCase();
    	int left = 0;
    	int right = s.length()-1;
    	while(left<right){
    		if((s.charAt(left)<'a'||s.charAt(left)>'z')&&(s.charAt(left)<'0'||s.charAt(left)>'9')){
    			while(left<right&&(s.charAt(left)<'a'||s.charAt(left)>'z')&&(s.charAt(left)<'0'||s.charAt(left)>'9')) left++;
    		}
    		if(s.charAt(right)<'a'||s.charAt(right)>'z'){
    			while(left<right&&(s.charAt(right)<'a'||s.charAt(right)>'z')&&(s.charAt(right)<'0'||s.charAt(right)>'9')) right--;
    		}
    		if(left<right&&s.charAt(left)!=s.charAt(right)){
    			return false;
    		}
    		left++;
    		right--;
    	}
        return true;
    }
    
    public static void main(String[] args) {
		System.out.println(new ValidPalindrome125().isPalindrome(".jq"));
//		System.out.println("..".trim().toLowerCase().length());
	}
}
