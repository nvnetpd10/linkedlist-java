// ============================================================
// PHASE 1: Node kya hai? LinkedList ka building block
// ============================================================

// Ye hamara "Node" hai - LinkedList ka ek dabba
class Node {
    int data;    // dabbe ke andar ki value (jaise 10, 20, 30)
    Node next;   // agle Node ka pata (address/reference)

    // Constructor: jab naya Node banega, data set ho jayega
    // aur next apne aap null ho jayega (abhi kisi se juda nahi)
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Phase1_Node {
    public static void main(String[] args) {

        // Step 1: Teen alag-alag Node banaye (abhi ye jude nahi hain)
        Node first  = new Node(10);
        Node second = new Node(20);
        Node third  = new Node(30);

        // Abhi teeno alag hain:
        // [10 | null]   [20 | null]   [30 | null]
        System.out.println("Abhi teeno node alag hain (next = null)");
        System.out.println("first.data  = " + first.data  + ", first.next  = " + first.next);
        System.out.println("second.data = " + second.data + ", second.next = " + second.next);
        System.out.println("third.data  = " + third.data  + ", third.next  = " + third.next);

        System.out.println("\n--- Ab inko jodte hain (chain banate hain) ---\n");

        // Step 2: Nodes ko jodo (chain banao)
        first.next  = second;   // first ab second ko point karega
        second.next = third;    // second ab third ko point karega
        // third.next abhi bhi null hai (list ka end)

        // Ab chain aisi dikhti hai:
        // [10 | *]-->[20 | *]-->[30 | null]

        // Step 3: HEAD se list ko ghoomo (traverse) aur print karo
        Node head = first;      // head hamesha pehle node ko point karta hai
        Node temp = head;       // temp se ghoomenge taaki head safe rahe

        System.out.print("LinkedList: ");
        while (temp != null) {           // jab tak null na aaye
            System.out.print(temp.data); // current node ka data print
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;            // agle node pe jump
        }
        System.out.println(" -> null");
    }
}



// javac Phase1_Node.java && java Phase1_Node
// Abhi teeno node alag hain (next = null)
// first.data  = 10, first.next  = null
// second.data = 20, second.next = null
// third.data  = 30, third.next  = null

// --- Ab inko jodte hain (chain banate hain) ---

// LinkedList: 10 -> 20 -> 30 -> null