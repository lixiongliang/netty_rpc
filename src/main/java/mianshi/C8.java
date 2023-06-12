package mianshi;

import java.util.Scanner;

public class C8 {

    public static void main(String[] args) {
        Scanner br = new Scanner(System.in);
        String str = br.nextLine();
        int sum = br.nextInt();
        String[] list = str.split(",");
        int max = -1;
        for (int i = 0; i < list.length; i++) {
            int temp = sum;
            for (int j = i; j < list.length; j++) {
                temp -= Integer.parseInt(list[j]);
                if (temp == 0) {
                    max = max > j - i ? max : j - i;
                }
            }
        }
        max = max > -1 ? max + 1 : -1;
        System.out.println(max);
    }

}
