package S2.BOJ18352;

import java.io.*;
import java.util.*;

// 특정 거리의 도시 찾기
public class Main {
    static int N;       // 도시의 수
    static int M;       // 단방향 도로의 수
    static int K;       // 목표 거리
    static int X;       // 출발 도시
    static List<Integer>[] connection;      // 각 도시 별로 연결된 도시들을 담은 리스트
    static boolean[] visited;
    static int[] distance;
    static PriorityQueue<Integer> list = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        connection = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            connection[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connection[a].add(b);                       // a에서 b로 가는 도로가 있음(반대방향은 X)
        }
        bfs(X);
        if(list.size() == 0){
            bw.write(-1 + "\n");
        } else {
            while(!list.isEmpty()){
                bw.write(list.poll() + "\n");
            }
        }
        bw.flush();
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int currentLocation = queue.poll();
            if(distance[currentLocation] > K){
                return;
            }
            for(int i : connection[currentLocation]){
                if (!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    distance[i] = distance[currentLocation] + 1;
                    if(distance[i] == K){
                        list.add(i);
                    }
                }
            }
        }
    }
}
