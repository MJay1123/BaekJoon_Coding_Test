package Gold.G4.BOJ1753;

import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int number;
        int distance;
        public Node(int number, int distance){
            this.number = number;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
    static List<HashMap<Integer, Integer>> distanceList = new ArrayList<>();
    static int[] minimumDistance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());   // 정점의 개수
        int E = Integer.parseInt(st.nextToken());   // 간선의 개수
        int K = Integer.parseInt(br.readLine());    // 시작점
        for(int i=0; i<=V; i++){
            distanceList.add(new HashMap<Integer, Integer>());
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(distanceList.get(u).containsKey(v)){
                distanceList.get(u).replace(v, Math.min(distanceList.get(u).get(v), w));
            } else {
                distanceList.get(u).put(v, w);
            }
        }
        minimumDistance = new int[V+1];
        for(int i=1; i<=V; i++){
            minimumDistance[i] = Integer.MAX_VALUE;
        }
        boolean[] visited = new boolean[V+1];
        dijkstra(K, visited);
        for(int i=1; i<=V; i++){
            if(minimumDistance[i] == Integer.MAX_VALUE){
                bw.write("INF\n");
            } else {
                bw.write(minimumDistance[i] + "\n");
            }
        }
        bw.flush();
    }

    public static void dijkstra(int num, boolean[] visited){
        visited[num] = true;
        minimumDistance[num] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node node = new Node(num, 0);
        pq.offer(node);
        while(!pq.isEmpty()) {
            node = pq.poll();
            num = node.number;
            HashMap<Integer, Integer> hm = distanceList.get(num);
            for(int i : hm.keySet()){
                int next = i;
                int dist = hm.get(i);
                if(minimumDistance[next] > minimumDistance[num] + dist){
                    minimumDistance[next] = minimumDistance[num] + dist;
                    node = new Node(next, minimumDistance[next]);
                    pq.offer(node);
                }
            }
        }
    }
}
