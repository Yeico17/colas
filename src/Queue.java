public class Queue implements QueueInterface {

    QueueNode head;
    QueueNode tail;
    int size = 0;
    boolean isPriorityQueue;

    public Queue() {
        this.isPriorityQueue = false;
    }

    public Queue(boolean isPriorityQueue) {
        this.isPriorityQueue = isPriorityQueue;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean insert(Object object) {
        return insert(object, 0);
    }

    @Override
    public boolean insert(Object object, int prioridad) {
        try {
            QueueNode nuevo = new QueueNode(object, prioridad);
            if (!this.isPriorityQueue) {
                if (this.head == null) {
                    this.head = nuevo;
                    this.tail = nuevo;
                } else {
                    this.tail.next = nuevo;
                    this.tail = nuevo;
                }
            } else {
                if (this.head == null || nuevo.priority > this.head.priority) {
                    nuevo.next = this.head;
                    this.head = nuevo;
                    if (this.tail == null) {
                        this.tail = nuevo;
                    }
                } else {
                    QueueNode iterador = this.head;
                    while (iterador.next != null && iterador.next.priority >= nuevo.priority) {
                        iterador = iterador.next;
                    }
                    nuevo.next = iterador.next;
                    iterador.next = nuevo;
                    if (nuevo.next == null) {
                        this.tail = nuevo;
                    }
                }
            }
            this.size++;
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public Object extract() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        QueueNode nodoBorrado = this.head;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        this.size--;
        return nodoBorrado.object;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return this.head.object;
    }

    @Override
    public boolean search(Object object) {
        QueueNode iterador = this.head;
        while (iterador != null) {
            if (iterador.object.equals(object)) {
                return true;
            }
            iterador = iterador.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Queue{head->");
        QueueNode iterador = this.head;
        while (iterador != null) {
            sb.append(iterador.object);
            if (this.isPriorityQueue) {
                sb.append("(p").append(iterador.priority).append(")");
            }
            if (iterador.next != null) {
                sb.append(", ");
            }
            iterador = iterador.next;
        }
        sb.append("}");
        return sb.toString();
    }
}
