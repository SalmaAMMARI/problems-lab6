package problem4;

import java.util.*;

public class ListPerformanceComparison {

    private static final int SIZE = 100_000;        // total elements
    private static final int OPERATIONS = 10_000;   // random operations to test

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("---- Performance Comparison ----");

        System.out.println("---- Populate both lists ----");
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // 2️⃣ Random insertions and deletions
        testRandomInsertDelete(arrayList, "ArrayList");
        testRandomInsertDelete(linkedList, "LinkedList");

        // 3️⃣ Sequential insertions/deletions at beginning and end
        testSequentialInsertDelete(arrayList, "ArrayList");
        testSequentialInsertDelete(linkedList, "LinkedList");

        // 4️⃣ Random access test
        testRandomAccess(arrayList, "ArrayList");
        testRandomAccess(linkedList, "LinkedList");
    }

    // ------------------------------------------------------------

    private static void testRandomInsertDelete(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        for (int i = 0; i < OPERATIONS; i++) {
            int index = random.nextInt(list.size());

            // Randomly choose between insert and delete
            if (random.nextBoolean()) {
                list.add(index, i); // Insert at random position
            } else {
                if (!list.isEmpty()) {
                    list.remove(index); // Remove from random position
                }
            }
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random insert/delete: %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testSequentialInsertDelete(List<Integer> list, String name) {
        long start = System.nanoTime();

        // Insertions at beginning and end
        for (int i = 0; i < OPERATIONS / 4; i++) {
            list.add(0, i); // Insert at beginning
            list.add(i);     // Insert at end
        }

        // Deletions at beginning and end
        for (int i = 0; i < OPERATIONS / 4; i++) {
            if (!list.isEmpty()) {
                list.remove(0); // Remove from beginning
            }
            if (!list.isEmpty()) {
                list.remove(list.size() - 1); // Remove from end
            }
        }

        long end = System.nanoTime();
        System.out.printf("%s - Sequential insert/delete (start/end): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testRandomAccess(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        long sum = 0;
        // Sum of all elements accessed randomly
        for (int i = 0; i < OPERATIONS; i++) {
            int index = random.nextInt(list.size());
            sum += list.get(index);
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random access (get): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }
    /*
========================= OVERALL Conclusion =========================

1️/Random Insert/Delete
   - ArrayList: slower because it needs to shift all subsequent elements after insertion/deletion (O(n)).
   - LinkedList: faster because it only changes node pointers (O(1) for local updates).

2️/ Sequential Insert/Delete (beginning and end)
   - Beginning: LinkedList performs better (O(1)) since no shifting is needed.
   - End: ArrayList performs slightly better (amortized O(1)) due to its contiguous memory layout.

3️/ Random Access (get)
   - ArrayList: much faster (O(1)) (direct memory access using an index).
   - LinkedList: much slower (O(n)) ( must traverse the list from start or end to reach the index.)

Conclusion:
   - Use ArrayList  when frequent random access or end insertions/removals are required.
   - Use LinkedList when frequent insertions or deletions occur at the beginning or middle.

===================================================================
*/
}