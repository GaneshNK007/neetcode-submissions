class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

    int capacity;
    HashMap<Integer,Node> m;
    Node head;
    Node tail;

    public void delete(Node n){
        
        n.prev.next = n.next;
        n.next.prev = n.prev;

        n.prev=null;
        n.next=null;

    }

    public void insert(Node n){
        
        n.next=head.next;
        n.prev=head;

        head.next.prev=n;
        head.next=n;
    }

    public LRUCache(int capacity) {
        this.capacity=capacity;
        m=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);

        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!m.containsKey(key)) return -1;

        Node n=m.get(key);
        int v=n.val;
        delete(n);
        insert(n);

        return v;
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node no=m.get(key);
            no.val=value;

            delete(no);
            insert(no);
            return;
        }
        if(m.size()==capacity){
            Node lru=tail.prev;
            delete(lru);
            m.remove(lru.key);
        }

        Node n=new Node(key,value);

        m.put(key,n);
        insert(n);

    }
}
