// ============================================================
// PHASE 5 - Problem 4: Remove Nth Node from End
// Trick: Gap wala slow-fast (ek hi baar list ghoomo)
// fast ko N aage bhejo, phir dono saath chalao
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

    // ---------- REMOVE Nth FROM END ----------
    void removeNthFromEnd(int n) {
        Node slow = head;
        Node fast = head;

        // Step 1: fast ko N kadam aage bhejo (gap banao)
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                System.out.println("N list se bada hai, kuch nahi hua");
                return;
            }
            fast = fast.next;
        }

        // Special case: agar fast ab null hai -> pehla node hi hatana hai
        if (fast == null) {
            head = head.next;
            return;
        }

        // Step 2: dono saath chalao jab tak fast last node pe na ho
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: slow ab "delete wale se ek pehle" pe -> bypass
        slow.next = slow.next.next;
    }
}

public class Phase5_RemoveNthFromEnd {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        System.out.println("Original:");
        list.print();                      // 10 -> 20 -> 30 -> 40 -> 50 -> null

        System.out.println("\n--- Remove 2nd from end (40 hatega) ---");
        list.removeNthFromEnd(2);
        list.print();                      // 10 -> 20 -> 30 -> 50 -> null

        System.out.println("\n--- Remove 1st from end (last=50 hatega) ---");
        list.removeNthFromEnd(1);
        list.print();                      // 10 -> 20 -> 30 -> null

        System.out.println("\n--- Remove 3rd from end (pehla=10 hatega) ---");
        list.removeNthFromEnd(3);
        list.print();                      // 20 -> 30 -> null
    }
}
