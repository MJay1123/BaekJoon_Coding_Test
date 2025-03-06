package Silver.S2.BOJ1012;
// 유기농 배추
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 갯수
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());   // 배추밭 가로 길이
            int N = Integer.parseInt(st.nextToken());   // 배추밭 세로 길이
            int K = Integer.parseInt(st.nextToken());   // 배추가 심어진 갯수

            int[][] arr = new int[M][N];
            String[] stringArray = new String[K];
            boolean[] booleanArray = new boolean[K];
            for(int k=0; k<K; k++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                stringArray[k] = x + " " + y;
                arr[x][y] = 1;
            }

            int count = 0;
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][j] == 1){
                        count++;
                        dfs(i, j, arr);
                    }
                }
            }
            System.out.println(count);

        }
    }

    public static void dfs(int x, int y, int[][] arr) {
        arr[x][y] = 0;

        if (x + 1 < arr.length) {
            if (arr[x + 1][y] == 1) {
                dfs(x + 1, y, arr);
            }
        }
        if (x - 1 >= 0) {
            if (arr[x - 1][y] == 1) {
                dfs(x - 1, y, arr);
            }
        }
        if (y + 1 < arr[0].length) {
            if (arr[x][y + 1] == 1) {
                dfs(x, y + 1, arr);
            }
        }
        if (y - 1 >= 0) {
            if (arr[x][y - 1] == 1) {
                dfs(x, y - 1, arr);
            }
        }
    }
}
