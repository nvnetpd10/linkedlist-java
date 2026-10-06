// ============================================================
// PHASE 4: Java ki built-in LinkedList (java.util.LinkedList)
// Node/prev/next khud nahi sambhalna - Java sab karta hai!
// ============================================================

import java.util.LinkedList;   // ye import zaruri hai

public class Phase4_BuiltInLinkedList {
    public static void main(String[] args) {

        // Nayi LinkedList banayi (<Integer> matlab isme int values aayengi)
        LinkedList<Integer> list = new LinkedList<>();

        // ---------- ADDING ----------
        System.out.println("--- add() se jodte hain ---");
        list.add(10);          // end me
        list.add(20);
        list.add(30);
        System.out.println(list);         // [10, 20, 30]

        list.addFirst(5);      // shuru me
        list.addLast(40);      // end me
        System.out.println(list);         // [5, 10, 20, 30, 40]

        // ---------- GET / SET ----------
        System.out.println("\n--- get() aur set() ---");
        System.out.println("Index 2 ka element: " + list.get(2));   // 20
        list.set(2, 99);       // index 2 ki value badli
        System.out.println("set(2,99) ke baad: " + list);           // [5,10,99,30,40]

        // ---------- REMOVE ----------
        System.out.println("\n--- remove() ---");
        list.removeFirst();    // pehla hatao
        list.removeLast();     // aakhri hatao
        System.out.println("removeFirst + removeLast ke baad: " + list); // [10,99,30]
        list.remove(1);        // index 1 hatao (99)
        System.out.println("remove(1) ke baad: " + list);           // [10, 30]

        // ---------- SEARCH / INFO ----------
        System.out.println("\n--- search aur info ---");
        System.out.println("Size: " + list.size());                 // 2
        System.out.println("10 hai kya? " + list.contains(10));     // true
        System.out.println("99 hai kya? " + list.contains(99));     // false
        System.out.println("30 ka index: " + list.indexOf(30));     // 1

        // ---------- GHOOMNA (traversal) ----------
        System.out.println("\n--- for-each se ghoomna ---");
        for (int x : list) {
            System.out.print(x + " ");
        }
        System.out.println();

        // peek: dekho par hatao mat
        System.out.println("\nPehla element (peekFirst): " + list.peekFirst());
        System.out.println("Aakhri element (peekLast): " + list.peekLast());
    }
}
