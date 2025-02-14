package S2.BOJ1182;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 부분 수열의 합
public class Main {
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 1<=N<=20
        int S = Integer.parseInt(st.nextToken());       // |S| <= 1,000,000

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        System.out.println("before : " + sum);
        boolean[] visited = new boolean[N];
        dfs(arr, visited, 0, sum, S);
        System.out.println("after : " + sum);
    }

    public static int dfs(int[] arr, boolean[] visited, int num, int sum, int S){
        visited[num] = true;
        sum += arr[num];
        if(sum != S){
            for(int i=0; i<arr.length; i++){
                if(!visited[i]){
                    sum = dfs(arr, visited, i, sum, S);
                }
            }
        }
        return sum;
    }
}
