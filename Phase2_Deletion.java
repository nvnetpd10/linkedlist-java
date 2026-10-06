// ============================================================
// PHASE 2 (part 2): Deletion + Search + Size
// Poori Singly LinkedList ab complete ho jayegi
// ============================================================

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // ---------- ADDING (Phase 2 se) ----------
    void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // ---------- DELETION (naya) ----------

    // 1) deleteFirst: pehla node hatao
    void deleteFirst() {
        if (head == null) {                 // khali list
            System.out.println("List khali hai, kuch delete nahi hua");
            return;
        }
        head = head.next;                   // head ko aage sarkao
    }

    // 2) deleteLast: aakhri node hatao
    void deleteLast() {
        if (head == null) {                 // khali list
            System.out.println("List khali hai, kuch delete nahi hua");
            return;
        }
        if (head.next == null) {            // sirf 1 node
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {    // second-last node tak jao
            temp = temp.next;
        }
        temp.next = null;                   // last node ka connection toda
    }

    // 3) deleteAtPosition: diye hue index wala node hatao (0 se shuru)
    void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List khali hai");
            return;
        }
        if (pos == 0) {                     // pehla node hi hatana hai
            head = head.next;
            return;
        }
        Node temp = head;
        // pos se EK PEHLE wale node tak jao
        for (int i = 0; i < pos - 1; i++) {
            if (temp.next == null) {        // position list se bahar hai
                System.out.println("Position galat hai (list choti hai)");
                return;
            }
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Position galat hai");
            return;
        }
        temp.next = temp.next.next;         // beech wale ko bypass kardo
    }

    // ---------- SEARCH ----------
    // element mila to uska index, warna -1
    int search(int key) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == key) {
                return index;               // mil gaya
            }
            temp = temp.next;
            index++;
        }
        return -1;                          // nahi mila
    }

    // ---------- SIZE ----------
    int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // ---------- PRINT ----------
    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println(" -> null");
    }
}

public class Phase2_Deletion {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        System.out.println("Shuruaati list:");
        list.print();                        // 10 -> 20 -> 30 -> 40 -> 50 -> null
        System.out.println("Size: " + list.size());

        System.out.println("\n--- deleteFirst() ---");
        list.deleteFirst();
        list.print();                        // 20 -> 30 -> 40 -> 50 -> null

        System.out.println("\n--- deleteLast() ---");
        list.deleteLast();
        list.print();                        // 20 -> 30 -> 40 -> null

        System.out.println("\n--- deleteAtPosition(1) [20,30,40 me se index 1 = 30] ---");
        list.deleteAtPosition(1);
        list.print();                        // 20 -> 40 -> null

        System.out.println("\n--- search(40) ---");
        int idx = list.search(40);
        System.out.println("40 mila index pe: " + idx);

        System.out.println("\n--- search(99) [list me nahi hai] ---");
        System.out.println("99 ka result: " + list.search(99));

        System.out.println("\nFinal size: " + list.size());
    }
}
