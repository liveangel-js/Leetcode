package edu.nju.software.js.leetcode.LeetCode65;
import java.awt.*;
import java.util.*;
/**
 * Created by liveangel on 2016-7-21.
 */
public class Solution {
    private enum ColorEnum {
        INVALID,
        SPACE,
        SIGN,
        DIGIT,
        DOT,
        EXPONENT,
        NUM_INPUT,
    }


    public boolean isNumber(String s) {
        boolean digit =false;
        boolean dot =false;
        boolean exp =false;

        int i = 0;
        while(s.charAt(i) == ' '){
            i++;
            if (i==s.length()){
                return false;
            }
        }
        if(s.charAt(i)=='+' || s.charAt(i)=='-'){
            i++;
        }

        for(;i<s.length();i++){
            if('.'==s.charAt(i)&&!dot){
                dot = true;
            }else if('e'==s.charAt(i)&&!exp&&digit){
                dot = exp = true;
                if(i+1<s.length() && (s.charAt(i+1)=='+' || s.charAt(i+1)=='-')){
                    i++;
                }
                if(i+1>=s.length() || !(s.charAt(i+1)>='0' && s.charAt(i+1)<='9')){
                    return false;
                }
            }else if (s.charAt(i)>='0' && s.charAt(i)<='9'){
                digit=true;
            }else{
                break;
            }
        }

        for(; i<s.length()&&s.charAt(i)==' ';i++){

        }

        return digit&&i==s.length();

    }
    public static void main(String args[]){
        System.out.print(new Solution().isNumber("0e"));
    }
}
