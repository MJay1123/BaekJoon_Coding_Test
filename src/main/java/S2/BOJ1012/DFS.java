package S2.BOJ1012;

// 유기농 배추
import java.io.*;
import java.util.StringTokenizer;

public class DFS {

    static int T;           // T : 테스트 케이스 갯수
    static int M;           // M : 배추밭 가로 길이
    static int N;           // N : 배추밭 세로 길이
    static int K;           // K : 배추가 심어진 갯수
    static int[][] map;     // 배추밭 지도
    static boolean[][] visited;
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    static int count;       // 배추 그룹 카운트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for(int k=0; k<K; k++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());       // 배추의 x좌표
                int b = Integer.parseInt(st.nextToken());       // 배추의 y좌표
                map[b][a] = 1;                                  // 배추가 심어진 맵 생성
            }
            visited = new boolean[N][M];                        // 방문 확인용 배열
            count = 0;

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        count++;
                        dfs(i,j);
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if(checkRange(nx,ny) && map[nx][ny] == 1 && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
    }

    public static boolean checkRange(int x, int y){
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}