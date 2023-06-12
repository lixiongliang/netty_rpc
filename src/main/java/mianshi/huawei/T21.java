package mianshi.huawei;

import java.util.Scanner;

/**
 * 密钥格式化
 */
public class T21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String str = sc.next();
        System.out.println(getResult(k,str));

    }

    public static String getResult(int k,String str){
        String[] split = str.split("-");
        String first = split[0];
         StringBuilder sb = new StringBuilder("");
        for (int i = 1; i < split.length; i++) {
            sb.append(split[i]);
        }
        String [] temp = sb.toString().split("");
        StringBuilder up = new StringBuilder("");
        up.append(first);

        for (int i = 0; i < temp.length; i++) {
            String v = temp[i].toUpperCase();
            if(i % k == 0){
                v= "-"+v;
            }
            up.append(v);
        }
        return up.toString();


    }
}
