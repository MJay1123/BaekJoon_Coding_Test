package Gold.G4.BOJ11054;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            numbers[i] = num;
        }
        int[][] length = new int[N][2];
        for(int i=0; i<N; i++){
            length[i][0] = 1;
            for(int j=0; j<i; j++){
                if(numbers[j] < numbers[i]){
                    length[i][0] = Math.max(length[i][0], length[j][0] + 1);
                }
            }
        }
        for(int i=N-1; i>=0; i--){
            length[i][1] = 1;
            for(int j=N-1; j>i; j--){
                if(numbers[j] < numbers[i]){
                    length[i][1] = Math.max(length[i][1], length[j][1] + 1);
                }
            }
        }
        int max = 0;
        for(int i=0; i<N; i++){
            max = Math.max(max, length[i][0] + length[i][1] - 1);
        }
        bw.write(max + "\n");
        bw.flush();
    }
}
