package Bronze.B1.BOJ1357;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// 뒤집힌 덧셈
public class Main {
    static int X;
    static int Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        // Rev(Rev(X) + Rev(Y))
        int x = reverse(X);
        int y = reverse(Y);
        bw.write(reverse(x+y) + "\n");
        bw.flush();
    }

    public static int reverse(int num){
        List<Integer> list = new ArrayList<>();
        while(num > 0){
            int digit = num % 10;
            list.add(digit);
            num /= 10;
        }
        int result = 0;
        for(int i=0; i<list.size(); i++){
            result += Math.pow(10, list.size()-1-i) * list.get(i);
        }
        return result;
    }
}
