package mianshi;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class C2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Integer request = Integer.parseInt(sc.nextLine());
        sc.close();
        TreeSet<Integer> set = new TreeSet<>();
        for (String str : input.split(",")) {
            if (str.contains("-")) {
                String[] split = str.split("-");
                int start = Integer.parseInt(split[0]);
                int end = Integer.parseInt(split[1]);
                for (int i = start; i <= end; i++) {
                    set.add(i);
                }
            } else {
                set.add(Integer.parseInt(str));
            }
        }
        set.remove(request);

        ArrayList<Integer> list = new ArrayList();
        StringBuffer sb = new StringBuffer();
        Integer start = list.get(0);
        Integer last = start;

}
}
