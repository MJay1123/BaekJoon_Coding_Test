package Bronze.B1.BOJ1526;
// 가장 큰 금민수
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=N; i>=1; i--){
            int number = i;
            while(number != 0){
                int digit = number % 10;
                if(digit != 4 && digit != 7){
                    break;
                }
                number /= 10;
            }
            if(number == 0){
                bw.write(i + "" + "\n");
                bw.flush();
                return;
            }
        }
    }
}
