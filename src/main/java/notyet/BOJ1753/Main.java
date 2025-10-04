package notyet.BOJ1753;

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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());   // 정점의 개수
        int E = Integer.parseInt(st.nextToken());   // 간선의 개수
        int K = Integer.parseInt(br.readLine());    // 시작점
//        List<HashMap<Integer, Integer>> distance = new ArrayList<>();
        List<List<Integer[]>> distance = new ArrayList<>();
        for(int i=0; i<=V; i++){
//            HashMap<Integer, Integer> hm = new HashMap<>();
//            distance.add(hm);
            List<Integer[]> list = new ArrayList<>();
            distance.add(list);
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
//            if (distance.get(u).containsKey(v)) {
//                if(distance.get(u).get(v) > w){
//                    distance.get(u).replace(v, w);
//                }
//            } else {
//                distance.get(u).put(v, w);
//            }
            Integer[] arr = new Integer[2];
            arr[0] = v;
            arr[1] = w;
            distance.get(u).add(arr);
        }
        int[] minimumDistance = new int[V+1];
        for(int i=1; i<=V; i++){
            minimumDistance[i] = 10000000;
        }
        boolean[] visited = new boolean[V+1];
        dijkstra(K, distance, minimumDistance, visited);
        for(int i=1; i<=V; i++){
            if(minimumDistance[i] == 10000000){
                bw.write("INF\n");
            } else {
                bw.write(minimumDistance[i] + "\n");
            }
        }
        bw.flush();
    }

    public static void dijkstra(int num, List<List<Integer[]>> distance, int[] minimumDistance, boolean[] visited){
        visited[num] = true;
        minimumDistance[num] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node node = new Node(num, 0);
        pq.offer(node);
        while(!pq.isEmpty()) {
            node = pq.poll();
            num = node.number;
//            HashMap<Integer, Integer> hm = distance.get(num);
            List<Integer[]> list = distance.get(num);
//            for(int i : hm.keySet()){
            for(int i=0; i<list.size(); i++){
//                if(!visited[i]){
//                    minimumDistance[i] = Math.min(minimumDistance[i], minimumDistance[num] + hm.get(i));
                int next = list.get(i)[0];
                int dist = list.get(i)[1];
                if(!visited[next]){
                    visited[next] = true;
                    if(minimumDistance[next] > minimumDistance[num] + dist){
                        minimumDistance[next] = minimumDistance[num] + dist;
                        node = new Node(next, minimumDistance[next]);
                        pq.offer(node);
                    }
                }
            }
        }
    }
}
