import java.util.HashMap;

public class Practice {

    static void leftRotateByDPlaces1(int[] arr, int d) {
        int n=arr.length;
        int[] temp = new int[n];
        
        for(int i=0;i<n;i++){
            temp[((i+d)%n)] =arr[i]; 
        }

        for(int i=0;i<n;i++){
            arr[i]=temp[i];
        }
    }

    // static int longestSubarraywithSumK(int[] arr, int K) {
    //     int length=0;

    //     for(int i=0;i<arr.length;i++){
    //         for(int j=i;j<arr.length;j++){
    //             int sum=0;
    //             for(int k=i;k<=j;k++){
    //                 sum+=arr[j];
    //             }
    //             if(sum == K) {
    //                 length = Math.max(length, j-i+1);
    //             }
    //         }
    //     }
    //     return length;
    // }

    static int longestSubarraywithSumK(int[] arr, int K){
        int length=0;

        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==K){
                    length = Math.max(length, j-i+1);
                }
            }
        }
        return length;
    }


    static int longestSubarrayWithSumKHashMap(int[] arr, int K){
        int maxLength=0, sum=0;
        HashMap<Integer, Integer> mpp=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum == K) maxLength=Math.max(maxLength, i+1);

            int rem=sum-K;
            if(mpp.containsKey(rem)) {
                maxLength = Math.max(maxLength, i-mpp.get(rem));
            }

            if(!mpp.containsKey(sum)) mpp.put(sum,i);
        }
        return maxLength;
    }

    static int longestSubarrayWithSumKOnlyPositives(int[] arr, int K){
        int sum=0, maxLen=0, left=0, right=0, n=arr.length;

        while (right<n) {
            sum+=arr[right];
            while (sum>K) {
                sum-=arr[left];
                left++;
            }

            if(sum == K) maxLen=Math.max(maxLen, right-left+1);

            right++;
        }
        return maxLen;
    }


    // * * * * *  
    // * * * * *  
    // * * * * *  
    // * * * * *  
    // * * * * *  
    static void p1(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    // *  
    // * *  
    // * * *  
    // * * * *  
    // * * * * *  
    static void p2(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 1  
    // 1 2  
    // 1 2 3  
    // 1 2 3 4  
    // 1 2 3 4 5  

    static void p3(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    // 1  
    // 2 2  
    // 3 3 3  
    // 4 4 4 4  
    // 5 5 5 5 5  
    static void p4(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    // * * * * *  
    // * * * *  
    // * * *  
    // * *  
    // *  
    static void p5(int n){
        for(int i=1;i<=n;i++){
            for(int j=n;j>=i;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 1 2 3 4 5  
    // 1 2 3 4  
    // 1 2 3  
    // 1 2  
    // 1  

    static void p6(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }


    //         *  
    //       * * *  
    //     * * * * *  
    //   * * * * * * *  
    // * * * * * * * * *  
    static void p7(int n) {
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=1; j<=n-i;j++){
                System.out.print("  ");
            }

            //print stars
            for(int j=1;j<=2*i-1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    // * * * * * * * * *  
    //   * * * * * * *  
    //     * * * * *  
    //       * * *  
    //         *  

    static void p8(int n) {
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=1; j<=i-1;j++){
                System.out.print("  ");
            }

            //print stars
            for(int j=1;j<=2*(n-i)+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
//         *  
//       * * *  
//     * * * * *  
//   * * * * * * *  
// * * * * * * * * *  
// * * * * * * * * *  
//   * * * * * * *  
//     * * * * *  
//       * * *  
//         *  

    static void p9(int n) {
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=1; j<=n-i;j++){
                System.out.print("  ");
            }

            //print stars
            for(int j=1;j<=2*i-1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int i=1;i<=n;i++){
            //spaces
            for(int j=1; j<=i-1;j++){
                System.out.print("  ");
            }

            //print stars
            for(int j=1;j<=2*(n-i)+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }


    // *  
    // * *  
    // * * *  
    // * * * *  
    // * * * * *  
    // * * * *  
    // * * *  
    // * *  
    // *  

    static void p10(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int i=1;i<=n-1;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    // 1  
    // 0 1  
    // 1 0 1  
    // 0 1 0 1  
    // 1 0 1 0 1  

    static void p11(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0) System.out.print(1+" ");
                else System.out.print(0+" ");
            }
            System.out.println();
        }
    }

    // 1        1  
    // 12      21  
    // 123    321  
    // 1234  4321  
    // 1234554321  

    static void p12(int n) {
        for(int i=1;i<=n;i++){
            //print numbers
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            //print spaces
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }


            //print numbers
            int k=i;
            for(int j=1;j<=i;j++){
                System.out.print(k);
                k--;
            }

            System.out.println();
        }
    }

    // 1  
    // 2 3  
    // 4 5 6  
    // 7 8 9 10  
    // 11 12 13 14 15  

    static void p13(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(++sum+" ");
            }
            System.out.println();
        }
    }


    // A  
    // AB  
    // ABC  
    // ABCD  
    // ABCDE  

    static void p14(int n) {
        for(int i=1;i<=n;i++){
            char ch='A';
            for(int j=1;j<=i;j++){
                System.out.print(ch + "");
                ch++;
            }
            System.out.println();
        }
    }

    // ABCDE  
    // ABCD  
    // ABC  
    // AB  
    // A  

    static void p15(int n){
        for(int i=1;i<=n;i++){
            char ch='A';
            for(int j=1;j<=n-i+1;j++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }

    // A  
    // BB  
    // CCC  
    // DDDD  
    // EEEEE  

    static void p16(int n) {
        char ch='A';
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(ch + "");
            }
            ch++;
            System.out.println();
        }
    }

    //      A  
    //     ABA  
    //    ABCBA  
    //   ABCDCBA  

    static void p17(int n) {
        for(int i=1;i<=n;i++){
            //print spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }

            char ch='A';
            
            for(int j=1;j<=i;j++){
                System.out.print(ch);
                ch++;
            }
            ch-=2;
            for(int j=1;j<=i-1;j++){
                System.out.print(ch);
                ch--;
            }
            System.out.println();

        }
    }

    // E  
    // D E  
    // C D E  
    // B C D E  
    // A B C D E  

    static void p18(int n) {

        for(int i=1;i<=n;i++){  
            char ch = (char) ('F'-i);

            for(int j=1;j<=i;j++){
                System.out.print(ch +" ");
                ch++;
            }
            System.out.println();
        }
    }

    // **********  
    // ****  ****  
    // ***    ***  
    // **      **  
    // *        *  
    // *        *  
    // **      **  
    // ***    ***  
    // ****  ****  
    // ********** 
    
    static void p19(int n){
        for(int i=1;i<=n;i++){
            //print stars

            for(int j=1;j<=n-i+1;j++){
                System.out.print("*");
            }

            //print spaces 0-2-4-6-8
            for(int j=1;j<=2*i-2;j++){
                System.out.print(" ");
            }

            //print stars
            for(int j=1;j<=n-i+1;j++){
                System.out.print("*");
            }

            System.out.println();
        }


        //print in reverse

        for(int i=n;i>=1;i--){
            //print stars

            for(int j=1;j<=n-i+1;j++){
                System.out.print("*");
            }

            //print spaces 0-2-4-6-8
            for(int j=1;j<=2*i-2;j++){
                System.out.print(" ");
            }

            //print stars
            for(int j=1;j<=n-i+1;j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

    // *        *  
    // **      **  
    // ***    ***  
    // ****  ****  
    // **********  
    // ****  ****  
    // ***    ***  
    // **      **  
    // *        *  

    static void p20(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            
            //print spaces
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }

            //print stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=n-1;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            
            //print spaces
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }

            //print stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    // * * * * *  
    // *       *  
    // *       *  
    // *       *  
    // * * * * *  

    static void p21(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==1 || i == n || j ==1 || j == n){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // 4 4 4 4 4 4 4  
    // 4 3 3 3 3 3 4  
    // 4 3 2 2 2 3 4  
    // 4 3 2 1 2 3 4  
    // 4 3 2 2 2 3 4  
    // 4 3 3 3 3 3 4  
    // 4 4 4 4 4 4 4  

    static void p22(int n){

    }


    //         *  
    //       * *  
    //     * * *  
    //   * * * *  
    // * * * * *  


    static void p23(int n){
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }

            //stars
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    //         1  
    //       1 2  
    //     1 2 3  
    //   1 2 3 4  
    // 1 2 3 4 5  

    static void p24(int n){
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }

            //stars
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    // * * * * *  
    //   * * * *  
    //     * * *  
    //       * *  
    //         *  

    static void p25(int n){
        for(int i=1;i<=n;i++){
            //spaces

            for(int j=1;j<=i-1;j++){
                System.out.print("  ");
            }

            //stars
            for(int j=1;j<=n-i+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    

    // * * * * *  
    //  * * * *  
    //   * * *  
    //    * *  
    //     *  
    //    * *  
    //   * * *  
    //  * * * *  
    // * * * * *  

    static void p26(int n){
        for(int i=1;i<=n;i++){
            //spaces

            for(int j=1;j<=i-1;j++){
                System.out.print(" ");
            }
            //stars
            for(int j=1;j<=n-i+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int i=n-1;i>=1;i--){
            //spaces

            for(int j=1;j<=i-1;j++){
                System.out.print(" ");
            }
            //stars
            for(int j=1;j<=n-i+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //     *  
    //    * *  
    //   *   *  
    //  *     *  
    // *********  

    static void p27(int n){
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }

            //stars
            for(int j=1;j<=2*i - 1;j++){
                if(j==1 || j==2*i-1 || i==n){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // * * * * *  
    //       *  
    //     *  
    //   *  
    // * * * * *  
    
    static void p28(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==1 || i==n || (i+j)%(n+1)==0){
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        //PATTERNS
        Practice.p28(10);




        // int[] arr = {1,2,3,4,5};
        // leftRotateByDPlaces1(arr, 2);

        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }
        // System.out.println();

        // int[] arr={1,2,3,1,1,1,4,2,3};
        // int K=3;
        // System.out.println(longestSubarraywithSumK(arr, K));
        // System.out.println(longestSubarrayWithSumKHashMap(arr, K));
        // System.out.println(longestSubarrayWithSumKOnlyPositives(arr, K));


    }
}
