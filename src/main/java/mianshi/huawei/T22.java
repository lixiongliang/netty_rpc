package mianshi.huawei;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class T22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String target = sc.nextLine();
        String[] stream = sc.nextLine().split(" ");

        System.out.println(getResult(stream, target));
    }

    public static String getResult(String[] stream, String target) {
        int i = 0;

        while (i < stream.length) {
            String tag = stream[i++];

            String tmp1 = stream[i++];
            String tmp2 = stream[i++];

            int len = Integer.parseInt(tmp1 , 16)+
                    Integer.parseInt(tmp2 , 16);

            ArrayList<String> val = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                val.add(stream[i++]);
            }

            if (tag.equals(target)) {
                StringJoiner sj = new StringJoiner(" ");
                for (String s : val) sj.add(s);
                return sj.toString();
            }
        }

        return null;
    }

}
