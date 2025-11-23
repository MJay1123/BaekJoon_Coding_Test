package Gold.G5.BOJ1916;

import java.io.*;
import java.util.*;

public class Main {
    static int N;       // 도시 수
    static int M;       // 버스 수
    static class City implements Comparable<City> {
        int number;
        int cost;
        public City(int number, int cost){
            this.number = number;
            this.cost = cost;
        }
        @Override
        public int compareTo(City c){
            return this.cost - c.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        List<HashMap<Integer, Integer>> costMapList = new ArrayList<>();
        for(int i=0; i<=N; i++){
            HashMap<Integer, Integer> hm = new HashMap<>();
            costMapList.add(hm);
        }
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int city1 = Integer.parseInt(st.nextToken());
            int city2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            HashMap<Integer, Integer> hm = costMapList.get(city1);
            if(hm.containsKey(city2)){
                hm.put(city2, Math.min(cost, hm.get(city2)));
            } else {
                hm.put(city2, cost);
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] cityCost = new int[N+1];
        for(int i=1; i<=N; i++){
            cityCost[i] = 1000 * 100000;
        }
        boolean[] visited = new boolean[N+1];
        PriorityQueue<City> pq = new PriorityQueue<>();
        cityCost[start] = 0;
        pq.offer(new City(start, 0));
        while(!pq.isEmpty()){
            City city = pq.poll();
            int number = city.number;
            if(!visited[number]){
                visited[number] = true;
                HashMap<Integer, Integer> costMap = costMapList.get(number);
                for(int i : costMap.keySet()){
                    if(!visited[i]) {
                        if(cityCost[i] > cityCost[number] + costMap.get(i)) {
                            cityCost[i] = cityCost[number] + costMap.get(i);
                            pq.offer(new City(i, cityCost[i]));
                        }
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(cityCost));
        bw.write(cityCost[end] + "\n");
        bw.flush();
    }
}
