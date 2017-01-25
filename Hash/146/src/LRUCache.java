import java.util.HashMap;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2, 1);
        lruCache.set(2, 2);
        System.out.println(lruCache.get(2));
        lruCache.set(1, 1);
        lruCache.set(4, 1);
        System.out.println(lruCache.get(2));
    }

    public class DoublyListNode {
        DoublyListNode prev;
        DoublyListNode next;
        int key;
        int value;

        public DoublyListNode(DoublyListNode prev, DoublyListNode next, int key, int value) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }

    public class DoublyLinkedList {
        DoublyListNode head;
        DoublyListNode tail;
        int len;

        public DoublyLinkedList() {
            this.head = this.tail = null;
            this.len = 0;
        }

        private void append(DoublyListNode node) {
            if (node != null) {
                if(this.head == null) {
                    this.head = this.tail = node;
                    node.next = null;
                } else {
                    this.tail.next = node;
                    node.prev = this.tail;
                    node.next = null;
                    this.tail = node;
                }
                this.len++;
            }
        }

        private void deleteHead() {
            if(this.len > 1) {
                this.head = this.head.next;
            } else if(this.len == 1) {
                this.head = this.tail = null;
            }
            this.len--;
        }

        private void delete(DoublyListNode node) {
            if(node != null) {
                if(node == head) {
                    deleteHead();
                } else {
                    if(node.next != null) {
                        node.prev.next = node.next;
                        node.next.prev = node.prev;
                    } else {
                        node.prev.next = null;
                        this.tail = node.prev;
                    }
                    this.len--;
                }
            }
        }

        private void moveNodeToTail(DoublyListNode node) {
            if(this.len > 1) {
                if(node == this.head) {
                    deleteHead();
                    append(node);
                } else if(node != this.tail) {
                    delete(node);
                    append(node);
                }
            }
        }
    }

    HashMap<Integer, DoublyListNode> hashMap;
    DoublyLinkedList doublyLinkedList;
    int capacity;

    public LRUCache(int capacity) {
        this.hashMap = new HashMap<>();
        this.doublyLinkedList = new DoublyLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        DoublyListNode node = hashMap.get(key);
        if(node != null) {
            doublyLinkedList.moveNodeToTail(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if(hashMap.get(key) != null) {
            DoublyListNode node = hashMap.get(key);
            doublyLinkedList.moveNodeToTail(node);
            node.value = value;
        } else {
            DoublyListNode doublyListNode = new DoublyListNode(doublyLinkedList.tail, null, key, value);
            if(hashMap.size() < capacity) {
                doublyLinkedList.append(doublyListNode);
                hashMap.put(key, doublyListNode);
            } else {
                DoublyListNode head = doublyLinkedList.head;
                if (head != null) {
                    hashMap.remove(head.key);
                    doublyLinkedList.deleteHead();
                    doublyLinkedList.append(doublyListNode);
                    hashMap.put(key, doublyListNode);
                }
            }
        }
    }
}
