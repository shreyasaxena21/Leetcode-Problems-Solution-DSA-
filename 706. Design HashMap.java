class Node{
    int key;
    int value;
    Node next;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
} 

class MyHashMap {
    private int size;
    private Node buckets[];

    public MyHashMap() {
        size = 1000;
        buckets = new Node[size];
        
    }

    int hash(int key){
        return key % size;
    }
    
    public void put(int key, int value) {
        int index = hash(key);

        if(buckets[index] == null){
            buckets[index] = new Node(key, value);
            return;
        }

        Node curr = buckets[index];
        while(curr!=null){
            if(curr.key==key){
                curr.value = value;
                return;
            }

            if(curr.next == null){
                curr.next = new Node(key, value);

            }

            curr = curr.next;
        }
        
    }
    
    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        while(curr!=null){
            if(curr.key==key){
                return curr.value;
            }
            curr = curr.next;
            
        }

        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        if(curr==null){
            return;
        }
        if(curr.key == key){
            buckets[index] = curr.next;
            return;
        }
        while(curr.next!=null){
            if(curr.next.key == key){
                curr.next = curr.next.next;
                return;
            }

            curr = curr.next;
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */