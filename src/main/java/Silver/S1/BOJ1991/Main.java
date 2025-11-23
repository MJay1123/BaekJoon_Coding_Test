package Silver.S1.BOJ1991;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[26][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);
            arr[parent-'A'][0] = leftChild;
            arr[parent-'A'][1] = rightChild;
        }
        preorder(arr, 'A');
        sb.append("\n");
        inorder(arr, 'A');
        sb.append("\n");
        postorder(arr, 'A');
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
    public static void preorder(char[][] arr, char parent){
        sb.append(parent);
        char[] children = arr[parent-'A'];
        for(int i=0; i<2; i++){
            if(children[i] != '.'){
                preorder(arr, children[i]);
            }
        }
    }
    public static void inorder(char[][] arr, char parent){
        char[] children = arr[parent-'A'];
        if(children[0] != '.'){
            inorder(arr, children[0]);
        }
        sb.append(parent);
        if(children[1] != '.'){
            inorder(arr, children[1]);
        }
    }
    public static void postorder(char[][] arr, char parent){
        char[] children = arr[parent-'A'];
        if(children[0] != '.'){
            postorder(arr, children[0]);
        }
        if(children[1] != '.'){
            postorder(arr, children[1]);
        }
        sb.append(parent);
    }
}
