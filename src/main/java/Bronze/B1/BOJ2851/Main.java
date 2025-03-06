package Bronze.B1.BOJ2851;

import java.io.*;
import java.util.StringTokenizer;

// 슈퍼 마리오
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] mushroom = new int[10];
        for(int i=0; i<10; i++){
            mushroom[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        int index = 0;
        int sum = 0;
        for(int i=0; i<10; i++){
            sum += mushroom[i];
            if(sum >= 100){
                index = i;
                break;
            }
        }

        if(sum >= 100 && index > 0){
            int difference1 = sum - 100;
            int difference2 = 100 - (sum - mushroom[index]);
            answer = difference1 <= difference2 ? sum : sum - mushroom[index];
        } else {
            answer = sum;
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
