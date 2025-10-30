package Silver.S2.BOJ6603;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N == 0){
                break;
            }
            int[] numbers = new int[N];
            for(int i=0; i<N; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            boolean[] visited = new boolean[N];
            combination(numbers, visited, 0, 0);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static void combination(int[] numbers, boolean[] visited, int depth, int index){
        if(depth == 6){
            for(int i=0; i<visited.length; i++){
                if(visited[i]){
                    sb.append(numbers[i] + " ");
                }
            }
            sb.append("\n");
            return;
        }
        if(index == numbers.length){
            return;
        }
        visited[index] = true;
        combination(numbers, visited, depth+1, index+1);
        visited[index] = false;
        combination(numbers, visited, depth, index+1);
    }
}
