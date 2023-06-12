package mianshi.huawei;
/**
 * 移除k 个数字，寻找最小数
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class T24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        int count = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(num1,count));

    }

    public String minWindow (String S, String T) {
        // write code here
        char[] chars = S.toCharArray();
        char[] charsTarget = T.toCharArray();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < charsTarget.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if(charsTarget[j] == chars[i]){
                    set.add(i);
                    break;
                }
            }
            char aChar = chars[i];

        }
        return "";
    }


    private static String
    getResult(String num1,int removeCount){

        if(num1.length() ==  removeCount) return  "0";

        int remainCount = num1.length() - removeCount;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < num1.length(); i++) {
            while (stack.size()>0 && removeCount > 0 &&
            stack.getLast() > num1.charAt(i)){
                stack.removeLast();
                removeCount--;
            }
            stack.add(num1.charAt(i));
        }
        while (stack.size() > remainCount){
            stack.removeLast();
        }
        while (stack.getFirst() == '0' && stack.size() != 1){
            stack.removeFirst();
        }
        StringBuilder sb = new StringBuilder();
        for (Character c:stack){
            sb.append(c);
        }
        return sb.toString();
    }

}
