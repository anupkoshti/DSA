public class Recursion {

    // 1. print name n times
    static void printNameNtimes(int i, int n) {
        if (i > n)
            return;
        System.out.println("Syrax");
        printNameNtimes(i + 1, n);
    }

    // 2. print linearly from 1 to n
    static void printFrom1ToN(int i, int n) {
        if (i > n)
            return;
        System.out.println(i);
        printFrom1ToN(i + 1, n);
    }

    // BACKTRACKING
    static void printFrom1ToNBT(int n) {
        if (n == 0)
            return;
        printFrom1ToNBT(n - 1);
        System.out.println(n);
    }

    // 3. print linearly from n to 1
    // normally without Back tracking
    static void printFromNTo1(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        printFromNTo1(n - 1);
    }

    // using backtracking
    static void printNto1BT(int i, int n) {
        if (i > n)
            return;
        printNto1BT(i + 1, n);
        System.out.println(i);
    }

    // sum of first n numbers - two ways

    // 1st where func returns something i.e sum
    static int sumRec(int n) {
        if (n == 0)
            return 0;
        return n + sumRec(n - 1);
    }

    // 2nd parameterized sum -> function need not return anything
    static void printSum(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        printSum(i - 1, sum + i);
    }

    // factorial of n
    static int factorial(int n) {
        if (n < 1)
            return 1;
        return n * factorial(n - 1);
    }

    // reverse array using while loop
    static void reverseArrLoop(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            // swap
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    // static void reverseArrRec1(int[] arr, int low, int high){

    // // base case
    // if(low>=high) return;

    // //swap
    // int temp=arr[low];
    // arr[low]=arr[high];
    // arr[high]=temp;
    // reverseArrRec1(arr, low+1, high-1);
    // }

    // using 1 variable
    static void reverseArrRec1(int[] arr, int i) {

        // base case
        if (i >= arr.length / 2)
            return;

        // swap arr[i],arr[n-i-1]
        int temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
        reverseArrRec1(arr, i + 1);
    }

    // check if a string is palindrome or not
    static boolean isPalindrome(String str, int i) {

        if (i >= str.length() / 2)
            return true;

        if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(str.length() - i - 1)))
            return false;

        return isPalindrome(str, i + 1);
    }


    //multiple recursion calls

    //fibonacci number
    //print the nth fibonacci number
    static int fibonacci(int n){
        if(n<2) return n;

        return fibonacci(n-1)+fibonacci(n-2);
    }


    


    public static void main(String[] args) {
        // printFrom1ToN(1,6);
        // printNameNtimes(1, 5);
        // printFromNTo1(5);
        // printNto1BT(1, 6);
        // System.out.println(returnSum(10));
        // printSum(3, 0);
        // System.out.println(factorial(13));
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // reverseArrLoop(arr);
        // reverseArrRec1(arr, 0, arr.length-1);
        // reverseArrRec1(arr, 0);
        // for(int i:arr){
        // System.out.print(i+" ");
        // }

        // System.out.println(isPalindrome("kaNnAK", 0));
        System.out.println(fibonacci(4));
    }
}