package Silver.S4.BOJ2485;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];
        trees[0] = Integer.parseInt(br.readLine());
        HashSet<Integer> distanceHashSet = new HashSet<>();
        int minDistance = 1000000000;
        for(int i=1; i<N; i++){
            trees[i] = Integer.parseInt(br.readLine());
            int dist = trees[i] - trees[i-1];
            distanceHashSet.add(dist);
            minDistance = Math.min(minDistance, dist);
        }
        int interval = 1;
        for(int i=1; i<=minDistance; i++){
            boolean bl = true;
            for(int dist : distanceHashSet){
                if(dist % i != 0){
                    bl = false;
                    break;
                }
            }
            if(bl){
                interval = i;
            }
        }
        int location = trees[0];
        int index = 1;
        while(index < N){
            location += interval;
            if(location == trees[index]){
                index++;
            } else {
                answer++;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
