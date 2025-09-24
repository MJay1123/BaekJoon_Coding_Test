package Gold.G5.BOJ2565;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] connected = new int[501];
        int maxA = 0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connected[a] = b;
            maxA = Math.max(maxA, a);
        }
        int[] count = new int[501];
        for(int i=1; i<=maxA; i++){
            if(connected[i] != 0){
                count[i] = 1;
                for(int j=1; j<i; j++){
                    if(connected[j] != 0){
                        if(connected[j] < connected[i]){
                            count[i] = Math.max(count[i], count[j] + 1);
                        }
                    }
                }
            }
        }
        int max = 0;
        for(int i=1; i<=500; i++){
            max = Math.max(max, count[i]);
        }
        bw.write(n - max + "\n");
        bw.flush();
    }
}
