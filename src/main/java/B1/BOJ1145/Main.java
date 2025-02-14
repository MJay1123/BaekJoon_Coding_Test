package B1.BOJ1145;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 적어도 대부분의 배수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for(int i=0; i<5; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // 다섯 개의 자연수가 있다. 이 수의 적어도 대부분의 배수는 위의 수 중 적어도 세 개로 나누어 지는 가장 작은 자연수이다.
        int number = 1;
        while(true){
            int count = 0;
            for(int i=0; i<5; i++){
                if (number % arr[i] == 0) {
                    count++;
                }
                if(count == 3){
                    bw.write(number + "\n");
                    bw.flush();
                    return;
                }
            }
            number++;
        }
    }
}
