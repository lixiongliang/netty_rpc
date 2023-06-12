package mianshi.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class T31 {
    /**
     * 100#101#1#5
     *
     * 1684340997
     *
     * invalid IP
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] integers = Arrays.stream(sc.nextLine().split("#"))
                .map(Integer::parseInt).toArray(Integer[]::new);
        if(integers.length !=4){
            System.out.println("invalid IP");
            return;
        }
        int t1 = integers[0];
        int t2 = integers[1];
        int t3 = integers[2];
        int t4 = integers[3];
        if(t1>=1 && t1 <=128 &&
                t2>=0 && t1 <=255 &&
                t3>=0 && t3 <=255 &&
                t4>=0 && t1 <=255){
        String t = getHString(t1)+getHString(t2)+getHString(t3)+getHString(t4);
         String result  =  Long.parseLong(t,16)+"";
            System.out.println(result);
        }else{
            System.out.println("invalid IP");
            return;
        }



    }

    public static  String getHString(Integer a){
        String tem = Integer.toHexString(a);
        if(tem.length()<2) {
            tem = "0"+tem;
        }
        return tem;
    }
}
