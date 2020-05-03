package FinalProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class ArrayQueue<AnyType> implements QueueADT<AnyType> {
	private static final int DEFAULT_CAPACITY = 10;
	
	List<AnyType> list;
	int cap;
	int size; // size of ArrayQueue itself, NOT the ArrayList list.
	int front;
	int back;
	private AnyType[] A;

	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		list = new ArrayList<AnyType>();
		cap = DEFAULT_CAPACITY;
		A = (AnyType[]) new Object[DEFAULT_CAPACITY];
		back = -1;
		front = 0;
		size = 0;
	}

	public AnyType dequeue() {
		AnyType e = peek();
		A[front % cap] = null;
		front++;
		size--;
		return e;
//		if (size == 0)
//			return null;
//		AnyType result = list.get(front);
//		size--;
//		front = (front + 1) % list.size();
//		return result;
	}

	public void enqueue(AnyType value) {
		if (isFull())
			doubleSize();
		back++;
		A[back % cap] = value;
		size++;
//		if (size == list.size()) { // insert
//			list.add(back, value);
//			front = (front + 1) % list.size();
//		} else
//			list.set(back, value);
//		back = (back + 1) % list.size();
//		size++;
	}

	public AnyType peek() {
		if (isEmpty())
			return null;
		return list.get(front);
	}

	public int size() {
		return size; // Return the size for this ArrayQueue, NOT the ArrayList list.
	}

	public void clear() {
		for (int i = 0; i < cap; i++)
			A[i] = null;
		size = 0;
		back = -1;
		front = 0;
	}

	public boolean isEmpty() {
		return size == 0; // Return isEmpty() for this ArrayQueue, NOT the ArrayList list.
	}

	public boolean isFull() {
		return size == cap;
	}

	private void doubleSize() {
		AnyType[] newArray = (AnyType[]) new Object[2 * cap];
		for (int i = front; i <= back; i++)
			newArray[i - front] = A[i % cap];
		A = newArray;
		front = 0;
		back = size - 1;
		cap *= 2;
	}

	@Override
	public String toString() {
		if (this.isEmpty())
			return "[]";
		if (this.size() == 1)
			return "[" + this.peek() + "]";
		ArrayQueue<AnyType> temp = this;
		String s = "[" + temp.dequeue();
		if (temp.front < temp.back) {
			while (temp.front != temp.back) {
				s += ", " + temp.dequeue();
			}
		} else {
			while (temp.front != temp.back) {
				s += ", " + temp.peek();
				front = (front + 1) % temp.size();
			}
		}
		return s + "]";
	}

	public Iterator<AnyType> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<AnyType> {
		private int index; // traversal index

		/**
		 * Create a new empty iterator.
		 */
		public QueueIterator() {
			index = front;
		}

		/**
		 * Tests if there are more items in the Queue
		 *
		 */
		public boolean hasNext() {
			return index <= back;
		}

		/**
		 * Returns the next item in the Queue.
		 *
		 */
		public AnyType next() {
			return A[(index++) % cap];
		}

		/**
		 * Remove is not implemented
		 *
		 */
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}
	}

	public static void main(String[] args) {
		ArrayQueue<String> Q = new ArrayQueue<String>();

		String[] people = { "Tom", "Jay", "Pat", "Meghan", "Tom", "Mark", "Kasey", "John", "Helen" };

		for (int i = 0; i < people.length; i++)
			Q.enqueue(people[i]);

		for (int i = 0; i < 2; i++)
			Q.dequeue();

		Iterator itr = Q.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());

		System.out.println("=================");

		Q.enqueue("Mike");
		Q.enqueue("Bev");

		itr = Q.iterator();
		while (itr.hasNext())
			System.out.print(itr.next() + " ");

		System.out.println();
	}

	@Override
	public void add(AnyType value) {
		// Use enqueue()
	}

	@Override
	public AnyType remove() {
		// use dequeue()
		return null;
	}
}