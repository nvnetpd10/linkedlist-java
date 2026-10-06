// ============================================================
// PHASE 3 (part 2): Circular LinkedList (gol chakra)
// Last node ka next -> wapis HEAD ko point karta hai (null nahi!)
// ============================================================

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;
    Node tail;   // last node (taaki chakra band karna aasan ho)

    // 1) addLast: node ko end me jodo, aur chakra band rakho
    void addLast(int value) {
        Node newNode = new Node(value);

        if (head == null) {          // khali list
            head = newNode;
            tail = newNode;
            newNode.next = head;     // apne aap ko point (ek node ka chakra)
            return;
        }
        tail.next = newNode;         // purane tail ko naye se jodo
        newNode.next = head;         // naye ka next -> WAPIS head (chakra!)
        tail = newNode;              // tail update
    }

    // 2) addFirst: node ko shuru me jodo
    void addFirst(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            return;
        }
        newNode.next = head;         // naye ka next = purana head
        head = newNode;              // head ab naya
        tail.next = head;            // tail ka next -> naya head (chakra band)
    }

    // 3) deleteFirst: pehla node hatao
    void deleteFirst() {
        if (head == null) {
            System.out.println("List khali hai");
            return;
        }
        if (head == tail) {          // sirf 1 node
            head = null;
            tail = null;
            return;
        }
        head = head.next;            // head aage sarko
        tail.next = head;            // tail ka next -> naya head (chakra band rakho)
    }

    // 4) print: chakra ghoomo (DHYAAN: null nahi aata!)
    void print() {
        if (head == null) {
            System.out.println("List khali hai");
            return;
        }
        Node temp = head;
        do {                              // do-while: pehli baar to chalega hi
            System.out.print(temp.data);
            if (temp.next != head) System.out.print(" -> ");
            temp = temp.next;
        } while (temp != head);           // jab tak wapis head na aa jaye
        System.out.println(" -> (wapis head)");
    }
}

public class Phase3_CircularLinkedList {
    public static void main(String[] args) {

        CircularLinkedList list = new CircularLinkedList();

        System.out.println("--- addLast(10,20,30) ---");
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.print();

        System.out.println("\n--- addFirst(5) ---");
        list.addFirst(5);
        list.print();

        System.out.println("\n--- deleteFirst() ---");
        list.deleteFirst();
        list.print();

        // Proof ki ye sach me circular hai (tail ka next = head)
        System.out.println("\n--- Proof: tail ka next kya hai? ---");
        System.out.println("tail ka data  = " + list.tail.data);
        System.out.println("tail.next ka data = " + list.tail.next.data + "  (ye head hai!)");
    }
}
