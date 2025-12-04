package Gold.G4.BOJ9019;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String answer = "";
    static String[] commands = {"D", "S", "L", "R"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int testCase=0; testCase<T; testCase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int[] beforeArray = numToArray(before);
            int after = Integer.parseInt(st.nextToken());
            boolean[][][][] visited = new boolean[10][10][10][10];
            BFS(beforeArray, visited, after);
            bw.write(answer + "\n");
        }
        bw.flush();
    }
    public static void BFS(int[] arr, boolean[][][][] visited, int after){
        Queue<int[]> arrayQueue = new LinkedList<>();
        Queue<String> commandQueue = new LinkedList<>();
        arrayQueue.offer(arr);
        commandQueue.offer("");
        visited[arr[0]][arr[1]][arr[2]][arr[3]] = true;
        while(!arrayQueue.isEmpty() && !commandQueue.isEmpty()){
            arr = arrayQueue.poll();
            String command = commandQueue.poll();
            if(arrayToNumber(arr) == after){
                answer = command;
                return;
            }
            for(int i=0; i<4; i++){
                int[] newArr = calculate(arr, i);
                if(!visited[newArr[0]][newArr[1]][newArr[2]][newArr[3]]) {
                    arrayQueue.offer(newArr);
                    commandQueue.offer(command + commands[i]);
                    visited[newArr[0]][newArr[1]][newArr[2]][newArr[3]] = true;
                }
            }
        }
    }
    public static int[] calculate(int[] array, int index){
        int[] arr = new int[4];
        for(int i=0; i<4; i++){
            arr[i] = array[i];
        }
        switch(index){
            case 0:
                D(arr);
                break;
            case 1:
                S(arr);
                break;
            case 2:
                L(arr);
                break;
            case 3:
                R(arr);
                break;
        }
        return arr;
    }
    public static void D(int[] arr){
        for(int i=0; i<4; i++){
            arr[i] *= 2;
            if(arr[i] >= 10){
                if(i == 0){
                    arr[i] %= 10;
                } else {
                    arr[i] -= 10;
                    arr[i-1]++;
                }
            }
        }
    }
    public static void S(int[] arr){
        arr[3]--;
        if(arr[3] < 0){
            arr[3] += 10;
            arr[2]--;
            if(arr[2] < 0){
                arr[2] += 10;
                arr[1]--;
                if(arr[1] < 0){
                    arr[1] += 10;
                    arr[0]--;
                    if(arr[0] < 0){
                        arr[0] += 10;
                    }
                }
            }
        }
    }
    public static void L(int[] arr){
        int temp = arr[0];
        for(int i=0; i<3; i++){
            arr[i] = arr[i+1];
        }
        arr[3] = temp;
    }
    public static void R(int[] arr){
        int temp = arr[3];
        for(int i=3; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }

    public static int[] numToArray(int num){
        int[] array = new int[4];
        int index = 3;
        while(num > 0){
            int digit = num % 10;
            array[index] = digit;
            index--;
            num /= 10;
        }
        return array;
    }

    public static int arrayToNumber(int[] arr){
        int number = ((arr[0] * 10 + arr[1]) * 10 + arr[2]) * 10 + arr[3];
        return number;
    }
}
