/**
 * 
 */
package cn.code.lc;

import java.util.*;

/**
 * @author zhangqi
 * @date 2018年3月21日 下午3:33:23
 * @version V1.0
 * @说明:
 */
public class GroupAnagrams49 {

    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<String,List<String>> helper = new HashMap<String,List<String>>();
    	for(String str:strs){
    		char[] tmp = str.toCharArray();
    		Arrays.sort(tmp);
    		String key = new String(tmp);
    		if(helper.containsKey(key)){
    			helper.get(key).add(str);
    		}else{
    			List<String> list = new ArrayList<String>();
    			list.add(str);
    			helper.put(key, list);
    		}
    	}
    	return new ArrayList<List<String>>(helper.values());
    }
    
    public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(new GroupAnagrams49().groupAnagrams(strs));
	}
}
