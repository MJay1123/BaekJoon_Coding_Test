package Silver.S2.BOJ1138;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 한 줄로 서기
public class Main {
    static int N;               // 사람의 수
    static int[] tallCount;      // 자신의 왼쪽에 자신보다 큰 사람이 있는 수
    static int[] line;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tallCount = new int[N+1];
        line = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            tallCount[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            int tallerPeople = tallCount[i];
            int index = 1;
            int count = 0;
            while(true){
                if(count == tallerPeople && !visited[index]){
                    break;
                }
                if(!visited[index]){
                    index++;
                    count++;
                } else {
                    index++;
                }
            }
            line[index] = i;
            visited[index] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(line[i]).append(" ");
        }
        bw.write(sb.toString().trim());
        bw.flush();
    }
}
