package S2.BOJ2644;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// 촌수계산
public class DFS {

    static int n;                           // 사람의 수
    static int person1;                     // 계산 대상1
    static int person2;                     // 계산 대상2
    static int m;                           // 관계의 개수
    static boolean[][] connection;          // 부모자식 연결 관계도
    static boolean[] visited;               // 방문 배열
    static int count;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 주어진 두 사람의 촌수를 계산하는 프로그램을 작성
        // 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다. 이때에는 -1을 출력

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        person1 = Integer.parseInt(st.nextToken());
        person2 = Integer.parseInt(st.nextToken());
        connection = new boolean[n+1][n+1];
        m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connection[a][b] = connection[b][a] = true;
        }
        visited = new boolean[n+1];
        count = 0;
        dfs(person1);

        System.out.println(answer);
    }

    public static void dfs(int num){
        visited[num] = true;
        if(num == person2){
            answer = count;
        }
        for(int i=1; i<=n; i++){
            if(!visited[i] && connection[num][i]){
                count++;
                dfs(i);
                count--;
            }
        }
    }
}