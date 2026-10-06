// ============================================================
// PHASE 2: Apni khud ki LinkedList class
// 2 class: Node (dabba) + LinkedList (manager)
// ============================================================

// ---------- Class 1: Node (ek dabba) ----------
class Node {
    int data;    // value
    Node next;   // agle node ka pata

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// ---------- Class 2: LinkedList (poori list sambhalegi) ----------
class LinkedList {
    Node head;   // sirf head rakhega, baaki kaam methods karenge

    // 1) addFirst: nayi node ko sabse aage jodo
    void addFirst(int value) {
        Node newNode = new Node(value);   // nayi node banao
        newNode.next = head;              // naye ka next = purani list
        head = newNode;                   // ab head = naya node
    }

    // 2) addLast: nayi node ko sabse peeche jodo
    void addLast(int value) {
        Node newNode = new Node(value);

        if (head == null) {        // list khali hai?
            head = newNode;        // to naya hi head ban jayega
            return;
        }

        Node temp = head;          // last node dhoondhne chalo
        while (temp.next != null) {// jab tak aage node hai
            temp = temp.next;      // aage badho
        }
        temp.next = newNode;       // last node ke next me jodo
    }

    // 3) print: poori list dikhao
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

// ---------- Main: yahan class ko use karenge ----------
public class Phase2_LinkedList {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();   // nayi khali list

        System.out.println("--- addLast se jodte hain ---");
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.print();            // 10 -> 20 -> 30 -> null

        System.out.println("\n--- addFirst(5) karte hain ---");
        list.addFirst(5);
        list.print();            // 5 -> 10 -> 20 -> 30 -> null

        System.out.println("\n--- addFirst(1) aur addLast(99) ---");
        list.addFirst(1);
        list.addLast(99);
        list.print();            // 1 -> 5 -> 10 -> 20 -> 30 -> 99 -> null
    }
}
