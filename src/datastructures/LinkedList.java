package datastructures;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
	
	public class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
		
		public Node<T> getNext() {
			return next;
		}
		
		public T getData() {
			return data;
		}
		
		@Override
		public String toString() {
			return "Node: " + data;
		}
	}
	
	private Node<T> head;
	
	public void add(T t) {
		if (head == null) {
			head = new Node<T>(t);
			return;
		}
		
		Node<T> next = head;
		while (next.next != null)
			next = next.next;
		
		next.next = new Node<T>(t);
	}
	
	public void remove(T t) {
		if (head == null || t == null)
			return;
		
		if (head.getData().equals(t)) {
			head = head.next;
			return;
		}
		
		Node<T> next = head;
		while (next.next != null) {
			if (next.next.getData().equals(t)) {
				next.next = next.next.next;
				return;
			}
			next = next.next;
		}
	}
	
	public int size() {
		int i = 0;
		
		Node<T> next = head;
		while (next != null) {
			next = next.next;
			i++;
		}
		
		return i;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> it = new Iterator<T>() {

            private Node<T> next = head;

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public T next() {
            	if (next == null)
            		return null;
            	
            	T data = next.getData();
            	next = next.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		
		Iterator<T> it = this.iterator();
		while(it.hasNext()) {
			str.append(it.next());
			
			if (it.hasNext())
				str.append(",");
		}
		
		str.append("]");
		return str.toString();
	}
}
