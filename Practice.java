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
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        leftRotateByDPlaces1(arr, 2);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
