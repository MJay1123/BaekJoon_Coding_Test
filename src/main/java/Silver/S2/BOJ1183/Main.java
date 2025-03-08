package Silver.S2.BOJ1183;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 약속
public class Main {
    static int N;
    static int minDifference;
    static int[] differences;
    static int minDifferenceSum = Integer.MAX_VALUE;
    static int differenceSum;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        differences = new int[N];
        minDifference = Integer.MAX_VALUE;

        differenceSum = 0;

        if(N % 2 == 1){
            bw.write(1 + "\n");
        } else {
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int difference = a-b;
                differences[i] = difference;
                minDifference = Math.min(minDifference, difference);
            }

            for(int i=0; i<N; i++){
                differences[i] -= minDifference;
                differenceSum += differences[i];
            }
            Arrays.sort(differences);

            if(differences[N/2 - 1] == differences[N/2]){
                bw.write(1 + "\n");
            } else {
                bw.write(differences[N/2] - differences[N/2 - 1] + 1 + "\n");
            }
        }
        bw.flush();
    }
}
