package mianshi.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 字符串分割
 */
public class T5 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println(sc.nextLine());

        String a = "/abc///df//dd";
        System.out.println(a.replaceAll("/+","/"));

    }

    public static int getResult(String s) {
        char[] cArr = s.toCharArray();
        int n = cArr.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + cArr[i - 1];
        }
        System.out.println("preSum==" + preSum.toString());

        ArrayList<Integer> res = new ArrayList<>();
        recursive(preSum, n, 0, 0, res);
        if (res.size() == 0) return 0;
        else if (res.size() == 1) return res.get(0);
        else return -1;

    }

    public static void recursive(int[] preSum, int n
            , int start, int count, ArrayList res) {
        if (start == n) {
            res.add(count);
            return;
        }
        for (int end = start + 1; end <= n; end++) {
            if (isSxh(preSum[end] - preSum[start])) {
                recursive(preSum, n, end, count + 1, res);
            }
        }
    }

    public static boolean isSxh(int num) {
        if (num <= 99 || num >= 1000) {
            return false;
        }
        String[] temp = (num + "").split("");
        int x = Integer.parseInt(temp[0]);
        int y = Integer.parseInt(temp[1]);
        int z = Integer.parseInt(temp[2]);
        return num == x * x * x + y * y * y + z * z * z;
    }


}
