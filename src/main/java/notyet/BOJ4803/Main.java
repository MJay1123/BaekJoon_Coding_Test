package notyet.BOJ4803;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            int[] arr = new int[n + 1];
            for(int i=1; i<=n; i++){
                arr[i] = -1;
            }
            result = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                union(num1, num2, arr);
            }
            for(int i=1; i<=n; i++){
                if(arr[i] < 0){
                    result++;
                }
            }
            sb.append("Case " + (caseNum++) + " : ");
            if(result == 0){
                sb.append("No trees.\n");
            } else if(result == 1){
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of " + result + " trees.\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static void union(int num1, int num2, int[] arr){
        int root1 = findRoot(num1, arr);
        int root2 = findRoot(num2, arr);
        if(root1 == root2 && arr[root1] != 0){
            arr[root1] = 0;
            return;
        }
        if(arr[root1] == 0 || arr[root2] == 0){
            arr[root1] = 0;
            arr[root2] = 0;
            return;
        }
        if(arr[root1] <= arr[root2]){
            arr[root1]--;
            arr[root2] = root1;
        } else {
            arr[root2]--;
            arr[root1] = root2;
        }
    }
    public static int findRoot(int num, int[] arr){
        while(true){
            if(arr[num] < 0){
                break;
            }
            num = arr[num];
        }
        return num;
    }
}
