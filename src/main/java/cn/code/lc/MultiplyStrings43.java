package cn.code.lc;

import java.util.Stack;

public class MultiplyStrings43 {

    public String multiply(String num1, String num2) {
    	int notation = 2;
        Stack<Character> num1C = new Stack<Character>();
        Stack<Character> num2C = new Stack<Character>();
        for(int i=0;i<num1.length();i++){
        	num1C.push(num1.charAt(i));
        }
        for(int i=0;i<num2.length();i++){
        	num2C.push(num2.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        int pre = 0;
        while(!num1C.isEmpty()&&!num2C.isEmpty()){
        	int tmp1 = num1C.pop()-'0';
        	int tmp2 = num2C.pop()-'0';
        	int tmp = tmp1+tmp2+pre;
        	pre = tmp/notation;
        	result.insert(0,tmp%notation);
        }
        while(!num1C.isEmpty()){
        	int tmp = (num1C.pop()-'0')+pre;
        	pre = tmp/notation;
        	result.insert(0,tmp%notation);
        }
        while(!num2C.isEmpty()){
        	int tmp = (num2C.pop()-'0')+pre;
        	pre = tmp/notation;
        	result.insert(0,tmp%notation);
        }
        return (pre==0)?(result.toString()):(result.insert(0,pre).toString());
    }
    
    public static void main(String[] args) {
		System.out.println(new MultiplyStrings43().multiply("0", "0"));
        StringBuilder result = new StringBuilder();
//        result.append("1");
        result.insert(0, "2");
        System.out.println(result);
	}
}
