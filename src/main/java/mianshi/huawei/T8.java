package mianshi.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 数据结构 二叉树：25完全二叉树非叶子部分后序遍历
 *
 */
public class T8 {
    // 输入获取
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(arr));
    }

    // 算法入口
    public static String getResult(Integer[] arr) {
        if (arr.length == 1) return arr[0] + "";

        ArrayList<Integer> res = new ArrayList<>();
        dfs(arr, 0, res);

        StringJoiner sj = new StringJoiner(" ");
        for (Integer re : res) {
            sj.add(re + "");
        }

        return sj.toString();
    }

    public static void dfs(Integer[] arr, int root, ArrayList<Integer> res) {
        int left = root * 2 + 1;
        int right = root * 2 + 2;

        if (arr.length > left) {
            dfs(arr, left, res);
            if (arr.length > right) dfs(arr, right, res);
            res.add(arr[root]);
        }
    }
}
