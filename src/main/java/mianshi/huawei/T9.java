package mianshi.huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 26数组二叉树
 */
public class T9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer [] arr = Arrays.stream(sc.nextLine()
                .split(" ")).map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    public static String getResult(Integer []  arr){
        int n = arr.length -1;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = n; i >=1 ; i--) {
            if(arr[i] != -1){
                if(i*2 +1 <=n && arr[i*2+1] != -1){
                    continue;
                }
                if(i*2 +2 <=n && arr[i*2+2] != -1){
                    continue;
                }
                if(min > arr[i]){
                    min = arr[i];
                    minIdx = i;
                }
            }
        }

        LinkedList<Integer> path = new LinkedList<>();
        path.addFirst(min);
        while (minIdx!=0){
            int f = (minIdx -1)/2;
            path.addFirst(arr[f]);
            minIdx = f;
        }
        StringJoiner sj = new StringJoiner(" ");
        for (Integer val : path){
            sj.add(val+"");
        }
        return  sj.toString();
    }
}
