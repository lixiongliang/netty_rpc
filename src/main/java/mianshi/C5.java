package mianshi;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class C5 {
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
        ArrayList<Integer> list = new ArrayList<>(set);
        StringBuilder sb = new StringBuilder();
        Integer start = list.get(0);
        Integer last = start;
        for (int i = 1; i < list.size(); i++) {
            Integer cur = list.get(i);
            if (cur == last + 1) {
                last = cur;
            } else {
                append(sb, start, last);
                start = last = cur;
            }
        }
        append(sb, start, last);
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static void append(StringBuilder sb, Integer start, Integer last) {
        if (start.equals(last)) {
            sb.append(last).append(",");
        } else {
            sb.append(start).append("-").append(last).append(",");
        }
    }
}
