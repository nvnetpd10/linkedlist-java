// ============================================================
// PHASE 3: Doubly LinkedList (dono direction)
// Har node ke paas 2 pata: prev (pichhla) + next (agla)
// ============================================================

// Node me ab 3 cheezein: prev + data + next
class Node {
    int data;
    Node prev;   // pichhle node ka pata (NAYA!)
    Node next;   // agle node ka pata

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;   // pehla node
    Node tail;   // aakhri node (taaki addLast/deleteLast fast ho)

    // 1) addFirst: node ko sabse aage jodo
    void addFirst(int value) {
        Node newNode = new Node(value);

        if (head == null) {              // khali list
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;             // naye ka next = purana head
        head.prev = newNode;             // purane head ka prev = naya
        head = newNode;                  // head ab naya node
    }

    // 2) addLast: node ko sabse peeche jodo
    void addLast(int value) {
        Node newNode = new Node(value);

        if (head == null) {              // khali list
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;             // purane tail ka next = naya
        newNode.prev = tail;             // naye ka prev = purana tail
        tail = newNode;                  // tail ab naya node
    }

    // 3) deleteFirst: pehla node hatao
    void deleteFirst() {
        if (head == null) {
            System.out.println("List khali hai");
            return;
        }
        if (head == tail) {              // sirf 1 node
            head = null;
            tail = null;
            return;
        }
        head = head.next;                // head aage sarko
        head.prev = null;                // naye head ka prev = null
    }

    // 4) deleteLast: aakhri node hatao (Doubly me AASAN!)
    void deleteLast() {
        if (head == null) {
            System.out.println("List khali hai");
            return;
        }
        if (head == tail) {              // sirf 1 node
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;                // tail peeche sarko (prev ki wajah se seedha!)
        tail.next = null;                // naye tail ka next = null
    }

    // 5) print: aage se (head -> tail)
    void print() {
        Node temp = head;
        System.out.print("Aage se:   null <- ");
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" <-> ");
            temp = temp.next;
        }
        System.out.println(" -> null");
    }

    // 6) printReverse: peeche se (tail -> head) -- Doubly ka JAADU!
    void printReverse() {
        Node temp = tail;
        System.out.print("Peeche se: null <- ");
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.prev != null) System.out.print(" <-> ");
            temp = temp.prev;            // prev ki wajah se peeche ja sakte hain!
        }
        System.out.println(" -> null");
    }
}

public class Phase3_DoublyLinkedList {
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        System.out.println("--- addLast(10,20,30) ---");
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.print();

        System.out.println("\n--- addFirst(5) ---");
        list.addFirst(5);
        list.print();
        list.printReverse();             // peeche se bhi dikhao!

        System.out.println("\n--- deleteFirst() ---");
        list.deleteFirst();
        list.print();

        System.out.println("\n--- deleteLast() ---");
        list.deleteLast();
        list.print();
        list.printReverse();
    }
}
