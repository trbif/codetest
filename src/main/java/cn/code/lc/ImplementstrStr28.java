package cn.code.lc;

public class ImplementstrStr28 {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStrNew(String haystack, String needle) {
    	if(haystack.equals(needle)){
    		return 0;
    	}
		int start = 0;
		int index = -1;
		int i=0;
    	for(;i<haystack.length();i++){
    		if(start<needle.length()&&haystack.charAt(i)==needle.charAt(start)){
    			start++;
    		}else if(start==needle.length()){
    			index = i-start;
    			break;
    		}else{
    			i = i-start;
    			start = 0;
    		}
    	}
    	if(i==haystack.length()&&start==needle.length()){
			index = haystack.length()-start;
		}
        return index;
    }
    
    public static void main(String[] args) {
//		System.out.println(new ImplementstrStr28().strStrNew("mississippi", "issip"));
//		System.out.println(new ImplementstrStr28().strStrNew("mississippi", "pi"));
//		System.out.println(new ImplementstrStr28().strStrNew("hello", "lo"));
		System.out.println(new ImplementstrStr28().strStrNew("aaaaa", "bba"));
	}
}
