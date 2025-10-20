package Gold.G4.BOJ1956;

import java.io.*;
import java.util.*;

public class Main {
    static int[] minimumDistance;
    static int[] minimumCycle;
    static boolean[] visited;
    static List<Integer[]>[] distanceList;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        distanceList = new ArrayList[V+1];
        for(int i=1; i<=V; i++){
            distanceList[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            distanceList[start].add(new Integer[]{end, distance});
        }
        minimumDistance= new int[V+1];
        minimumCycle = new int[V+1];
        for(int i=1; i<=V; i++){
            minimumCycle[i] = Integer.MAX_VALUE;
        }
        for(int i=1; i<=V; i++){
            dijkstra(i);
            minimumCycle[i] = minimumDistance[i];
            if(minimumCycle[i] != Integer.MAX_VALUE) {
                answer = Math.min(answer, minimumCycle[i]);
            }
        }
        if(answer == Integer.MAX_VALUE){
            bw.write(-1 + "\n");
        } else {
            bw.write(answer + "\n");
        }
        bw.flush();
    }

    static class Village implements Comparable<Village> {
        int number;
        int distance;
        public Village(int number, int distance){
            this.number = number;
            this.distance = distance;
        }
        @Override
        public int compareTo(Village o){
            return this.distance - o.distance;
        }
    }

    public static void dijkstra(int number){
        for(int i=1; i<minimumDistance.length; i++){
            minimumDistance[i] = Integer.MAX_VALUE;
        }
        visited = new boolean[minimumDistance.length];
        PriorityQueue<Village> pq = new PriorityQueue<>();
        int start = number;
        List<Integer[]> list = distanceList[start];
        for(int i=0; i<list.size(); i++){
            int end = list.get(i)[0];
            int dist = list.get(i)[1];
            minimumDistance[end] = dist;
            pq.offer(new Village(end, minimumDistance[end]));
        }
        while(!pq.isEmpty()){
            Village village = pq.poll();
            start = village.number;
            if(!visited[start]){
                visited[start] = true;
                if(start == number){
                    return;
                }
                list = distanceList[start];
                for(int i=0; i<list.size(); i++){
                    int end = list.get(i)[0];
                    int dist = list.get(i)[1];
                    if(!visited[end]){
                        if(minimumDistance[end] > minimumDistance[start] + dist) {
                            minimumDistance[end] = minimumDistance[start] + dist;
                            pq.offer(new Village(end, minimumDistance[end]));
                        }
                    }
                }
            }
        }
    }
}
