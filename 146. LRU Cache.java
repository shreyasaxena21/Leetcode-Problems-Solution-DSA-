class LRUCache {

    private class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    Map<Integer, Node> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache =  new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node==null){
            return -1;
        }

        moveToHead(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node==null){
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);

            if(cache.size()>capacity){
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
        }

        else{
            node.value = value;
            cache.put(key, node);
            moveToHead(node);

        }
    }

    public void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void addNode(Node node){
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }

    public void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */