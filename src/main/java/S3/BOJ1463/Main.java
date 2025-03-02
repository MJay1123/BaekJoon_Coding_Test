package S3.BOJ1463;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// 1로 만들기
public class Main {
    static int N;
    static int[] time;
    static boolean[] visited;
    static int answer = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        time = new int[N+1];
        visited = new boolean[N+1];
        bfs(1);
        answer = time[N];

        bw.write(answer + "\n");
        bw.flush();
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            int next = now*3;
            if(checkRange(next) && !visited[next]){
                queue.add(next);
                visited[next] = true;
                time[next] = time[now] + 1;
            }
            next = now*2;
            if(checkRange(next) && !visited[next]){
                queue.add(next);
                visited[next] = true;
                time[next] = time[now] + 1;
            }
            next = now+1;
            if(checkRange(next) && !visited[next]){
                queue.add(next);
                visited[next] = true;
                time[next] = time[now] + 1;
            }
        }
    }

    public static boolean checkRange(int num){
        return(num >= 0 && num <= N);
    }
}