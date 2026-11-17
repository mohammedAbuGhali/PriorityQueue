package PriorityQueue;

public class PriorityQueue<T> {

    private class Node<T> {
         // avariabeles
        T data;
        int Priority; // الاولوية
        Node<T> next;
         // methods
        public Node(T data, int Pri) {
            this.data = data;
            this.Priority = Pri;
            this.next = null;
        }

    }
    // avariabeles
    private Node<T> head;
      // methodes
    public PriorityQueue() {
        this.head = null;
    }

    public void add(T item, int pri) { // عشان اضيف العنصر مع اولويته
        Node<T> newNode = new Node<T>(item, pri);
        if (head == null || pri < head.Priority) { // اولوية العصر الجديد اقل من اولوية العنصر الي بالهيد 
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null && current.next.Priority <= pri) {
                current = current.next; //وامشي خطوة current خزنيا في 
            }
            newNode.next = current.next; //current مشي خطوة عتن ال 
            current.next = newNode; // هيك انضاف عنصر جديد

        }

    }

    public T poll() {// لازالة العنصر ذو الاولوية الاعلى
        if (isEmpty()) {
            System.out.println("PriorityQueue is Empty");
            return null;
        }
        T data = this.head.data;
        head=head.next; // قدم خطوة( لازالة العنصر ذو الاولوية الاعلى) 
        return data;
    }

    public T peek() { // الحصول علة العنصر دون ازالته
        if (isEmpty()) {
            System.out.println("PriorityQueue is Empty");
            return null;
        }
        return head.data;
    }

    public boolean isEmpty() {
        return this.head == null;

    }

    public static void main(String[] args) {
        PriorityQueue<String> colors = new PriorityQueue<>();
        colors.add("Red", 0);
        colors.add("Black", 2);
        colors.add("White", -1);
        colors.poll();// لازالة العنصر ذو الاولوية الاعلى
        System.out.println("Head : " + colors.peek());
    }
}
