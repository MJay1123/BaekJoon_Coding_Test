package S2.BOJ2644;
// 촌수 계산
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());                // n : 전체 사람의 수
        st = new StringTokenizer(br.readLine());
        int person1 = Integer.parseInt(st.nextToken());
        int person2 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());                // m : 관계의 수
        int[][] connection = new int[m][2];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            connection[i][0] = Integer.parseInt(st.nextToken());
            connection[i][1] = Integer.parseInt(st.nextToken());
        }
        boolean[][] connectionMap = new boolean[n+1][n+1];
        for(int i=0; i<m; i++){
            int a = connection[i][0];
            int b = connection[i][1];
            connectionMap[a][b] = true;
            connectionMap[b][a] = true;
        }
        boolean[] visited = new boolean[n+1];
        Stack<Integer> stack = new Stack<>();
        dfs(person1, connectionMap, visited, stack, person2);

        bw.write((stack.size()-1) + "\n");
        bw.flush();
    }

    public static void dfs(int start, boolean[][] connectionMap, boolean[] visited, Stack<Integer> stack, int goal){
        visited[start] = true;
        stack.push(start);
        for(int i=0; i<visited.length; i++){
            if(!visited[i] && connectionMap[start][i] && stack.peek() != goal){
                dfs(i, connectionMap, visited, stack, goal);
            }
        }
        if(stack.peek() != goal){
            stack.pop();
        }
    }
}
