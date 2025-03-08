package Gold.G5.BOJ14503;

import java.io.*;
import java.util.StringTokenizer;

// 로봇 청소기
public class Main {
    static int N;                   // 방의 세로 길이
    static int M;                   // 방의 가로 길이
    static int startX;
    static int startY;
    static int direction;           // 0 : 북쪽 / 1 : 동쪽 / 2 : 남족 / 3 : 서쪽
    static int[][] room;            // 방
    static boolean[][] visited;     // 방문 배열
    static int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];

        // 0 : 청소되지 않은 칸 / 1 : 벽이 있는 칸

        int x = startX;
        int y = startY;
        while(true){
            if(!visited[x][y]){
                visited[x][y] = true;
                count++;
            }
            int nx, ny;
            if(checkAround(x, y)){                  // 90도 회전 후 전진
                turn();
                nx = x + move[direction][0];
                ny = y + move[direction][1];
                if(checkRange(nx,ny) && room[nx][ny] == 0 && !visited[nx][ny]){
                    x = nx;
                    y = ny;
                }
            } else {                                // 후진
                nx = x - move[direction][0];
                ny = y - move[direction][1];
                if(checkRange(nx, ny) && room[nx][ny] == 0){
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
            }
        }
        bw.write(count + "\n");
        bw.flush();
    }

    public static boolean checkAround(int x, int y){            // 주위 확인
        boolean check = false;
        for(int i=0; i<4; i++){
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if(checkRange(nx, ny) && room[nx][ny] == 0 && !visited[nx][ny]){
                check = true;
            }
        }
        return check;
    }

    public static void turn(){                                  // 반시계방향 90도 회전
        direction = (direction + 3) % 4;
    }

    public static boolean checkRange(int x, int y){
        return(x >= 0 && x < N && y >= 0 && y < M);
    }
}
