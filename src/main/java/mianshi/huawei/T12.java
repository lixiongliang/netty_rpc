package mianshi.huawei;

import java.util.Scanner;

/**
 * 回溯算法
 */
public class T12 {
    static String [] matrix;
    static String word;
    static  int n ;
    static  int m ;
    static boolean [][] visited;

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        word = sc.next();
        matrix = new String[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = sc.next();
        }
        System.out.println(getResult());
    }

    public static String getResult(){
    visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(backTracking(i,j,0)){
                    return (i+1)+" "+(j+1);
                }
            }
        }
        return "NO";
    }

    /**
     * 回溯方法
     * @param i  数组的下标
     * @param j 字符串的下标
     * @param k 目标字符串的下标
     * @return
     */

    public static boolean backTracking(int i,int j,int k){
        if(k == word.length())return true;
        if(i<0
        || i>=n
         || j< 0
         || j>=m
         || visited[i][j]
         || matrix[i].charAt(j) != word.charAt(k)
        ){
            return false;
        }
        visited[i][j] =true;
        int newK = k+1;
        boolean res = backTracking(i-1,j,newK)
                || backTracking(i+1,j,newK)
                || backTracking(i,j-1,newK)
                ||backTracking(i,j+1,newK);
        visited[i][j] = true;
        return res;

    }
}
