package Gold.G4.BOJ1976;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] connection = new int[N+1][N+1];
        // 유니온-파인드 방식 사용
        arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = -1;
        }
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                connection[i][j] = Integer.parseInt(st.nextToken());
                if(connection[i][j] == 1){
                    union(i, j);
                }
            }
        }
        boolean answer = true;
        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        for(int i=1; i<M; i++){
            int next = Integer.parseInt(st.nextToken());
            if(findRoot(prev) != findRoot(next)){
                answer = false;
                break;
            }
            prev = next;
        }
        bw.write(answer ? "YES" : "NO");
        bw.flush();
    }
    public static void union(int num1, int num2){
        int root1 = findRoot(num1);
        int root2 = findRoot(num2);
        if(root1 == root2){
            return;
        }
        if(arr[root1] > arr[root2]){
            arr[root1] = root2;
            arr[root2]--;
        } else {
            arr[root2] = root1;
            arr[root1]--;
        }
    }

    public static int findRoot(int num){
        while(true) {
            if (arr[num] < 0) {
                break;
            }
            num = arr[num];
        }
        return num;
    }
}
