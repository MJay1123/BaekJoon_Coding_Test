package Bronze.B2.BOJ1977;

import java.io.*;
import java.util.StringTokenizer;
// 완전제곱수
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int min = 0;
        int sum = 0;
        for(int i=m; i<=n; i++){
            if(Math.sqrt(i) % 1 == 0){
                if(min == 0){
                    min = i;
                }
                sum += i;
            }
        }
        if(min == 0 && sum == 0){
            bw.write(-1 + "\n");
        } else {
            bw.write(sum + "\n");
            bw.write(min + "\n");
        }
        bw.flush();
    }
}
