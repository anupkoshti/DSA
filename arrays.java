import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

public class arrays {

    // largest element in array
    static int getLargest(int[] arr) {
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest)
                largest = arr[i];
        }
        return largest;
    }


    //better -> find largest and then compare the largest with the arr[i]
    static int getSecondLargest(int[] arr) {
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest)
                largest = arr[i];
        }

        int secLar = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secLar && arr[i] != largest) {
                secLar = arr[i];
            }
        }
        return secLar;
    }


    //optimal ->  
    static int getSecondLargestOpt(int[] arr) {
        int largest = arr[0], secLar = -1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secLar = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secLar)
                secLar = arr[i];
        }

        return secLar;
    }

    // remove duplicates from sorted
    // return the length of the array after removing duplicates
    static int removeDuplicateSSorted(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return i + 1;
    }

    static void leftRotateByDPlaces(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        int temp[] = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        // shift
        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];    
        }

        for (int i = n - d; i < n; i++) {
            arr[i] = temp[i - n + d];
        }
    }

    static void leftRotateByDPlacesOptimal(int[] arr, int d) {
        int n=arr.length;
        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
    }

    static void reverse(int[] arr, int start, int end) {
        int i = start, j = end;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }


    //optimal
    // static void moveZeroesToEnd(int[] arr) {
    //     int j = -1, n = arr.length;
    //     for (int i = 0; i < n; i++) {
    //         if (arr[i] == 0) {
    //             j = i;
    //             break;
    //         }
    //     }

    //     for (int i = j + 1; i < n; i++) {
    //         if (arr[i] != 0) {
    //             // swap
    //             int temp = arr[j];
    //             arr[j] = arr[i];
    //             arr[i] = temp;
    //             j++;
    //         }
    //     }
    // }

    //optiml

    static void moveZeroesToEndOptimal(int[] arr) {
        int j=-1;
        //find the first index of non-zero ele
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) {
                j=i;
                break;
            }
        }
        //if no zereos found
        if(j==-1) return;

        //now traverse the rest
        for(int i=j+1;i<arr.length;i++){
            if(arr[i] != 0) {
                //swap arr[i],arr[j] and then j++
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
    }




    static ArrayList<Integer> getUnion(int arr1[], int[] arr2) {
        // HashSet<Integer> temp=new HashSet<>();
        TreeSet<Integer> temp = new TreeSet<>();

        for (int i = 0; i < arr1.length; i++)
            temp.add(arr1[i]);
        for (int i = 0; i < arr2.length; i++)
            temp.add(arr2[i]);

        return new ArrayList<>(temp);
    }

    static ArrayList<Integer> getUnionOptimized(int[] arr1, int[] arr2) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0, n1 = arr1.length, n2 = arr2.length;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (res.isEmpty() || res.getLast() != arr1[i]) {
                    res.add(arr1[i]);
                }
                i++;
            } else {
                if (res.isEmpty() || res.getLast() != arr2[j]) {
                    res.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < n1) {
            if (res.isEmpty() || res.getLast() != arr1[i]) {
                res.add(arr1[i]);
            }
            i++;
        }
        while (j < n2) {
            if (res.isEmpty() || res.getLast() != arr2[j]) {
                res.add(arr2[j]);
            }
            j++;
        }
        return res;
    }

    static ArrayList<Integer> getIntersection(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        ArrayList<Integer> res = new ArrayList<>();
        int[] visited = new int[n2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (arr1[i] == arr2[j] && visited[j] == 0) {
                    res.add(arr1[i]);
                    visited[j] = 1;
                    break;
                }
                if (arr2[j] > arr1[i])
                    break;
            }
        }
        return res;
    }

    static ArrayList<Integer> getIntersectionOptimized(int[] arr1, int[] arr2) {
        ArrayList<Integer> res = new ArrayList<>();

        int n1 = arr1.length, n2 = arr2.length;
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j])
                i++;

            else if (arr2[j] < arr1[i])
                j++;
            else {
                res.add(arr1[i]);
                i++;
                j++;
            }
        }
        return res;
    }

    static int maxConsecutiveOnes(int[] arr) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }

    static int getSingleElement(int[] arr) {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int value = mpp.getOrDefault(arr[i], 0);
            mpp.put(arr[i], value + 1);
        }

        // iterate thru haspmap
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() == 1)
                return it.getKey();
        }
        return -1;
    }

    // SUBARRAY SUM
    // 1
    static int longestSubarrayWithGivenSum(int[] arr, int K) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum == K)
                    max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

    // 2. optimized brute
    static int longestSubarrayWithGivenSumBruteOpt(int[] arr, int K) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == K)
                    max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

    // 3. better
    static int longestSubarrayWithGivenSumBetter(int[] arr, int K) {
        int sum = 0, maxLen = 0;

        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == K)
                maxLen = Math.max(maxLen, i + 1);
            int rem = sum - K;
            if (mpp.containsKey(rem)) {
                int len = i - mpp.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if (!mpp.containsKey(sum))
                mpp.put(sum, i);
        }
        return maxLen;
    }

    static int longestSubarrayWithGivenSumOptimal(int[] arr, int K) {
        int left = 0, right = 0;
        int sum = arr[0];
        int maxLen = 0;
        int n = arr.length;
        while (right < n) {

            while (left <= right && sum > K) {
                sum -= arr[left];
                left++;
            }
            if (sum == K)
                maxLen = Math.max(maxLen, right - left + 1);

            right++;
            if (right < n)
                sum += arr[right];
        }
        return maxLen;
    }

    static boolean check2SumBetter(int[] arr, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int more = target - num;
            if (mpp.containsKey(more))
                return true;
            mpp.put(num, i);
        }
        return false;
    }

    // DUTCH national flag
    static void DNF(int[] arr) {
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                // swap arr[mid],arr[low]
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                mid++;
                low++;
            } else if (arr[mid] == 1)
                mid++;

            else {
                // swap arr[mid],arr[high]
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    // majority element
    static int majorityEle(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
                if (count > n / 2)
                    return arr[i];
            }
        }
        return -1;
    }

    // hashing soln
    static int majorityEleHashing(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (mpp.containsKey(arr[i])) {
                int value = mpp.get(arr[i]);
                mpp.put(arr[i], value + 1);
            } else {
                mpp.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> m : mpp.entrySet()) {
            if (m.getValue() > n / 2)
                return m.getKey();
        }
        return -1;
    }

    static int mooreVoting(int[] arr) {
        int ele = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                ele = arr[i];
                count = 1;
            } else if (arr[i] == ele) {
                count++;
            } else
                count--;
        }

        int cnt1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele)
                cnt1++;
        }
        if (cnt1 > arr.length / 2)
            return ele;
        return -1;
    }

    static int kadanes(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        int start = 0, ansStart = -1, ansEnd = -1;

        for (int i = 0; i < n; i++) {
            if (sum == 0)
                start = i;
            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0)
                sum = 0;
        }
        System.out.println(ansStart + " to " + ansEnd);
        return maxi;
    }

    static void rearrangeBrute(int[] arr) {
        int n = arr.length;
        // int[] pos=new int[n/2];
        // int[] neg=new int[n/2];
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }

        for (int i = 0; i < pos.size(); i++) {
            arr[2 * i] = pos.get(i);
            arr[2 * i + 1] = neg.get(i);
        }
    }

    // in one pass
    static int[] rearrangeOptimal(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int pos = 0, neg = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                res[pos] = arr[i];
                pos += 2;
            } else {
                res[neg] = arr[i];
                neg += 2;
            }
        }
        return res;
    }

    // when pos!=negs
    static void rearrangeNotEqual(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }

        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[index++] = pos.get(i);
            }
        }

        else {
            for (int i = 0; i < pos.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index++] = neg.get(i);
            }
        }

    }

    static int buyAndSellStock(int[] arr) {
        int mini = arr[0];
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            int cost = arr[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, arr[i]);
        }
        return profit;
    }

    static void reverseArr(int[] arr, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    static void nextPermutaion(int[] arr) {
        // find pivot
        int n = arr.length;
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            reverseArr(arr, 0, n - 1);
            return;
        }

        // right most ele greater than pivot
        for (int i = n - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]) {
                // swap rme,pivot
                int temp = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = temp;
                break;
            }
        }

        reverseArr(arr, pivot + 1, n - 1);
    }

    static ArrayList<Integer> leaders(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();

        int maxi = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > maxi) {
                res.add(arr[i]);
            }
            maxi = Math.max(maxi, arr[i]);
        }
        return res;
    }

    static boolean ls(int[] arr, int ele) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele)
                return true;
        }
        return false;
    }

    static int longestConsecutiveSequesnceBrute(int[] arr) {
        int n = arr.length;
        int longest = 1;

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int count = 1;
            while (ls(arr, x + 1) == true) {
                x = x + 1;
                count++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    static int longestConsecutiveSequesnceBetter(int[] arr) {
        int n = arr.length;
        int longest = 1, count = 0;
        int lastSmaller = Integer.MIN_VALUE;

        // sort
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] - 1 == lastSmaller) {
                count++;
                lastSmaller = arr[i];
            } else if (lastSmaller != arr[i]) {
                count = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    static int longestConsecutiveSequesnceOptimal(int[] arr) {
        HashSet<Integer> h = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            h.add(arr[i]);
        }

        int longest = 1;
        // int cnt=1;
        // int x=i;
        // int count = 0;
        for (int i : h) {
            if (!h.contains(i - 1)) {
                int count = 1;
                int x = i;
                while (h.contains(x + 1)) {
                    x = x + 1;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    static void markRow(int[][] arr, int i, int m) {
        for (int j = 0; j < m; j++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    static void markCol(int[][] arr, int j, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    static void setMatrixZeroes(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        // mark -1
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    markRow(arr, i, col);
                    markCol(arr, j, row);
                }
            }
        }

        // traverse again and set to 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == -1)
                    arr[i][j] = 0;
            }
        }
    }

    // better
    static void setMatrixZeroesBetter(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[] col = new int[m];
        int[] row = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    static void setMatrixZeroesOptimal(int[][] arr) {
        int col0 = 1;
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    if (j != 0)
                        arr[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] != 0) {
                    if (arr[0][j] == 0 || arr[i][0] == 0) {
                        arr[i][j] = 0;
                    }
                }
            }
        }

        if (arr[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                arr[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                arr[i][0] = 0;
            }
        }
    }

    static int[][] rotateMatrixNinetyBrute(int[][] arr) {
        int n = arr.length;

        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - i - 1] = arr[i][j];
            }
        }
        return ans;

    }

    static void reverseArray(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    static void rotateMatrixNinetyOptimal(int[][] arr) {
        int n = arr.length;

        // transpose
        for (int i = 0; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                // arr[i][j]=arr[j][i];
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            reverseArray(arr[i]);
        }
    }

    static ArrayList<Integer> spiralTraversalMatrix(int[][] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        int m = arr[0].length;

        int top = 0;
        int right = m - 1;
        int left = 0;
        int bottom = n - 1;

        while (left <= right && top <= bottom) {

            // print first row
            for (int i = left; i <= right; i++) {
                res.add(arr[top][i]);
            }
            top++;

            // print last col
            for (int i = top; i <= bottom; i++) {
                res.add(arr[i][right]);
            }
            right--;

            if (top <= bottom) {
                // print last row
                for (int i = right; i >= left; i--) {
                    res.add(arr[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {

                // print first col
                for (int i = bottom; i >= top; i--) {
                    res.add(arr[i][left]);
                }
                left++;
            }
        }
        return res;
    }

    static int countSubarrayWithGivenSum(int[] arr, int K){
        HashMap<Integer, Integer> mpp =new HashMap<>();
        int cnt=0, preSum=0;

        mpp.put(0, 1);

        for(int i=0;i<arr.length;i++){
            preSum+=arr[i];

            int remove=preSum-K;

            cnt+=mpp.getOrDefault(remove, 0);
            mpp.put(preSum, mpp.getOrDefault(preSum,0)+1);
        }
        return cnt;
    }

    static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int[] arr={3,4,2,1,76,22};
        // int[] arr={1,1,2,2,2,3,3};

        int[] arr={1,2,3,4,5};
        // int d=3;

        // int n=arr.length;
        // System.out.println(getLargest(arr));
        // System.out.println(getSecondLargestOpt(arr));
        // System.out.println(removeDuplicateSSorted(arr));
        // printArray(arr);
        // leftRotateByDPlaces(arr, 2);
        // printArray(arr);
        // reverse(arr, 0, d-1);
        // reverse(arr, d, n-1);
        // reverse(arr, 0, n-1);

        // int[] arr={1,0,2,3,2,0,0,4,5,1};
        // moveZeroesToEnd(arr);
        // for(int i:arr) System.out.print(i+" ");

        // int[] arr1 = { 1, 1, 2, 3, 4, 5 };
        // int[] arr2 = { 2, 3, 4, 4, 5, 6 };
        // System.out.println(getUnionOptimized(arr1, arr2));
        // System.out.println(getIntersectionOptimized(arr1, arr2));

        // int nums[]={1,1,0,1,1,1,1,0,1,1};
        // System.out.println(maxConsecutiveOnes(nums));

        // int[] arr = {4, 1, 2, 1, 2};
        // System.out.println(getSingleElement(arr));
        // int[] arr={1,2,3,1,1,1,1,1,4,2,3};
        // int[] arr = {2,0,0,5};
        // System.out.println(longestSubarrayWithGivenSum(arr, 3));
        // System.out.println(longestSubarrayWithGivenSumBruteOpt(arr, 5));
        // System.out.println(longestSubarrayWithGivenSumBetter(arr, 5));
        // System.out.println(longestSubarrayWithGivenSumOptimal(arr, 5));
        // int[] arr={2,6,5,8,11};
        // int target=14;
        // System.out.println(check2SumBetter(arr, target));

        // int[] arr={1,2,0,2,1,0,0,2,1,1,0,2,0,0};
        // DNF(arr);
        // for(int i: arr) System.out.print(i+" ");

        // int[] arr={2,2,3,3,1,2,2};
        // System.out.println(majorityEle(arr));
        // System.out.println(majorityEleHashing(arr));
        // System.out.println(mooreVoting(arr));

        // int[] arr={-2,-3,4,-1,-2,1,5,-3};
        // System.out.println(kadanes(arr));

        // int[] arr={3,1,-2,-5,2,-4,1,2,-87,5,8};
        // rearrangeBrute(arr);
        // arr=rearrangeOptimal(arr);
        // rearrangeNotEqual(arr);
        // for(int i: arr) System.out.print(i+" ");

        // int[] arr={7,1,5,3,6,4};
        // System.out.println(buyAndSellStock(arr));

        // int[] arr={5,4,3,2,1};
        // nextPermutaion(arr);
        // for(int i:arr) System.out.print(i+" ");

        // int[] arr={10,22,12,3,0,6};
        // System.out.println(leaders(arr));

        // int[] arr = { 102, 4, 100, 1, 101, 3, 2, 1, 1 };
        // System.out.println(longestConsecutiveSequesnceBrute(arr));
        // System.out.println(longestConsecutiveSequesnceBetter(arr));
        // System.out.println(longestConsecutiveSequesnceOptimal(arr));

        // int[][] arr = {
        // {1,1,1,1},
        // {1,0,0,1},
        // {1,1,0,1},
        // {1,0,1,1}
        // };

        // int[][] arr = {
        // { 1, 2, 3, 4 },
        // { 5, 6, 7, 8 },
        // { 9, 10, 11, 12 },
        // { 13, 14, 15, 16 }
        // };

        // int[][] arr = {
        //         { 1, 2, 3, 4 },
        //         { 5, 6, 7, 8 },
        //         { 9, 10, 11, 12 },
        // };

        // setMatrixZeroes(arr);
        // setMatrixZeroesBetter(arr);
        // setMatrixZeroesOptimal(arr);
        // arr=rotateMatrixNinetyBrute(arr);
        // rotateMatrixNinetyOptimal(arr);

        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr.length; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }
        // System.out.println(spiralTraversalMatrix(arr));

        // int[] arr={1,2,3,-3,1,1,1,4,2,-3};
        // System.out.println(countSubarrayWithGivenSum(arr, 3));

        int[] arr1={1,0,2,3,2,0,0,4,5,1};
        moveZeroesToEndOptimal(arr1);
        printArray(arr1);
    }
}
