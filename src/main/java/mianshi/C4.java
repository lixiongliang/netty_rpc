package mianshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C4 {

    public static void main(String[] args) {
        //extracted();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] h = new int[n];
            int [] w= new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                w[i] = in.nextInt();
            }

            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i+1,h[i],w[i]);
            }
            Arrays.sort(nodes);

            for (int i = 0; i < n; i++) {
                System.out.printf("%d",nodes[i].i);
            }
        }
    }

    private static void extracted() {
        Scanner sc = new Scanner(System.in);
        String heightStr = sc.nextLine();
        String withStr = sc.nextLine();
        List<Student> list = new ArrayList<>();
        String[] s = heightStr.split(" ");
        String[] s2 = withStr.split(" ");

        for (int i = 0; i < s.length; i++) {
            int height = Integer.parseInt(s[i].trim());
            int with = Integer.parseInt(s2[i].trim());
            Student student = new Student(height, with, i+1);
            list.add(student);
        }
        list = list.stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d,", list.get(i).studentNo);
        }
    }

    static class Student implements Comparable<Student> {
        private Integer height;
        private Integer with;

        private Integer studentNo;

        public Student(int height, int with, Integer studentNo) {
            this.height = height;
            this.with = with;
            this.studentNo = studentNo;
        }

        @Override
        public int compareTo(Student o2) {

            if (o2 == null) {
                return 1;
            }
            if (this.height < o2.height) {
                return -1;
            } else if (this.height > o2.height) {
                return 1;
            } else {
                if (this.with < o2.with) {
                    return -1;
                } else if (this.with > o2.with) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int i;
        int h;
        int w;
        Node(int i,int h,int w){
            this.i=i;
            this.h=h;
            this.w=w;
        }

        @Override
        public int compareTo(Node o) {
            if(h != o.h){
                return h- o.h;
            }
            if(w != o.w){
                return w -o.w;
            }
            return i-o.i;
        }
    }

}
