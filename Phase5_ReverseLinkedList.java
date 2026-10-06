// ============================================================
// PHASE 5 - Problem 1: Reverse a LinkedList (sabse famous!)
// Trick: 3 pointers -> prev, curr, next
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

    // ---------- REVERSE (asli hero) ----------
    void reverse() {
        Node prev = null;      // shuru me pichhla kuch nahi
        Node curr = head;      // curr head se shuru

        while (curr != null) {
            Node next = curr.next;   // 1. agla yaad rakho (taaki link na kho jaye)
            curr.next = prev;        // 2. arrow ULTA karo (curr ab prev ko point)
            prev = curr;             // 3. prev ko aage sarkao
            curr = next;             // 4. curr ko aage sarkao
        }
        head = prev;           // ab prev last node pe hai = naya head
    }
}

public class Phase5_ReverseLinkedList {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        System.out.println("Original:");
        list.print();              // 10 -> 20 -> 30 -> 40 -> null

        list.reverse();

        System.out.println("\nReversed:");
        list.print();              // 40 -> 30 -> 20 -> 10 -> null
    }
}
