public class Main {
    public static void main(String[] args) {
        System.out.println("=== Prueba de Queue normal (FIFO) ===");
        Queue queue = new Queue();
        System.out.println("¿Está vacía? " + queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue("Juan");
        queue.enqueue(true);
        System.out.println(queue.toString());
        System.out.println("Tamaño: " + queue.getSize());
        System.out.println("Peek: " + queue.peek());

        Object desencolado = queue.dequeue();
        System.out.println("Se desencoló: " + desencolado);
        System.out.println(queue.toString());
        System.out.println("Tamaño: " + queue.getSize());

        queue.clear();
        System.out.println("Después de clear: " + queue.toString());
        System.out.println("¿Está vacía? " + queue.isEmpty());

        System.out.println();
        System.out.println("=== Prueba de Queue de prioridad ===");
        Queue colaPrioridad = new Queue(true);
        colaPrioridad.enqueue("Tarea normal", 1);
        colaPrioridad.enqueue("Tarea urgente", 5);
        colaPrioridad.enqueue("Tarea media", 3);
        colaPrioridad.enqueue("Otra urgente", 5);
        System.out.println(colaPrioridad.toString());

        Object primero = colaPrioridad.dequeue();
        System.out.println("Se desencoló: " + primero);
        System.out.println(colaPrioridad.toString());
        System.out.println("Tamaño: " + colaPrioridad.getSize());
    }
}