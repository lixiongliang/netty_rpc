package mianshi.huawei;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

public class T23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(",");
        System.out.println(getResult(arr));

    }

    public static String getResult(String[] arr) {
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, Integer> first = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
            first.putIfAbsent(arr[i], i);
        }
        StringJoiner sj = new StringJoiner(",");
        first.keySet().stream().sorted((a, b) -> {
            int countA = count.get(a);
            int countB = count.get(b);
            if (countA != countB) {
                return countB - countA;
            } else {
                Integer firstA = first.get(a);
                Integer firstB = first.get(b);
                return firstA - firstB;

            }
        }).forEach(s -> sj.add(s));
        return sj.toString();


    }
}
