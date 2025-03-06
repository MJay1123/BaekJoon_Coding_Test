package Gold.G5.BOJ1240;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
// 노드 사이의 거리
public class Main {

    static int N;
    static int M;
    static int[][] connection;
    static boolean[] visited;
    static int start;
    static int end;
    static int distance;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        connection = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            connection[a][b] = distance;
            connection[b][a] = distance;
        }

        // M개의 두 노드 쌍을 입력받을 때 두 노드 사이의 거리를 출력하라.
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());       // 시작점
            end = Integer.parseInt(st.nextToken());         // 도착점
            result = 0;                                     // 최종 거리 반환
            distance = 0;                                   // 중간 거리 계산
            visited = new boolean[N+1];                     // 반환 여부 배열

            dfs(start);
            bw.write(result + "\n");
            bw.flush();
        }
    }

    public static void dfs(int num){
        visited[num] = true;
        if(result > 0){                                     // 거리 측정 이후엔 전부 연산 X
            return;
        }

        if(num == end){
            result = distance;                              // 도착점까지의 거리 반환
            return;
        }
        for(int i=0; i<visited.length; i++){
            if(!visited[i] && connection[num][i] != 0){
                distance += connection[num][i];             // 다음 지점으로 넘어가면서 거리 추가
                dfs(i);
                distance -= connection[num][i];             // 이전 지점으로 돌아오면서 거리 다시 빼기
            }
        }
    }
}
