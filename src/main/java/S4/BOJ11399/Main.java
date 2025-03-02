package S4.BOJ11399;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// ATM
public class Main {
    static int N;
    static int[] people;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        people = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(people);
        int time = 0;
        int count = N;
        for(int i=0; i<N; i++){
            time += people[i] * count;
            count--;
        }
        bw.write(time + "\n");
        bw.flush();
    }
}
