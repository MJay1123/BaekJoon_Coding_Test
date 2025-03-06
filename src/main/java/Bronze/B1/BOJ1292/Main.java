package Bronze.B1.BOJ1292;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 쉽게 푸는 문제
public class Main {
    static int left;
    static int right;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        left = Integer.parseInt(st.nextToken());
        right = Integer.parseInt(st.nextToken());
        numbers = new int[1001];
        int index = 1;
        int number = 1;
        while(true){
            if (index > 1000){
                break;
            }
            for(int i=1; i<=number; i++){
                numbers[index] = number;
                index++;
                if(index > 1000){
                    break;
                }
            }
            number++;
        }
        int sum = 0;
        for(int i=left; i<=right; i++){
            sum += numbers[i];
        }
        bw.write(sum + "\n");
        bw.flush();
    }
}
