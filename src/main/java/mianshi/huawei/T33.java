package mianshi.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class T33 {
    /**
     * 2
     * 5
     * 1 2
     * 2 3
     * 3 4
     * 4 5
     * 5 6
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
        }
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        //对面试时间排序
        for (int i = 0; i < n - 1; i++) {
            boolean b = array[i][0] > array[i + 1][0];
            int t = array[i + 1][0];
            if (b) {
                array[i + 1][0] = array[i][0];
                array[i][0] = t;
            }
        }

        int max = 0;
        List<Integer[]> remainList = new ArrayList<>();
        List<Integer> list = new ArrayList<>(m);
        for (int i = 0; i <= n - 1; i++) {
            if (i == n - 1) {
                if (list.size() < m) {
                    list.clear();
                    max++;
                }
                continue;
            }
            boolean b = array[i][1] <= array[i + 1][0];
            if (b || i == 0) {
                if (list.size() == m) {
                    list.clear();
                    max++;
                } else {
                    list.add(1);
                    if (list.size() == m) {
                        list.clear();
                        max++;
                    }
                }
            } else {
                remainList.add(new Integer[]{array[i][0], array[i][1]});
            }
        }

        //剩余的场次，有时间重叠的面试
        list.clear();
        for (int i = 0; i < remainList.size(); i++) {
            boolean b = array[i][1] <= array[i + 1][0];
            if (b || i == 0) {
                if (list.size() == m) {
                    list.clear();
                    max++;
                } else {
                    list.add(1);
                }
            } else {
                max++;
            }
        }
        System.out.println(max);
    }
}
