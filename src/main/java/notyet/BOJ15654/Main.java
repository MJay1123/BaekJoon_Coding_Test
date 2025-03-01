package notyet.BOJ15654;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;               // 자연수
    static int M;               // M개 고르기
    static int[] numbers;       // 숫자
    static boolean[] visited;   // 고른 숫자
    static List<String> str;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        visited = new boolean[N];
        str = new ArrayList<String>();
        combination(0,0);
        bw.flush();
    }

    public static void combination(int index, int depth) throws IOException {
        if(depth == M){
            int[] newNumbers = new int[M];
            boolean[] newVisited = new boolean[M];
            int j=0;
            for(int i=0; i<N; i++){
                if(visited[i]){
                    newNumbers[j] = numbers[i];
                    j++;
                }
            }
            print(newNumbers, newVisited, 0);
            return;
        }
        if(index == N){
            return;
        }
        visited[index] = true;
        combination(index+1, depth+1);

        visited[index] = false;
        combination(index+1, depth);
    }

    public static void print(int[] nums, boolean[] vis, int depth) throws IOException {
        if(depth == M){
            bw.write("\n");
            return;
        }
        for(int i=0; i<M; i++){
            if(!vis[i]){
                bw.write(nums[i] + " ");
                vis[i] = true;
                print(nums, vis, depth+1);
                vis[i] = false;
            }
        }
    }
}
