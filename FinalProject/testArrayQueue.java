package FinalProject;

public class testArrayQueue {

    public static void main(String[] args){
        System.out.println("n");

        ArrayQueue queue = new ArrayQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.toString());
        queue.remove(2);
        System.out.println(queue.size());
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
    }
}
