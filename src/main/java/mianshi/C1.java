package mianshi;

import java.util.Scanner;

public class C1 {

    public static void main(String[] args) {
        computerInputCharLength();
        //System.out.printf("%s","hello world");
    }

    public static void computerInputCharLength(){
        /**
         * 1 a 1 1 1 3
         * 2 ctrl-c  复制
         * 3  ctr-x 剪切
         * 4 ctr-v  粘贴
         * 5 ctr-a 全选
         * 1 1 5
         */
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String totalStr = in.nextLine();
            int count = 0;
            int copyCount =0;
            int selCount =0;

            for(char op:totalStr.toCharArray()){
                if(op == '1'){
                    count = selCount > 0 ?1:count+1;
                    selCount = 0;
                } else if (op == '2') {
                    //复制
                    copyCount =  selCount;
                }else if (op == '3') {
                    //jian qie
                    count-= selCount;
                    copyCount = selCount;
                    selCount = 0;
                }else if (op == '4') {
                    //zhan tie
                    count-= selCount;
                    selCount = 0;
                    count+=copyCount;
                }else if (op == '5') {
                    //quan xuan
                    selCount = count;
                }
            }
            System.out.println(count);
        }

    }
}
