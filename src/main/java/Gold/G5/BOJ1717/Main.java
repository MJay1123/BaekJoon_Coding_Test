package Gold.G5.BOJ1717;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = -1;
        }
        for(int input=0; input<m; input++){
            st = new StringTokenizer(br.readLine());
            int calc = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(calc == 0){
                combine(num1, num2);
            } else if(calc == 1){
                bw.write(check(num1, num2) ? "YES\n" : "NO\n");
            }
        }
        bw.flush();
    }
    public static int findRoot(int num){
        while(true){
            if(arr[num] < 0){
                return num;
            }
            num = arr[num];
        }
    }
    public static void combine(int num1, int num2){
        int root1 = findRoot(num1);
        int root2 = findRoot(num2);
        if(root1 == root2){
            return;
        }
        int parent;
        int child;
        if(arr[root1] > arr[root2]){
            parent = root2;
            child = root1;
        } else {
            parent = root1;
            child = root2;
        }
        arr[parent]--;
        arr[child] = parent;
    }
    public static boolean check(int num1, int num2){
        int root1 = findRoot(num1);
        int root2 = findRoot(num2);
        return root1 == root2;
    }
}
