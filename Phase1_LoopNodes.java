// ============================================================
// 100 node banane ke liye manual nahi, LOOP use karo!
// ============================================================

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Phase1_LoopNodes {
    public static void main(String[] args) {

        Node head = null;   // shuruaat me list khali hai
        Node temp = null;   // temp hamesha last node ko pakdega

        // Loop se 100 node banao (10, 20, 30, ... 1000)
        for (int i = 1; i <= 100; i++) {

            Node newNode = new Node(i * 10);   // nayi node banayi

            if (head == null) {
                // pehli node: ye hi head banegi
                head = newNode;
                temp = newNode;
            } else {
                // baaki nodes: last node ke next me jodo
                temp.next = newNode;   // jodo
                temp = newNode;        // temp ko aage sarkao (naya last)
            }
        }

        // Ab poori list print karo
        Node curr = head;
        int count = 0;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
            count++;
        }
        System.out.println(" -> null");
        System.out.println("\nTotal nodes bani: " + count);
    }
}
