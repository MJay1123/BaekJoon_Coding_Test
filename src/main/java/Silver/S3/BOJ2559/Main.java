package Silver.S3.BOJ2559;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int answer = -100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int left = 0;
        int right = K;
        for(int i=left; i<right; i++){
            sum += numbers[i];
        }
        answer = Math.max(answer, sum);
        while(true){
            if(right == N){
                break;
            }
            sum -= numbers[left];
            sum += numbers[right];
            answer = Math.max(answer, sum);
            left++;
            right++;
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
