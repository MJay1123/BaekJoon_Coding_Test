package Silver.S3.BOJ2075;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// N번째 큰 수
public class Main {
    static int N;
    static int[][] table;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        table = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
                insert(table[i][j]);
            }
        }
        // =======================================
        for(int i=0; i<N-1; i++){
            poll();
        }
        bw.write(peek() + "\n");
        bw.flush();
    }

    public static int peek(){
        return list.get(0);
    }

    public static void poll(){
        int index = 0;
        change(index, list.size()-1);
        list.remove(list.size()-1);
        while(true){
            int leftChildIndex = index*2 + 1;
            int rightChildIndex = index*2 + 2;
            if (leftChildIndex >= list.size()) {
                return;
            } else if(rightChildIndex >= list.size()){
                if(list.get(index) < list.get(leftChildIndex)){
                    change(index, leftChildIndex);
                    index = leftChildIndex;
                } else {
                    return;
                }
            } else {
                if(list.get(leftChildIndex) >= list.get(rightChildIndex)){
                    if(list.get(index) < list.get(leftChildIndex)){
                        change(index, leftChildIndex);
                        index = leftChildIndex;
                    } else {
                        return;
                    }
                } else {
                    if(list.get(index) < list.get(rightChildIndex)){
                        change(index, rightChildIndex);
                        index = rightChildIndex;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static void insert(int num){
        list.add(num);
        int index = list.size() - 1;
        while(index > 0){
            int parentIndex = (index-1)/2;
            if (list.get(parentIndex) < list.get(index)) {
                change(index, parentIndex);
                index = parentIndex;
            } else {
                return;
            }
        }
    }

    public static void change(int a, int b){
        int temp = list.get(b);
        list.set(b, list.get(a));
        list.set(a, temp);
    }
}
