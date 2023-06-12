package mianshi;

import java.util.*;

public class C7 {

    static class Node {
        private int val;

        private Node left;
        private Node right;

        Node(int val) {
            this.val = val;

        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    private static Queue<Integer> queue = new ArrayDeque<>();
    private static Queue<Node> nodes = new ArrayDeque<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Arrays.stream(line.split(" ")).forEach(e -> queue.add(Integer.parseInt(e)));
        Node root = build();
        remove(root);

        List<String> p = new ArrayList<>();
        print(root, p);
        System.out.println(String.join(" ", p));

    }

    public static Node build() {
        Node root = new Node(queue.poll());
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node top = nodes.poll();
            if (!queue.isEmpty()) {
                Integer val = queue.poll();
                Node left = new Node(val);
                top.left = left;
                nodes.add(left);
            }else{
                break;
            }
            if (!queue.isEmpty()) {
                Integer val = queue.poll();
                Node right = new Node(val);
                top.right = right;
                nodes.add(right);

            }else{
                break;
            }
        }
        return root;
    }

    public static Node remove(Node root) {
        if(root == null){
            return null;
        }
        if(root.left==null && root.right == null){
            return null;
        }
        root.left=remove(root.left);
        root.right=remove(root.right);
        return root;
    }


    public static void print(Node root, List<String> p) {
        if(root == null){
            return;
        }
        print(root.left,p);
        print(root.right,p);
        p.add(String.valueOf(root.val));
    }

}
