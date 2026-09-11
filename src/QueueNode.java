public class QueueNode {

    Object object;
    int priority;
    QueueNode next;

    public QueueNode() {
        this.object = null;
        this.priority = 0;
        this.next = null;
    }

    public QueueNode(Object object) {
        this.object = object;
        this.priority = 0;
        this.next = null;
    }

    public QueueNode(Object object, int priority) {
        this.object = object;
        this.priority = priority;
        this.next = null;
    }
}