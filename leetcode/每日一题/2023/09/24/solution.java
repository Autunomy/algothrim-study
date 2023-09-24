//146. LRU 缓存
class LRUCache {

    Map<Integer,ListNode> map = new HashMap<>();
    ListNode head = null;
    ListNode tail = null;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public void moveToHead(ListNode node){
        if(head.key != node.key){
            if(tail.key == node.key) tail = tail.pre;
            if(node.next != null){
                node.next.pre = node.pre;
            }
            node.pre.next = node.next;

            head.pre = node;
            node.next = head;
            head = node;
        }
    }

    public int get(int key) {
        if(map.get(key) != null){
            ListNode node = map.get(key);

            moveToHead(node);

            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.get(key) == null){
            ListNode node = new ListNode();
            node.key = key;
            node.val = value;
            map.put(key,node);

            if(head == null){
                head = node;
                tail = node;
            }else{
                head.pre = node;
                node.next = head;
                head = node;
            }
        }else{
            ListNode node = map.get(key);
            node.val = value;

            moveToHead(node);
        }

        if(map.size() > capacity){
            ListNode temp = tail;
            tail = tail.pre;
            if(tail != null) tail.next = null;
            else head = null;

            temp.pre = null;
            temp.next = null;

            map.remove(temp.key);
        }
    }
}

class ListNode{
    int key;
    int val;
    ListNode pre;
    ListNode next;
}