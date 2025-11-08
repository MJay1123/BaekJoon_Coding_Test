package Silver.S1.BOJ1991;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[52];
        arr[0] = "A";
        int[] arr2 = new int[26];
        for(int i=0; i<26; i++) {
            arr2[i] = -1;
        }
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();
            int parentIndex = parent.charAt(0) - 'A';
            int leftChildIndex = leftChild.charAt(0) - 'A';
            int rightChildIndex = rightChild.charAt(0) - 'A';
            if(leftChildIndex >= 0) {
                arr2[leftChildIndex] = parentIndex;
            }
            if(rightChildIndex >= 0) {
                arr2[rightChildIndex] = parentIndex;
            }
            putInNode(arr, parent, leftChild, rightChild);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
    static class Node {
        char name;
        char leftChild;
        char rightChild;
        public Node(char name, char leftChild, char rightChild){
            this.name = name;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    public static void putInNode(String[] arr, String parent, String leftChild, String rightChild){
        int index = -1;
        for(int i=0; i<arr.length; i++){
            if (arr[i] != null && arr[i].equals(parent)) {
                index = i;
                break;
            }
        }
        arr[index*2 + 1] = leftChild;
        arr[index*2 + 2] = rightChild;
    }
}
