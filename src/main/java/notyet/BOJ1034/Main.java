package notyet.BOJ1034;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 램프
public class Main {
    static int N;               // 행
    static int M;               // 열
    static int K;               // 스위치 누르기
    static int[][] array;       // 최초 배열
    static int[][] map;         // 복제 배열
    static boolean[] visited;   // 누르는 스위치
    static int max = 0;         // 최댓값 반환
    static int[] onLamp;        // 행마다 켜진 램프의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(str[j]);
            }
        }
        K = Integer.parseInt(br.readLine());

        if(K > M){
            if(K%2 == 0){
                K = M - M%2;
            } else {
                K = M - (M+1)%2;
            }
        }
//        System.out.println("K = " + K);
        for(int i=K%2; i<=K; i+=2){
            visited = new boolean[M];
            combination(0,0, i);
        }
        bw.write(max + "\n");
        bw.flush();
    }

    public static void combination(int index, int depth, int count){
        if(depth == count){
            map = copyMap();
            for(int i=0; i<M; i++){
                if(visited[i]){
                    pushSwitch(i);
                }
            }
            max = Math.max(max, checkMap());
            return;
        }
        if(index >= M){
            return;
        }
        visited[index] = true;
        combination(index+1, depth+1, count);
        visited[index] = false;
        combination(index+1, depth, count);
    }

    public static void pushSwitch(int num) {
        for (int i = 0; i < N; i++) {
            map[i][num] = 1 - map[i][num];
            onLamp[i] += (map[i][num] == 1) ? 1 : -1;
        }
    }

    public static int[][] copyMap(){
        int[][] newMap = new int[N][M];
        onLamp = new int[N];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                newMap[i][j] = array[i][j];
                onLamp[i] += newMap[i][j];
            }
        }
        return newMap;
    }

    public static int checkMap() {
        int count = 0;
//        System.out.println("맵을 확인합니다.");
        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
            if(onLamp[i] == M){
                count++;
            }
        }
        return count;
    }
}
