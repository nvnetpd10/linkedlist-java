// ============================================================
// PHASE 5 - Problem 2: Find Middle Element
// Trick: Slow-Fast Pointer (Tortoise 🐢 & Hare 🐇)
// slow 1 kadam, fast 2 kadam -> fast end pe, slow middle pe
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

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println(" -> null");
    }

    // ---------- FIND MIDDLE (slow-fast) ----------
    int findMiddle() {
        Node slow = head;   // 🐢 ek-ek kadam
        Node fast = head;   // 🐇 do-do kadam

        // fast aur fast.next dono null nahi hone chahiye (warna crash)
        while (fast != null && fast.next != null) {
            slow = slow.next;        // slow 1 kadam
            fast = fast.next.next;   // fast 2 kadam
        }
        // loop khatam -> slow middle pe
        return slow.data;
    }
}

public class Phase5_FindMiddle {
    public static void main(String[] args) {

        // Odd length list (5 elements) -> ek clear middle
        LinkedList list1 = new LinkedList();
        list1.addLast(10);
        list1.addLast(20);
        list1.addLast(30);
        list1.addLast(40);
        list1.addLast(50);
        System.out.print("List (odd): ");
        list1.print();
        System.out.println("Middle: " + list1.findMiddle());   // 30

        // Even length list (4 elements) -> 2 middle, ye 2nd dega
        LinkedList list2 = new LinkedList();
        list2.addLast(10);
        list2.addLast(20);
        list2.addLast(30);
        list2.addLast(40);
        System.out.print("\nList (even): ");
        list2.print();
        System.out.println("Middle: " + list2.findMiddle());   // 30 (2nd middle)
    }
}
