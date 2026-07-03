/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    HashMap<Node,Node> h = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        
        return copy(head);
    }

    public Node copy(Node par){
        if(par == null){
            return null;
        }

        if(h.containsKey(par)){
            return h.get(par);
        }

        Node child = new Node(par.val);
        h.put(par,child);
        child.next = copy(par.next);
        child.random = copy(par.random);

        return child;
    }
}
