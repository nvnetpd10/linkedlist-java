// ============================================================
// PHASE 5 - Problem 3: Detect Loop/Cycle
// Floyd's Cycle Algorithm (slow-fast pointer 🐢🐇)
// Agar slow aur fast mil jaye -> loop hai!
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

    void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    // ---------- DETECT LOOP (Floyd's) ----------
    boolean hasLoop() {
        Node slow = head;   // 🐢 1 kadam
        Node fast = head;   // 🐇 2 kadam

        while (fast != null && fast.next != null) {
            slow = slow.next;        // 1 kadam
            fast = fast.next.next;   // 2 kadam

            if (slow == fast) {      // dono mil gaye?
                return true;         // LOOP HAI!
            }
        }
        return false;   // fast null pe pahunch gaya -> LOOP NAHI
    }

    // Jaan-boojh ke loop banane ke liye (testing hetu)
    // last node ko diye hue position wale node se jod do
    void makeLoopAt(int value) {
        Node loopNode = null;
        Node temp = head;
        Node last = head;

        // loopNode dhoondo (jisse jodna hai) + last node dhoondo
        while (temp != null) {
            if (temp.data == value) loopNode = temp;
            if (temp.next == null) last = temp;
            temp = temp.next;
        }
        last.next = loopNode;   // last ko wapis loopNode se jodo (LOOP!)
    }
}

public class Phase5_DetectLoop {
    public static void main(String[] args) {

        // Case 1: Normal list (koi loop nahi)
        LinkedList list1 = new LinkedList();
        list1.addLast(10);
        list1.addLast(20);
        list1.addLast(30);
        list1.addLast(40);
        System.out.println("List 1 (normal): 10->20->30->40->null");
        System.out.println("Loop hai? " + list1.hasLoop());   // false

        // Case 2: Loop wali list (40 -> wapis 20)
        LinkedList list2 = new LinkedList();
        list2.addLast(10);
        list2.addLast(20);
        list2.addLast(30);
        list2.addLast(40);
        list2.makeLoopAt(20);   // 40 ko 20 se jod diya -> LOOP
        System.out.println("\nList 2 (loop): 10->20->30->40-> wapis 20");
        System.out.println("Loop hai? " + list2.hasLoop());   // true
    }
}
