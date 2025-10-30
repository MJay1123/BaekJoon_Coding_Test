package Silver.S2.BOJ2961;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long[][] taste;
    static long answer = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        taste = new long[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }
        boolean[] visited = new boolean[N];
        combination(visited, 0);
        bw.write(answer + "\n");
        bw.flush();
    }
    public static void combination(boolean[] visited, int index){
        if(index == visited.length){
            long sour = 1;
            long bitter = 0;
            for(int i=0; i<visited.length; i++){
                if(visited[i]){
                    sour *= taste[i][0];
                    bitter += taste[i][1];
                }
            }
            if(bitter == 0){
                return;
            }
            long difference = (sour >= bitter) ? sour-bitter : bitter-sour;
            answer = Math.min(answer, difference);
            return;
        }
        visited[index] = true;
        combination(visited, index+1);
        visited[index] = false;
        combination(visited, index+1);
    }
}
