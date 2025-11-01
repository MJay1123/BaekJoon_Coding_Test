package Silver.S3.BOJ10655;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] checkPoints = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            checkPoints[i][0] = Integer.parseInt(st.nextToken());
            checkPoints[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] distance = new int[N];
        for(int i=1; i<N; i++){
            distance[i] = getDistance(checkPoints[i], checkPoints[i-1]);
            answer += distance[i];
        }
        int[] passDistance = new int[N];
        for(int i=1; i<N-2; i++){
            passDistance[i] = getDistance(checkPoints[i+1], checkPoints[i-1]);
        }
        int[] difference = new int[N];
        int maxDifference = 0;
        for(int i=1; i<N-2; i++) {
            difference[i] = distance[i] + distance[i + 1] - passDistance[i];
            if (difference[i] > maxDifference) {
                maxDifference = difference[i];
            }
        }
        answer -= maxDifference;
        bw.write(answer + "\n");
        bw.flush();
    }
    public static int getDistance(int[] location1, int[] location2){
        int x1 = location1[0];
        int y1 = location1[1];
        int x2 = location2[0];
        int y2 = location2[1];
        return Math.max(x1, x2) - Math.min(x1, x2) + Math.max(y1, y2) - Math.min(y1, y2);
    }
}
