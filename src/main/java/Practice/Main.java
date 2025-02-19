package Practice;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        boolean[] visited = new boolean[10];
        List<int[]> list = new ArrayList<>();
        combination(arr, visited, 0, 0, 3, list);
    }

    public static void combination(int[] arr, boolean[] visited, int index, int depth, int count, List<int[]> list){
        if(depth == count){
            int[] array = new int[count];
            int j = 0;
            for(int i=0; i<arr.length; i++){
                if(visited[i]){
                    array[j++] = arr[i];
                }
            }
            list.add(array);
            return;
        }
        if(index == arr.length){
            return;
        }
        visited[index] = true;
        combination(arr, visited, index+1, depth+1, count, list);
        visited[index] = false;
        combination(arr, visited, index+1, depth, count, list);
    }
}
