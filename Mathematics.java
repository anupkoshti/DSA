import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Mathematics {
    int countDigits(int num) {
        int res=0;
        while(num>0) {
            res++;
            num=num/10;
        }
        return res;
    }

    void printReverse(int n) {
        int res=0;
        while(n>0) {
            int lastDigit=n%10;
            res = res*10 + lastDigit;
            n=n/10;
        }
        System.out.println(res);
    }

    boolean isPalindrome(int n) {
        int rev=0;
        int temp=n;
        while(temp!=0){
            int lastDigit=temp%10;
            rev=rev*10+lastDigit;
            temp=temp/10;
        }
        return rev==n;
    }

    int factItr(int n) {
        int res=1;
        for(int i=2;i<=n;i++){
            res=res*i;
        }
        return res;
    }

    int factRec(int n) {
        if(n==0) return 1;

        return n*factRec(n-1);
    }

    //count trailing zeroes in fact
    //naive
    int countTrailing(int n) {
        int fact=1;
        for(int i=2;i<=n;i++){
            fact=fact*i;
        }

        int res=0;
        while (fact%10==0) {
            res++;
            fact/=10;  
        }
        return res;

    }

    int countTrailingOpt(int n) {
        int res=0;

        for(int i=5;i<=n;i*=5) {
            res = res+ n/i;
        }
        return res;
    }

    int GCDnaive(int a, int b) {
        int res=Math.min(a, b);

        while (res>0) {
            if(a%res==0 && b%res==0){
                break;
            }
            res--;
        }
        return res;
    }

    int GCDopt(int a, int b){
        while(a>0 && b>0) {
            if(a>b){
                a=a%b;
            }
            else b=b%a;
        }
        if(a==0) return b;
        return a;
    }


    //print divisors of a number
    void printDivisors(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<Math.sqrt(n);i++){
            if(n%i==0){
                arr.add(i);
                if(i!=n/i){
                    arr.add(n/i);
                }
            }
        }
        System.out.println(arr);
    }


    //is Prime
    int isPrime(int n) {
        int cnt=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                cnt++;
            }
        }
        return cnt;
    }

    int isPrimeOpt(int n) {
        int cnt=0;
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                cnt++;
                if(n/i!=i){
                    cnt++;
                }
            }
            if(cnt>2) break;
        }
        return cnt;
    }

    //print prime factors
    void primeFactorsNaive(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(n%i==0){
                if(isPrimeOpt(i)==2){
                    arr.add(i);
                }
            }
        }
        System.out.println(arr);
    }
    
    void printPrimeFactorsOpt1(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(n%i==0) {
                if(isPrimeOpt(i)==2) arr.add(i);
                if(n/i!=i) {
                    if(isPrimeOpt(n/i)==2) arr.add(n/i);
                }
            }
            }
        System.out.println(arr);
    }

    void primeFactorOpt2(int n) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=2;i*i<=n;i++){
            if(n%i==0) {
                arr.add(i);
                while (n%i==0) {
                    n=n/i;
                }
            }
        }
        if(n!=1) arr.add(n);
        System.out.println(arr);
    }

    int powerExp(int x, int n){
        int ans=1;
        // int m=n;
        // if(n<0) n=-1*n;
        while(n>0) {
            if(n%2==1){
                ans=ans*x;
                n=n-1;
            }
            else{
                n=n/2;
                x=x*x;
            }
        }
        // if(m<0) ans=1/ans;
        return ans;
    } 

    void sieveNaive(int n){
        int[] prime = new int[n+1];
        Arrays.fill(prime, 1);

        for(int i=2;i<=n;i++){
            if(prime[i]==1){
                for(int j=2*i;j<=n;j+=i){
                    prime[j]=0;
                }
            }
        }

        for(int i=2;i<prime.length;i++){
            if(prime[i]==1){
                System.out.print(i+" ");
            }
        }

    }

    boolean isArmstrong(int n){
        int num=n;
        int sum=0;
        int k=String.valueOf(n).length();
        while (n>0) {
            int lastDigit=n%10;
            sum+=Math.pow(lastDigit, k);
            n=n/10;
        }
        return sum==num;
    }


    public static void main(String[] args) {

        Mathematics m = new Mathematics();

        System.out.println(m.countDigits(456));
        // m.printReverse(456);
        // System.out.println(m.isPalindrome(10));
        // System.out.println(m.factItr(5));
        // System.out.println(m.factRec(1));
        // System.out.println(m.countTrailingOpt(20));
        // System.out.println(m.GCDnaive(10,15));
        // System.out.println(m.GCDopt(10,15));
        // m.printDivisors(36);
        // if(m.isPrimeOpt(25) == 2) {
        //     System.out.println("prime");
        // }else {
        //     System.out.println("Not prime");
        // // }
        // m.primeFactorsNaive(780);
        // m.printPrimeFactorsOpt1(780);
        // m.primeFactorOpt2(67);
        // System.out.println(m.powerExp(2, -5));
        // m.sieveNaive(100);
        // System.out.println(m.isArmstrong(371));
    }

}