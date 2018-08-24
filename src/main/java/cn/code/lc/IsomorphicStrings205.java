/**
 * 
 */
package cn.code.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangqi
 * @date 2018年3月22日 下午1:57:25
 * @version V1.0
 * @说明:
 */
public class IsomorphicStrings205 {

    public boolean isIsomorphic(String s, String t) {
    	Map<Character,Integer> mapS = new HashMap<Character,Integer>();
    	Map<Character,Integer> mapT = new HashMap<Character,Integer>();
        if(s.length()!=t.length()){
        	return false;
        }
        for(int i=0;i<s.length();i++){
        	char sC = s.charAt(i);
        	int val = -1;
        	if(mapS.containsKey(sC)){
        		val = mapS.get(sC);
        	}else{
        		mapS.put(sC, i);
        	}
        	char tC = t.charAt(i);
        	if(mapT.containsKey(tC)){
        		if(val!=mapT.get(tC)){
        			return false;
        		}
        	}else{
        		if(val!=-1){
        			return false;
        		}
        		mapT.put(tC, i);
        	}
        }
        return true;
    }

    //better way
    public boolean isIsomorphicNew(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
    
    
    public static void main(String[] args) {
		System.out.println(new IsomorphicStrings205().isIsomorphic("中国国", "美国过"));
	}
}
