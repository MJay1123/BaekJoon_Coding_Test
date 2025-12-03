package Bronze.B2.BOJ2920;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[8];
        for(int i=0; i<8; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        if(numbers[0] > numbers[1]){
            boolean descending = true;
            for(int i=1; i<7; i++){
                if(numbers[i] < numbers[i+1]){
                    descending = false;
                    break;
                }
            }
            if(descending){
                bw.write("descending");
            } else {
                bw.write("mixed");
            }
        } else {
            boolean ascending = true;
            for(int i=1; i<7; i++){
                if(numbers[i] > numbers[i+1]){
                    ascending = false;
                    break;
                }
            }
            if(ascending){
                bw.write("ascending");
            } else {
                bw.write("mixed");
            }
        }
        bw.flush();
    }
}
