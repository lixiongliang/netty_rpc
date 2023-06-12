package mianshi;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C6 {
    static class Node{
        int val;
        Node next = null;
        Node(int val){
            this.val =val;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        if(M <=1 || M>=100){
            System.out.println("ERROR");
        }else {
            ArrayList<Integer> ans =new ArrayList<>();
            Node head = new Node(1),pre = head;
            for (int i = 2; i <=100 ; i++) {
                Node now = new Node(i);
                pre.next = now;
                pre = now;
            }
            pre.next =head;
            int num=100,k=1;
            while (true){
                k++;
                pre =pre.next;
                head=head.next;
                if(k == M){
                    pre.next= head.next;
                    head= pre.next;
                    k=1;
                    num--;
                }
                if(num < M){
                    pre =head;
                    do {
                        ans.add(head.val);
                        head= head.next;
                    }while (head!=pre);
                    break;
                }
            }

            Collections.sort(ans);

            for (int i = 0; i < ans.size(); i++) {
                System.out.printf("%d%c",ans.get(i),i==ans.size()-1?'\n':',');
            }
        }
    }
}
