public class Main {
    public static void main(String[] args) {
        System.out.println("=== Prueba de Queue normal (FIFO) ===");
        Queue queue = new Queue();
        System.out.println("¿Está vacía? " + queue.isEmpty());

        queue.insert(1);
        queue.insert("Juan");
        queue.insert(true);
        System.out.println(queue.toString());
        System.out.println("Tamaño: " + queue.size());
        System.out.println("Peek: " + queue.peek());

        Object desencolado = queue.extract();
        System.out.println("Se desencoló: " + desencolado);
        System.out.println(queue.toString());
        System.out.println("Tamaño: " + queue.size());

        queue.clear();
        System.out.println("Después de clear: " + queue.toString());
        System.out.println("¿Está vacía? " + queue.isEmpty());

        System.out.println();
        System.out.println("=== Prueba de Queue de prioridad ===");
        Queue colaPrioridad = new Queue(true);
        colaPrioridad.insert("Tarea normal", 1);
        colaPrioridad.insert("Tarea urgente", 5);
        colaPrioridad.insert("Tarea media", 3);
        colaPrioridad.insert("Otra urgente", 5);
        System.out.println(colaPrioridad.toString());

        Object primero = colaPrioridad.extract();
        System.out.println("Se desencoló: " + primero);
        System.out.println(colaPrioridad.toString());
        System.out.println("Tamaño: " + colaPrioridad.size());
    }
}