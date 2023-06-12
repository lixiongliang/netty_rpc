package mianshi;

import java.util.Scanner;

public class C9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] =sc.nextInt();
        }
        int m = sc.nextInt();
        int sum =0;
        for (int i = 0; i <m ; i++) {
            sum+=array[i];
        }
        int max = sum;
        if(n > m){
            for (int i = 0; i < (n-m); i++) {
                sum+=array[m+i]-array[i];
                if(sum > max){
                    max =sum;
                }
            }
        }
        System.out.println(max);
    }
}
