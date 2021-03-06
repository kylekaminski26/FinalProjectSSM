package FinalProject;

public class testArrayQueue {

    public static void main(String[] args){
        System.out.println("\n");

        ArrayQueue queue = new ArrayQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
	queue.enqueue(4);
	queue.enqueue(5);
	queue.enqueue(6);
	queue.enqueue(7);
	queue.enqueue(8);
	queue.enqueue(9);
	System.out.println(queue.getIndexOf(5));
        System.out.println("Getting at index 6 (after remove): " + queue.getAnyTypeAt(6));
        System.out.println(queue.toString());
	queue.remove(5);
        System.out.println("Getting at index 6 (after remove): " + queue.getAnyTypeAt(6));
        System.out.println(queue.size());
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
    }
}
