package cn.code.lc;

import java.util.ArrayList;
import java.util.List;

public class WordLadderII126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    	List<List<String>> result = new ArrayList<List<String>>();
		helper(result,beginWord,endWord,wordList,0,new ArrayList<String>());
    	return result;
    }
    
    private void helper(List<List<String>> result,String current, String target, List<String> wordList,int deep,List<String> toAdd){
    	if(current.equals(target)){
    		result.add(new ArrayList<String>(toAdd));
    		return;
    	}
    	List<String> possible = new ArrayList<String>();
    	for(int i=0;i<wordList.size();i++){
    		int distance = 0;
    		String word = wordList.get(i);
    		for(int j=0;j<current.length();j++){
    			if(word.charAt(j)-current.charAt(j)!=0) distance++;
    		}
    		if(distance==1){
    			possible.add(word);
    			wordList.remove(word);
    		}
    	}
    	for(String word:possible){
			toAdd.add(word);
			wordList.add(word);
			helper(result,word,target,wordList,deep+1,toAdd);
			if(possible.size()>1){
				wordList.remove(word);
			}
			toAdd.remove(word);
    	}
    }
    
    public static void main(String[] args) {
//    	String[] words = {"hot","dot","dog","lot","log","cog"};
    	String[] words = {"mot","dot","dog"};
		List<String> wordList = new ArrayList<>();
		for(String word:words){
			wordList.add(word);
		}
		System.out.println(new WordLadderII126().findLadders("hot", "dog", wordList));
	}
}
