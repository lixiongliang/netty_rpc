package mianshi.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class T32 {

    static Pattern reg1 = Pattern.compile("[^aeiou][aeiou][^aeiour]e");
    //static Pattern reg2 = Pattern.compile("e[^aeiou][aeiou][^aeiour]");
//ekam a ekac
    // make
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int count = 0;
        List<String> list = new ArrayList();
        for (String e : s1) {
            if (isFz(e)) {
                String fzString = getFzString(e);
                boolean b = reg1.matcher(fzString).find();
                if (b) {
                    count++;
                }

            }
        }
        System.out.println(count);
    }

    /**
     * 反转字符串
     *
     * @param e
     * @return
     */
    public static String getFzString(String e) {
        StringBuilder sb = new StringBuilder();
        char[] chars = e.toCharArray();
        int n = chars.length;
        for (int i = n - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    /**
     * 判定字符串是否合法
     *
     * @param a
     * @return
     */
    public static boolean isFz(String a) {
        char[] chars = a.toCharArray();
        boolean f = true;
        for (char c : chars) {
            if (c >= 'a' && c <= 'z') {
                f = true;
            } else {
                f = false;
            }
        }
        return f;
    }

}
