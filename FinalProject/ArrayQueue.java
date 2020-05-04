package FinalProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

//Matt K
//why is there a list at all?
//Does the toString() work?


public class ArrayQueue<AnyType> implements QueueADT<AnyType> {
	private static final int DEFAULT_CAPACITY = 10;

	int cap;
	int size; // size of ArrayQueue itself, NOT the ArrayList list.
	int front;
	int back;
	private AnyType[] A;

	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		cap = DEFAULT_CAPACITY;
		A = (AnyType[]) new Object[DEFAULT_CAPACITY];
		back = -1;
		front = 0;
		size = 0;
	}

	public AnyType dequeue() {
		AnyType e = A[front];
		A[front % cap] = null;
		front++;
		size--;
		return e;
	}

	public void enqueue(AnyType value) {
		if (isFull())
			doubleSize();
		back++;
		A[back % cap] = value;
		size++;
	}

	public AnyType peek() {
		if (isEmpty())
			return null;
		return A[front];
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
		return size == 0; // Return isEmpty() for this ArrayQueue, NOT the Array
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


    //@Author: Matt K
    @Override
	public String toString() {
		if (this.isEmpty())
			return "[]";
		else if (this.size() == 1)
			return "[" + this.peek() + "]";
        else {
            int f = front;
            int b = back;
		    String s = "[" + A[f]; 
			while (f != b) {
                f = (f + 1) % cap;
				s += ", " + A[f];
               
			}	
	    	return s + "]";

        }
	}



	public Iterator<AnyType> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<AnyType> {
		private int index; // traversal index

		public QueueIterator() {
			index = front;
		}

		public boolean hasNext() {
			return index <= back;
		}

		public AnyType next() {
			return A[(index++) % cap];
		}

		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}
	}

	@Override
	public void add(AnyType value) {
		// Use enqueue()
	}

    /*
    @Author Matt K
    removes an element in the queue (not the head)
    I changed the ADT this would be usefull for renege/balk etc
    */
	@Override
	public AnyType remove(int r) {
        //remove the relative index 
        if (r > cap){
            return null;
        }
        AnyType tmp = A[front + r]; 	
	    for (int i = 0; i < cap-r; i++ )
        {    
            A[(front + r + i) % cap  ]=A[(front + r + i+ 1) %cap];
        }	
        back--;
        return tmp;
	}

	public AnyType getAnyTypeAt(int index){
		return A[front + index];
	}
}



