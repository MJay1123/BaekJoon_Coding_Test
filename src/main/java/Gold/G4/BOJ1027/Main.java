package Gold.G4.BOJ1027;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] buildings = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            buildings[i] = Long.parseLong(st.nextToken());
        }
        int[] count = new int[N];
        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){ // j    k   i
                boolean canSee = true;
                for(int k=j+1; k<i; k++){
                    if(buildings[k] * 1.0 >= (1.0 * buildings[i] * (k-j) + buildings[j] * (i-k)) / (i-j)){
                        canSee = false;
                        break;
                    }
                }
                if(canSee){
                    count[i]++;
                }
            }
            for(int j=i+1; j<N; j++){   // i    k   j
                boolean canSee = true;
                for(int k=i+1; k<j; k++){
                    if(buildings[k] * 1.0 >= (1.0 * buildings[j] * (k-i) + buildings[i] * (j-k)) / (j-i)){
                        canSee = false;
                        break;
                    }
                }
                if(canSee){
                    count[i]++;
                }
            }
            answer = Math.max(answer, count[i]);
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
