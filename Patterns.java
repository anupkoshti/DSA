import java.util.Scanner;

public class Patterns {
    // * * * * * 
    // * * * * * 
    // * * * * * 
    // * * * * * 
    // * * * * * 

    void p1(int n){
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

    void p2(int n) {
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

    void p3(int n) {
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

    void p4(int n) {
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

    void p5(int n) {
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

    void p6(int n) {
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }


    //         * 
    //       * * * 
    //     * * * * * 
    //   * * * * * * * 
    // * * * * * * * * * 

    void p7(int n) {
        for(int i=1;i<=n;i++){

            //print spaces
            for(int j=n;j>=i;j--){
                System.out.print("  ");
            }

            //print stars
            for(int j=1;j<=2*i-1;j++){
                System.out.print("* ");
            }

            System.out.println();
        }
    }
    
    //   * * * * * * * * * 
    //     * * * * * * * 
    //       * * * * * 
    //         * * * 
    //           * 

    void p8(int n) {
        for(int i=n;i>=1;i--){

            //print spaces
            for(int j=n;j>=i;j--){
                System.out.print("  ");
            }

            //print stars
            for(int j=2*i-1;j>=1;j--){
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

    void p9(int n) {
        p7(n);
        p8(n);

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

    void p10(int n) {
        p2(n);
        p5(n-1);
    }


    // 1 
    // 0 1 
    // 1 0 1 
    // 0 1 0 1 
    // 1 0 1 0 1 

    void p11(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print(1+" ");
                }else {
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
    }


    // 1        1
    // 12      21
    // 123    321
    // 1234  4321
    // 1234554321

    void p12(int n) {
        for(int i=n;i>=1;i--){

            int j;
            //print numbers
            for(j=1;j<=n-i+1;j++){
                System.out.print(j+"");
            }

            //print spaces
            for(int k=1;k<=2*i-2;k++){
                System.out.print(" ");
            }
            j--;
            //print numbers
            for(;j>=1;j--){
                System.out.print(j+"");
            }
            System.out.println();
        }
    }

    // 1 
    // 2 3 
    // 4 5 6 
    // 7 8 9 10 
    // 11 12 13 14 15 


    void p13(int n) {
        int sum=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(sum++ + " ");
            }
            System.out.println();
        }
    }


    // A
    // AB
    // ABC
    // ABCD
    // ABCDE

    void p14(int n) {
        for(int i=1;i<=n;i++){
            char ch='A';
            for(int j=1;j<=i;j++){
                System.out.print(ch+"");
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

    void p15(int n) {
        for(int i=1;i<=n;i++){
            char ch='A';
            for(int j=n;j>=i;j--){
                System.out.print(ch++);
            }
            System.out.println();
        }
    }

    // A
    // BB
    // CCC
    // DDDD
    // EEEEE

    void p16(int n) {
        char ch='A';
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(ch+"");
            }
            ch++;
            System.out.println();
        }
    }

    //      A
    //     ABA
    //    ABCBA
    //   ABCDCBA
    
    void p17(int n) {
        for(int i=1;i<=n;i++) {
            char ch='A';
            //spaces
            for(int j=n;j>=i;j--){
                System.out.print(" ");
            }

            //alphabets
            for(int j=1;j<=i;j++){
                System.out.print(ch++);
            }

            ch--;
            ch--;
            for(int j=1;j<=i-1;j++){
                System.out.print(ch--);
            }

            System.out.println();
        }
    }

    // E 
    // D E 
    // C D E 
    // B C D E 
    // A B C D E 

    void p18(int n) {
        // char ch='E';
        for(int i=1;i<=n;i++){
            for(char ch=(char)(int)('A'+n-i);ch<=(char)(int)('A'+n-1);ch++){
                System.out.print(ch +" ");
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

    void p19(int n) {

        //stars
        for(int i=1;i<=n;i++){
            for(int j=n;j>=i;j--){
                System.out.print("*");
            }
            // spaces
            for(int j=1;j<=2*i-2;j++){
                System.out.print(" ");
            }
            // stars 
            for(int j=n;j>=i;j--){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=n;i>=1;i--){
            for(int j=n;j>=i;j--){
                System.out.print("*");
            }
            // spaces
            for(int j=1;j<=2*i-2;j++){
                System.out.print(" ");
            }
            // stars 
            for(int j=n;j>=i;j--){
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

    void p20(int n) {
        for(int i=1;i<=n;i++){
            //stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            
            //spaces
            for(int j=2*n-2*i;j>=1;j--){
                System.out.print(" ");
            }
            //stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=n-1;i>=1;i--){
            //stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            
            //spaces
            for(int j=2*n-2*i;j>=1;j--){
                System.out.print(" ");
            }
            //stars
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

    void p21(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==n || j==n || i==1 || j==1) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }


    //DISTANCE FROM ALL SIDES => THAT NUMBER 
    //BUT FIRST SUBTRACT N, HERE N=4
    // 4 4 4 4 4 4 4 
    // 4 3 3 3 3 3 4 
    // 4 3 2 2 2 3 4 
    // 4 3 2 1 2 3 4 
    // 4 3 2 2 2 3 4 
    // 4 3 3 3 3 3 4 
    // 4 4 4 4 4 4 4 

    
    void p22(int n) {
        for(int i=0;i<2*n-1;i++){
            for(int j=0;j<2*n-1;j++){
                int top=i;
                int left=j;
                int right=2*n-2-j;
                int bottom=2*n-2-i;
                System.out.print((n - (Math.min(Math.min(top, left), Math.min(right, bottom))))+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        Patterns p = new Patterns();

        p.p22(n);


    }
}
