package CLASS4;

import java.io.*;
import java.util.StringTokenizer;

public class boj1991 {
    static class Node{
        char left, right;
        char name;

        public Node(char name, char left, char right) {
            this.left = left;
            this.right = right;
            this.name = name;
        }

        public Node(char name) {
            this.name = name;
        }
    }

    static Node[] nodes;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{

        int N = Integer.parseInt(br.readLine());

        nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            char name = (char)(i+'A');
            nodes[i] = new Node(name);
        }

        // initialize;
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            char name = str[0].charAt(0);
            char left = str[1].charAt(0);
            char right = str[2].charAt(0);
            nodes[name-'A'].left = left;
            nodes[name-'A'].right =right;
        }

        preorder('A');
        bw.append("\n");
        inorder('A');
        bw.append("\n");
        postorder('A');

        bw.flush();
        bw.close();
        br.close();
    }

    private static void postorder(char n) throws IOException{
        if (n != '.') {
            if(nodes[n-'A'].left!='.') postorder(nodes[n - 'A'].left);
            if(nodes[n-'A'].right!='.') postorder(nodes[n - 'A'].right);
            bw.append(Character.toString(n));
        }
    }

    private static void inorder(char n) throws IOException {
        if (n != '.') {
            if(nodes[n-'A'].left!='.') inorder(nodes[n - 'A'].left);
            bw.append(Character.toString(n));
            if(nodes[n-'A'].right!='.') inorder(nodes[n - 'A'].right);
        }
    }

    private static void preorder(char n) throws IOException {
        if (n != '.') {
            bw.append(Character.toString(n));
            if(nodes[n-'A'].left!='.') preorder(nodes[n - 'A'].left);
            if(nodes[n-'A'].right!='.') preorder(nodes[n - 'A'].right);
        }
    }

}
