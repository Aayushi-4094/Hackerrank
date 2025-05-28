import java.util.*;

public class JavaDequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> freqMap = new HashMap<>();

        int n = in.nextInt();
        int m = in.nextInt();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, freqMap.size());

                int first = deque.removeFirst();
                int count = freqMap.get(first);
                if (count == 1) {
                    freqMap.remove(first);
                } else {
                    freqMap.put(first, count - 1);
                }
            }
        }

        System.out.println(maxUnique);
    }
}
