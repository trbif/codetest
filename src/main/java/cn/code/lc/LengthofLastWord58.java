package cn.code.lc;

public class LengthofLastWord58 {

    public int lengthOfLastWord(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}
