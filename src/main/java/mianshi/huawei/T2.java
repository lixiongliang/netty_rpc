package mianshi.huawei;

import java.util.LinkedList;
import java.util.Scanner;

/**
    考察 滑动窗口算法： 求满足条件的最长子串的长度
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    private static int getResult(String str) {
        int maxLen = -1;
        boolean hasLetter = false;
        int l = 0, r = 0;
        LinkedList<Integer> letterIdx = new LinkedList<>();
        while (r < str.length()) {
            char c = str.charAt(r);
            if (isLetter(c)) {
                hasLetter = true;
                letterIdx.add(r);
                if (letterIdx.size() > 1) {
                    l = letterIdx.removeFirst() + 1;
                }
                if (r == l) {
                    r++;
                    continue;
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        if (!hasLetter) {
            return -1;
        } else {
            return maxLen;
        }
    }

    public static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z');
    }
}
