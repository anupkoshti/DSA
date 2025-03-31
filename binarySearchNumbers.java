import java.util.Arrays;

public class binarySearchNumbers {

    // 0. Find nth root of M

    static int NthRootBrute(int M, int n) {
        for (int i = 1; i <= M; i++) {
            if (Math.pow(i, n) == M) {
                return i;
            }

            else if (Math.pow(i, n) > M)
                break;
        }
        return -1;
    }

    // using binary search

    static int NthRootBinary(int M, int n) {
        int low = 1, high = M;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (Math.pow(mid, n) == M)
                return mid;

            else if (Math.pow(mid, n) < M)
                low = mid + 1;

            else
                high = mid - 1;
        }
        return -1;
    }

    // but the above method wont work if we have large numbers because we evaluate
    // (mid) raised to n

    // optimal approach - calc mid raised to n in a different way

    // ans > M ===> 2
    // ans == M ===> 1
    // ans < M ===> 0

    static int funkMidraisedtoN(int mid, int n, int M) {
        long ans = 1;

        for (int i = 1; i <= n; i++) {
            ans = ans * mid;

            if (ans > M)
                return 2;
        }

        if (ans == M)
            return 1;

        return 0;
    }

    static int NthRootOptimalBinary(int M, int n) {
        int low = 1, high = M;

        while (low <= high) {
            int mid = (low + high) / 2;

            int midN = funkMidraisedtoN(mid, n, M);

            if (midN == 1)
                return mid;

            else if (midN == 0)
                low = mid + 1;

            else
                high = mid - 1;

        }
        return -1;
    }

    // 1. KOKO eating bananas - return the min integer K so that KOKO can eat all
    // bananas within h hours

    static int KOKO(int[] piles, int h) {

        // Calc maximum
        int maxi = piles[0];

        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > maxi)
                maxi = piles[i];
        }

        for (int i = 1; i <= maxi; i++) {
            int requiredTime = funk(piles, i);
            if (requiredTime <= h) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearchKOKO(int[] piles, int h) {
        // Calc maximum
        int maxi = piles[0];

        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > maxi)
                maxi = piles[i];
        }

        int low = 1, high = maxi;

        while (low <= high) {
            int mid = (low + high) / 2;

            int requiredTime = funk(piles, mid);

            if (requiredTime <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    static int funk(int[] piles, int hours) {
        int totalHrs = 0;

        for (int i = 0; i < piles.length; i++) {
            totalHrs += Math.ceil((double) piles[i] / (double) hours);
        }

        return totalHrs;
    }

    // 2. Minimum days to make M bouquets

    static int Bouquets(int[] bloomingDays, int m, int k) {
        int maxi = bloomingDays[0];
        int mini = bloomingDays[0];

        for (int i = 0; i < bloomingDays.length; i++) {
            maxi = Math.max(maxi, bloomingDays[i]);
            mini = Math.min(maxi, bloomingDays[i]);
        }

        for (int ans = mini; ans <= maxi; ans++) {

            // iterate thru arr

            int counter = 0, noOfBouquets = 0;
            for (int i = 0; i < bloomingDays.length; i++) {
                if (bloomingDays[i] <= ans) {
                    counter++;
                } else {
                    noOfBouquets += counter / k;
                    counter = 0;
                }
            }
            noOfBouquets += counter / k;
            if (noOfBouquets == m)
                return ans;
        }
        return -1;
    }

    static boolean isTheDayPossible(int[] bloomingDays, int day, int k, int m) {

        int counter = 0, noOfBouquets = 0;
        for (int i = 0; i < bloomingDays.length; i++) {
            if (bloomingDays[i] <= day)
                counter++;

            else {
                noOfBouquets += counter / k;
                counter = 0;
            }
        }
        noOfBouquets += counter / k;
        if (noOfBouquets >= m)
            return true;

        return false;
    }

    static int bouquetsBinarySearch(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        if (val > bloomDay.length)
            return -1;

        // System.out.println(bloomDay.length);

        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            maxi = Math.max(maxi, bloomDay[i]);
            mini = Math.min(maxi, bloomDay[i]);
        }

        int low = 1, high = maxi;
        System.out.println(maxi + " " + mini);

        while (low <= high) {
            // int mid = (low+high) / 2;
            int mid = low + (high - low) / 2;

            if (isTheDayPossible(bloomDay, mid, k, m))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    // 3. Find the smallest divisor given a threshold

    // brute force
    static int findMiniDivisorBrute(int[] arr, int threshold) {
        int maxi = arr[0];
        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        for (int ans = 1; ans <= maxi; ans++) {
            int sum = 0;

            // iterate thru array
            for (int i = 0; i < arr.length; i++) {
                sum += Math.ceil((double) arr[i] / ans);
            }

            if (sum <= threshold)
                return ans;
        }
        return -1;
    }

    // optimal using binary search

    static boolean isDivisorPossible(int[] arr, int mid, int threshold) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.ceil((double) arr[i] / mid);
        }

        return sum <= threshold;
    }

    static int findMiniDivisorOptimal(int[] arr, int threshold) {
        int maxi = arr[0];
        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        int low = 1, high = maxi;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isDivisorPossible(arr, mid, threshold)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


    //4. Least capacity to ship packages within D days

    // static int isCapacityPossible(int[] weights, int ans) {
    //     int days=1, load=0;

    //     for(int i=0;i<weights.length;i++){
    //         if(load + weights[i] > ans) {
    //             days++;
    //             load=weights[i];
    //         }
    //         else {
    //             load+=weights[i];
    //         }
    //     }
    //     return days;
    // }

    static boolean isCapacityPossible(int[] weights, int ans, int d) {
        int days=1, load=0;

        for(int i=0;i<weights.length;i++){
            if(load + weights[i] > ans) {
                days++;
                load=weights[i];
            }
            else {
                load+=weights[i];
            }
        }
        return days <= d;
    }

    // static int leastCapacity(int[] weights, int days) {
    //     int maxi=weights[0];
    //     int sum=0;
    //     for(int i=0;i<weights.length;i++){
    //         maxi=Math.max(maxi,weights[i]);
    //         sum+=weights[i];
    //     }

    //     for(int ans=maxi; ans<= sum; ans++){
    //         int daysReq = isCapacityPossible(weights, ans);
    //         if(daysReq <= days) return ans;
    //     }
    //     return -1;
    // }

    


    //using binary search 

    static int leastCapacityBinary(int[] weights, int days) {
        int maxi=weights[0];
        int sum=0;
        for(int i=0;i<weights.length;i++){
            maxi=Math.max(maxi,weights[i]);
            sum+=weights[i]; 
        }

        int low=maxi, high=sum;

        while (low<=high) {
            int mid= (low+high)/2;

            if(isCapacityPossible(weights, mid, days)) {
                high=mid-1;
            }
            else {
                low= mid+1;
            }
        }
        return low;
    }

// CATEGORY 3 PROBLEMS - MIN OF MAX or MAX OF MIN

    //1. Aggresive cows problem

    static boolean canWePlaceCow(int[] distances, int distance, int cows) {
        Arrays.sort(distances);
        int cntCows=1, last=distances[0];

        for(int i=1; i<distances.length;i++){
            if(distances[i]-last >= distance) {
                cntCows+=1;
                last=distances[i];
            }

            if(cntCows >= cows) return true;
        }
        return false;
    }

    static int aggresiveCows(int[] distances, int cows) {
        

        int maxi=distances[0], mini=distances[0];

        for(int i=0;i<distances.length;i++){
            maxi=Math.max(maxi, distances[i]);
            mini=Math.min(mini, distances[i]);
        }

        for(int i=1; i<=(maxi-mini);i++){
            if(canWePlaceCow(distances, i, cows)) {
                continue;
            }
            else return i-1;
        }
        return -1;
    }


    //optimised using binary search

    static int aggresiveCowsBinary(int[] distances, int cows) {
        // Arrays.sort(distances);
        int maxi=distances[0], mini=distances[0];

        for(int i=0;i<distances.length;i++){
            maxi=Math.max(maxi, distances[i]);
            mini=Math.min(mini, distances[i]);
        }

        int low=1, high=maxi-mini;

        while (low<=high) {
            int mid=(low+high)/2;

            if(canWePlaceCow(distances, mid, cows)) {
                low=mid+1;
            }

            else high=mid-1;
        }

        return high;
    }


    //allocate books

    static int returnNoOfStudents(int[] pagesArr, int pages) {
        int std=1, pagesStd=0;

        for(int i=0;i<pagesArr.length;i++){
            if(pagesStd + pagesArr[i] <= pages){
                pagesStd+=pagesArr[i];
            }

            else {
                std++;
                pagesStd=pagesArr[i];
            }
        }

        return std;
    }


    static int allocateBooksBrute(int[] pages, int students) {
        int maxi=pages[0], sum=0;

        for(int i=0;i<pages.length;i++){
            maxi=Math.max(maxi, pages[i]);
            sum+=pages[i];
        }

        for(int i=maxi;i<=sum;i++){
            int cntStds = returnNoOfStudents(pages, i);

            if(cntStds == students) return i;
        }
        return -1;
    }


    // using binary search - optimal

    static int allocateBooksOptimal(int[] pages, int students) {
        int maxi=pages[0], sum=0;

        if(students > pages.length) return -1;

        for(int i=0;i<pages.length;i++){
            maxi=Math.max(maxi, pages[i]);
            sum+=pages[i];
        }

        int low=maxi, high=sum;

        while (low<=high) {
            int mid=(low+high)/2;

            int stdCnt = returnNoOfStudents(pages, mid);
            if(stdCnt <= students) high=mid-1;
            
            else low=mid+1;
        }

        return low;
    }

    public static void main(String[] args) {
        // int[] piles = { 30,11,23,4,20 };
        // int h = 5;

        // System.out.println(KOKO(piles, h));
        // System.out.println(binarySearchKOKO(piles, h));

        int[] bloomingDays = { 7, 7, 7, 7, 13, 11, 12, 7 };
        int m = 2, k = 3;

        // System.out.println(Bouquets(bloomingDays, m, k));
        // System.out.println(bouquetsBinarySearch(bloomingDays, m, k));

        // System.out.println(NthRootBrute(64 , 2));
        // System.out.println(NthRootBinary(64, 6));
        // System.out.println(NthRootOptimalBinary(81, 2));

        int[] arr = { 1, 2, 5, 9 };
        int threshold = 6;

        // System.out.println(findMiniDivisorBrute(arr, threshold));
        // System.out.println(findMiniDivisorOptimal(arr, threshold));


        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days=5;
        // System.out.println(leastCapacity(weights, days));
        // System.out.println(leastCapacityBinary(weights, days));



        int[] distances={6,4, 3, 16, 20, 7, 18, 10};
        int cows=5;

        // System.out.println(aggresiveCows(distances, cows));
        // System.out.println(aggresiveCowsBinary(distances, cows));

        int[] pages = {25,46,28,49,24};
        int students=4;

        // System.out.println(allocateBooksBrute(pages, students));
        System.out.println(allocateBooksOptimal(pages, students));
    }
}
