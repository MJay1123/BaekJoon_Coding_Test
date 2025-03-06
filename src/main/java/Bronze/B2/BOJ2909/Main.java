package Bronze.B2.BOJ2909;
// 캔디 구매
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // (0 ≤ C ≤ 1,000,000,000, 0 ≤ K ≤ 9)

        int money = (int) Math.pow(10,  K);
        double a = 1.0 * C / money;
        System.out.println(money * Math.round(a));

    }
}
