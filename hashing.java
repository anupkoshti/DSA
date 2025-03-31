import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // precompute
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int freq = 0;
            if (mp.containsKey(key))
                freq = mp.get(key);
            freq++;
            mp.put(key, freq);
        }
        // int hash[] = new int[13];
        // for(int i=0;i<n;i++){
        // hash[arr[i]]++;
        // }
        // Iterate over the map:

        for (Map.Entry<Integer, Integer> it : mp.entrySet()) {
            System.out.println(it.getKey() + "->" + it.getValue());
        }

        int q = sc.nextInt();
        while (q-- > 0) {
            int number = sc.nextInt();
            // fetch
            // System.out.println(hash[number]);
            if (mp.containsKey(number))
                System.out.println(mp.get(number));
            else
                System.out.println(0);
        }
        // int a = 'f'-'a';
        // System.out.println(a);

    }

}
