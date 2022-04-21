package Sort;

import java.util.Arrays;

class Sort {

    void bubbleSort(int[] arr){
        // (1, 2), (2, 3), (3, 4) 비교 후 swap
        // 1회전마다 가장 큰 원소가 제일 뒤로 가므로, 가장 끝 원소는 제외
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-i; j++) {
                if(arr[j-1] > arr[j]){
                    swap(j-1, j, arr);
                }
            }
        }
    }

    void selectionSort(int[] arr){
        int minIndex;
        for (int i = 0; i < arr.length-1; i++) {
            minIndex = i;
            // 최소값 찾기, 앞의 인덱스들은 이미 정해져있음.
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }
            // 최소값을 현재 위치와 바꾸기
            swap(minIndex, i, arr);
        }
    }

    void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int prev = i - 1;
            while ((prev >= 0) && (arr[prev] > tmp)){
                // 현재 값보다 prev에 있는 값이 더 크면 뒤로 한 칸씩 밀어줌.
                arr[prev+1] = arr[prev];
                prev--;
            }
            // 다음 위치에 tmp 저장
            arr[prev+1] = tmp;
        }
    }

    void quickSort(int[] arr, int left, int right){
        if(left >= right) return;

        int p = partition(arr, left, right);
        quickSort(arr, left, p-1);
        quickSort(arr, p+1, right);
    }

    private int partition(int[] arr, int left, int right) {
        // pivot 선택
        int pivot = arr[left];
        int l= left, r = right;

        while (l<r){
            // 오른쪽에서 왼쪽으로 가면서 pivot보다 작은 수 찾기
            while (pivot <arr[r]){
                r--;
            }
            // 왼쪽에서 오른쪽으로 가면서 pivot 보다 큰 수 찾기
            while (l < r && pivot >= arr[l]){
                l++;
            }
            // 두 수의 위치 바꾸기
            swap(r, l, arr);
        }
        // pivot과 위치 바꾸기
        arr[left] = arr[l];
        arr[l] = pivot;

        return l;
    }

    void mergeSort(int[] arr, int left, int right){
        if(left >= right) return;
        
        int mid = (left+right)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] L = Arrays.copyOfRange(arr, left, mid+1);
        int[] R = Arrays.copyOfRange(arr, mid+1, right+1);

        int i=0, j=0, k=left;
        int ll = L.length, rl = R.length;

        while (i<ll && j<rl){
            if(L[i] <= R[j]){
                arr[k] = L[i++];
            }else{
                arr[k] = R[j++];
            }
            k++;
        }

        // 나머지 원소들 정렬
        while (i<ll){
            arr[k++] = L[i++];
        }
        while (j<rl){
            arr[k++] = R[j++];
        }
    }

    int[] heapSort(int[] arr){
        return arr;
    }

    private void swap(int i1, int i2, int[] arr){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    private void print(int[] arr){
        for (int a: arr) {
            System.out.print(a+" ");
        }
        System.out.println();
    }
}

public class Main{
    public static void main(String[] args) {
        int[] arr = {10, 75, 25, 5, 20, 15, 60};

        Sort s = new Sort();

        s.mergeSort(arr, 0, arr.length-1);
        for (int a: arr){
            System.out.print(a+" ");
        }
    }
}
