package mianshi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C3 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        int[] valan = new int[4094];
        try {
            str = br.readLine();
            int num = Integer.parseInt(br.readLine());
            String[] split = str.split(",");
            for (String s : split) {
                try {
                    int index = Integer.parseInt(s);
                    if (index == num) continue;
                    valan[index] = 1;
                } catch (Exception e) {
                    if (s.contains("-")) {
                        String[] s_s = s.split("-");
                        int first = Integer.parseInt(s_s[0]);
                        int end = Integer.parseInt(s_s[1]);
                        for (int i = first; i <= end; i++) {
                            if (num != i) {
                                valan[i] = 1;
                            }
                        }
                    }
                }

            }

            StringBuilder result = new StringBuilder();
            for (int i = 1; i < valan.length; i++) {
                if (valan[i] == 1) {
                    result.append(",");
                    result.append(i);
                    if (++i < valan.length && valan[i] == 1) {
                        result.append("-");
                        while (valan[++i] == 1) {

                        }
                        result.append(i - 1);
                    }
                }
            }

            String resultStr = result.toString();
            if (result.indexOf(",") == 0) {
                resultStr = resultStr.substring(1);
            }
            System.out.println(resultStr);


        } catch (Exception e) {

        }
    }
}
