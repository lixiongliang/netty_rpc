package mianshi.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 双指针：最长连续子序列
 */
public class T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = Integer.parseInt(sc.nextLine());

        Integer[] integers = Arrays.stream(sc.nextLine().split(","))
                .map(e -> Integer.parseInt(e)).toArray(Integer[]::new);
        int result = getResult(integers, sum);
        System.out.println(result);
    }

    public static int getResult(Integer[] arr, int sum) {
        int ans = -1;
        int l = 0;
        int r = 0;
        int n = arr.length;
        int total = arr[l];
        while (true) {
            if (total > sum) {
                l++;
                if (r < l) r = l;
                total = total - arr[l - 1];
            } else if (total < sum) {
                r++;
                if (r < n) {
                    total += arr[r];
                } else {
                    break;
                }
            } else {
                ans = Math.max(ans, r - l + 1);
                l++;
                r++;
                if (r < n) {
                    total += arr[r] - arr[l - 1];
                } else {
                    break;
                }
            }

        }

        return ans;
    }

}
