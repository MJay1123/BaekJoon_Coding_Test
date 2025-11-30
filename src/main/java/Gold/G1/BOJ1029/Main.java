package Gold.G1.BOJ1029;

import java.io.*;

public class Main {
    static int answer = 0;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int[][] priceArray = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=N; j++){
                priceArray[i][j] = str.charAt(j-1) - '0';
            }
        }
        boolean[][][] dp = new boolean[1 << N][N+1][10];            // [state][currentOwner][price]의 형태
        dp[1][1][1] = true;                                         // state : 비트마스크로 표현(ex. 1100 -> 4,3번이 소유했음)
        DFS(1, 1, priceArray, dp, 0, 1);
        bw.write(answer + "\n");
        bw.flush();
    }
    public static void DFS(int current, int state, int[][] priceArray, boolean[][][] dp, int price, int people){
        answer = Math.max(answer, people);
        for(int next=1; next <= N; next++){
            if(next == current){
                continue;
            }
            int visited = state & (1 << (next-1));              // 다음 사람이 이미 방문한 상태인지 여부를 판단(AND 연산)
            if(visited > 0){
                continue;
            }
            int nextPrice = priceArray[current][next];
            if(nextPrice >= price){
                int nextState = state | (1 << (next-1));        // 다음 상태에 방문할 사람을 추가하는 로직(OR 연산)
                if(!dp[nextState][next][nextPrice]){
                    dp[nextState][next][nextPrice] = true;
                    DFS(next, nextState, priceArray, dp, nextPrice, people+1);
                }
            }
        }
    }
}
