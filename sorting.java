import java.util.ArrayList;

public class sorting {

    static void selection(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n - 2; i++) {
            int mixIdx = i;
            for (int j = i+1; j <= n - 1; j++) {
                if (arr[j] < arr[mixIdx])
                    mixIdx = j;
            }
            // swap arr[minIdx], arr[i]
            int temp = arr[i];
            arr[i] = arr[mixIdx];
            arr[mixIdx] = temp;
            for (int k : arr)
                System.out.print(k + " ");
            System.out.println();

        }
    }

    static void bubbleItr(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n - 2; i++) {
            for (int j = 0; j <= n - i - 2; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            for (int k : arr)
                System.out.print(k + " ");
            System.out.println();
        }
    }

    static void bubbleRec(int[] arr, int n) {

        if (n == 1)
            return;

        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        bubbleRec(arr, n - 1);
    }

    static void insertionItr(int[] arr) {
        int n = arr.length;
        
        for(int i=1;i<=n-1;i++){
            int key=arr[i];
            int j=i-1;

            while (j>=0 && arr[j]>key) {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;

            System.out.print(i+"th iteration : ");
            for (int num : arr)
                System.out.print(num + " ");
            System.out.println();
        }
    }

    static void mergeFnc(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // copy back into arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    static void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        mergeFnc(arr, low, mid, high);
    }

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivotIdx = getPivot(arr, low, high);
            quickSort(arr, low, pivotIdx - 1);
            quickSort(arr, pivotIdx + 1, high);
        }
    }

    static int getPivot(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low, j = high;

        while (i < j) {
            while (arr[i] >= pivot && i <= high - 1)
                i++;
            while (arr[j] < pivot && j >= low - 1)
                j--;

            // swap arr[i],arr[j]
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[low],arr[j]
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }
    // static int getPivot(int[] arr, int low, int high) {
    //     int pivot = arr[low];
    //     int i = low, j = high;

    //     while (i < j) {
    //         while (arr[i] <= pivot && i <= high - 1)
    //             i++;
    //         while (arr[j] > pivot && j >= low - 1)
    //             j--;

    //         // swap arr[i],arr[j]
    //         if (i < j) {
    //             int temp = arr[i];
    //             arr[i] = arr[j];
    //             arr[j] = temp;
    //         }
    //     }
    //     // swap arr[low],arr[j]
    //     int temp = arr[low];
    //     arr[low] = arr[j];
    //     arr[j] = temp;
    //     return j;
    // }

    public static void main(String[] args) {
        // int[] arr = { 13,46,24,52,20,9 };
        // int[] arr = { 64,25,12,22,11 };
        int[] arr = { 14,9,15,12,6,8,13 };

        // int[] arr = { 1,2,3,4,5};
        // selection(arr);
        // bubbleItr(arr);
        // bubbleRec(arr, arr.length);
        insertionItr(arr);
        // mergeSort(arr, 0, arr.length-1);
        // quickSort(arr, 0, arr.length - 1);

        // for (int i : arr)
        //     System.out.print(i + " ");
    }
}
