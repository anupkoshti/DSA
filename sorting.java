import java.util.ArrayList;

public class sorting {

    static void selection(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n - 2; i++) {
            int mixIdx = i;
            for (int j = i; j <= n - 1; j++) {
                if (arr[j] < arr[mixIdx])
                    mixIdx = j;
            }
            // swap arr[minIdx], arr[i]
            int temp = arr[i];
            arr[i] = arr[mixIdx];
            arr[mixIdx] = temp;
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
        for (int i = 0; i <= n - 1; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
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
        // int[] arr = { 5, 4, 3, 2, 1 };
        int[] arr = { 1,2,3,4,5};
        // selection(arr);
        // bubbleItr(arr);
        // bubbleRec(arr, arr.length);
        // insertionItr(arr);
        // mergeSort(arr, 0, arr.length-1);
        quickSort(arr, 0, arr.length - 1);

        for (int i : arr)
            System.out.print(i + " ");
    }
}
