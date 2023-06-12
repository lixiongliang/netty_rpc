package mianshi.huawei;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 消消乐游戏
 */
public class T25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    public static int getResult(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 'A' || c > 'z' || (c > 'Z' && c < 'a')) {
                return 0;
            }
            if (stack.size() > 0 && c == stack.getLast()) {
                stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }
        return stack.size();
    }
}
