package Bronze.B2.BOJ2702;
// 초6 수학
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());        // T = 테스트 케이스 갯수

        int[][] arr = new int[T][2];
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 각 테스트 케이스에 대해 최소공배수와 최대공약수를 차례대로 출력한다.
        for(int i=0; i<T; i++){
            int maxCommonDivided = getMaxCommonNumber(arr[i][0], arr[i][1]);
            int minCommonPow = arr[i][0] * arr[i][1] / maxCommonDivided;
            StringBuilder sb = new StringBuilder();
            sb.append(minCommonPow);
            sb.append(" ");
            sb.append(maxCommonDivided);
            bw.write(sb.toString() + "\n");
            bw.flush();
        }
    }

    public static int getMaxCommonNumber(int a, int b){
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        while(max % min != 0){
            int temp = max % min;
            max = min;
            min = temp;
        }
        return min;
    }
}
