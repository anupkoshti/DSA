public class binarySearch {

    static int binarySearchItr(int[] arr, int K) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == K)
                return mid;
            else if (K > arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    static int binarySearchRec(int[] arr, int low, int high, int K) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (arr[mid] == K)
            return mid;

        else if (K > arr[mid])
            return binarySearchRec(arr, mid + 1, high, K);

        return binarySearchRec(arr, low, mid - 1, K);
    }

    static int lowerBound(int[] arr, int x) {
        int ans = arr.length;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static int firstOccur(int[] arr, int x) {
        int ans = -1;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                ans = mid;
                high = mid - 1;
            } else if (x > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    static int lastOccur(int[] arr, int x) {
        int ans = -1;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                ans = mid;
                low = mid + 1;
            } else if (x > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // 1. search in sorted rotated array (No duplicated allowed)

    static int searchSortedRotated(int[] arr, int K) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == K)
                return mid;

            // check if left half is sorted
            else if (arr[low] <= arr[mid]) {
                // if K lies between
                if (K >= arr[low] && K <= arr[mid]) {
                    high = mid - 1;
                } else
                    low = mid + 1;
            }
            // the right must be sorted
            else {
                // if k lies in between
                if (K >= arr[mid] && K <= arr[high]) {
                    low = mid + 1;
                } else
                    high = mid - 1;
            }
        }
        return -1;
    }

    // 2. search in sorted rotated array (duplicated allowed)

    static int searchSortedRotatedTwo(int[] arr, int K) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == K)
                return mid;

            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }
            // check if left half is sorted
            else if (arr[low] <= arr[mid]) {
                // if K lies between
                if (K >= arr[low] && K <= arr[mid]) {
                    high = mid - 1;
                } else
                    low = mid + 1;
            }
            // the right must be sorted
            else {
                // if k lies in between
                if (K >= arr[mid] && K <= arr[high]) {
                    low = mid + 1;
                } else
                    high = mid - 1;
            }
        }
        return -1;
    }

    // find minimum in sorted rotated array
    static int findMinInSortedRotated(int[] arr) {
        int n = arr.length, low = 0, high = n - 1;
        int mini = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            // if entire array is sorted
            // (i.e slightly optimized)
            if (arr[low] <= arr[high]) {
                mini = Math.min(mini, arr[low]);
                break;
            }
            // if left is sorted
            if (arr[low] <= arr[mid]) {
                // store the min
                // mini=arr[low];
                mini = Math.min(mini, arr[low]);
                low = mid + 1;
            }

            // else right must be sorted
            else {
                mini = Math.min(mini, arr[mid]);
                high = mid - 1;
            }
        }
        return mini;
    }

    static int findSingleElemBrute(int[] arr){
        int n=arr.length;
        if(n==1) return arr[0];

        for(int i=0;i<n;i++){
            if(i==0) {
                if(arr[0]!=arr[1]) return arr[0];
            } 
            else if(i==n-1){
                if(arr[n-1]!=arr[n-2]) return arr[n-1];
            }
            else {
                if(arr[i]!=arr[i-1] && arr[i]!=arr[i+1]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    static int findSingleElementInArray(int[] arr) {
        int n = arr.length;
        int low = 1, high = n - 2;
        if (n == 1)
            return arr[0];
        if (arr[0] != arr[1])
            return arr[0];
        if (arr[n - 1] != arr[n - 2])
            return arr[n - 1];

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            // (e,o) case i.e standing on left half
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1]))
                // elimate the left half
                low = mid + 1;

            else
            //eliminate the right half
                high = mid - 1;
        }
        return -1;
    }

    static int findPeak(int[] arr) {
        int n=arr.length;
        int low=0, high=n-1;
        while (low<=high) {
            int mid=(low+high)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return mid;

            else if(arr[mid]>arr[mid-1]) low=mid+1;

            else high=mid-1;
        }
        return -1;
    }


    

    public static void main(String[] args) {
        // int[] arr={3,4,6,7,9,12,16,17};
        // int K=9;

        // System.out.println(binarySearchItr(arr, K));
        // System.out.println(binarySearchRec(arr, 0, arr.length-1, K));

        // int[] arr={1,2,3,3,5,8,8,10,10,11};
        // System.out.println(lowerBound(arr, 9));

        // int[] arr={2,4,6,8,8,8,11,13};
        // System.out.println(firstOccur(arr, 8));
        // System.out.println(lastOccur(arr, 8));
        // int[] arr = { 4, 5, 6, 7, 1, 2, 3 };
        // System.out.println(searchSortedRotated(arr, 6));
        // System.out.println(findMinInSortedRotated(arr));
        // int[] arr={1,1,2,2,3,3,4,5,5,6,6};
        // System.out.println(findSingleElementInArray(arr));
        int[] arr={1,2,3,4,6,5,4,2};
        System.out.println(findPeak(arr));
    }
}
