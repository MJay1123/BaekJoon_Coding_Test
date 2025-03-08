package Silver.S3.BOJ1485;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 정사각형
public class Main {
    static int xa, xb, xc, xd, ya, yb, yc, yd;
    static Location[] points = new Location[4];
    static int T;       // 테스트 케이스 개수
    static int[][] combination = {{0,1},{0,2},{0,3},{1,2},{1,3},{2,3}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            for(int j=0; j<4; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[j] = new Location(x, y);
            }
            double[] distances = new double[6];
            double min = Double.MAX_VALUE;
            double max = 0.0;
            for(int c=0; c<6; c++){
                Location point1 = points[combination[c][0]];
                Location point2 = points[combination[c][1]];
                double distance = Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
                distances[c] = distance;
                min = Math.min(min, distance);
                max = Math.max(max, distance);
            }
            int minCount = 0, maxCount = 0;
            for(int j=0; j<6; j++){
                if(distances[j] == min){
                    minCount++;
                } else if(distances[j] == max){
                    maxCount++;
                }
            }
            if(minCount == 4 && maxCount == 2){
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
            bw.flush();
        }
    }

    static class Location{
        int x, y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
