package mianshi;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class C10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] tChars = sc.nextLine().toCharArray();
        char[] sChars = sc.nextLine().toCharArray();
        LinkedHashMap<Character, Integer> characterIntegerLinkedHashMap = new LinkedHashMap<>();
        int des = sChars.length;
        if (tChars.length > 0 && sChars.length > 0) {
            for (int j = tChars.length-1; j > 0 ; j--) {

                for (int i = sChars.length-1; i >0; i--) {

                    if(tChars[j] == sChars[i] & des > i){
                        des = i;
                        characterIntegerLinkedHashMap.put(tChars[j],i);
                        break;
                    }
                }
            }
            int ros =0;
            for (int j = tChars.length - 1; j >0 ; j--) {

            }

        }
    }
}
