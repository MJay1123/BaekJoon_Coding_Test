package Silver.S1.BOJ9934;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[(int)Math.pow(2,K) - 1];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] visited = new boolean[arr.length];
        int center = arr.length / 2;
        while(center > 0) {
            for (int i = center; i <= arr.length; i += center) {
                if (!visited[i - 1]) {
                    bw.write(arr[i - 1] + " ");
                }
            }
            bw.write("\n");
            center /= 2;
        }
        bw.flush();
    }
}
