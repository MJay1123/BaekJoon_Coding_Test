package B3.BOJ1247;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;               // 정수의 개수
    static List<Long> numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int t=0; t<3; t++){             // 테스트 케이스 3번
            N = Integer.parseInt(br.readLine());
            numbers = new ArrayList<>();
            for(int i=0; i<N; i++){
                long number = Long.parseLong(br.readLine());
                if(number != 0){
                    numbers.add(number);
                }
            }

            BigInteger sum = BigInteger.ZERO;
            for(long number : numbers){
                sum = sum.add(BigInteger.valueOf(number));
            }
            int result = sum.compareTo(BigInteger.ZERO);

            if(result > 0){
                bw.write("+" + "\n");
            } else if(result < 0){
                bw.write("-" + "\n");
            } else {
                bw.write(0 + "\n");
            }
        }
        bw.flush();
    }
}
