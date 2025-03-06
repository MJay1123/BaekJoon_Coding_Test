package Silver.S5.BOJ1010;
// 다리 놓기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int[][] arr = new int[T][2];
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            arr[t][0] = Integer.parseInt(st.nextToken());
            arr[t][1] = Integer.parseInt(st.nextToken());
        }

        for(int t=0; t<T; t++){

            int N = arr[t][0];
            int M = arr[t][1];
            double num = 1.0;
            for(int i=1; i<=N; i++){
                num = num * (M-i+1) / i;
            }
            int answer = (int)num;
            System.out.println(answer);
        }
    }
}
