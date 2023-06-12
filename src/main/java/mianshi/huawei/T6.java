package mianshi.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 考察 逻辑分析：整数对最小和
 */
public class T6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int result = getResult(arr1, arr2, k);
        System.out.println(result);
    }

    public static int getResult(int[] arr1,
                                int[] arr2,
                                int k) {
        ArrayList<Integer> pairs = new ArrayList<>();
        for (int v1 : arr1) {
            for (int v2 : arr2) {
                pairs.add(v1 + v2);
            }
        }
        pairs.sort(Comparator.comparingInt(a -> a));
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += pairs.get(i);
        }
        return sum;
    }
}
